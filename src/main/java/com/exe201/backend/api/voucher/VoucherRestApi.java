package com.exe201.backend.api.voucher;

import com.google.gson.Gson;
import com.exe201.backend.api.owner.voucher.VoucherResponse;
import com.exe201.backend.entity.VoucherEntity;
import com.exe201.backend.exception.ApplyVoucherException;
import com.exe201.backend.exception.ErrorResponse;
import com.exe201.backend.model.*;

import com.exe201.backend.service.VoucherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class VoucherRestApi {
    private VoucherService voucherService;
    private Gson gson;

    @PostMapping("owners/{ownerId}/vouchers")
    public ResponseEntity<String> getAllVoucherAvailable(@RequestBody(required = false) SearchModel searchModel, @PathVariable String ownerId) {
        try {
            VoucherResponse response;
            if (searchModel == null) {
                response = voucherService.getAllVoucherForYard(ownerId, null, null);
            } else {
                response = voucherService.getAllVoucherForYard(ownerId, searchModel.getItemsPerPage(), searchModel.getPage());
            }
            return ResponseEntity.ok().body(gson.toJson(response));
        } catch (Exception exception) {
            ErrorResponse errorResponse = ErrorResponse.builder().stack(exception.getMessage()).message("Server busy temp can't create voucher.").build();
            return ResponseEntity.internalServerError().body(gson.toJson(errorResponse));
        }
    }

    @PostMapping("vouchers/{voucherCode}/calculate")
    public ResponseEntity<String> applyVoucherForBooking(@RequestBody(required = false) ApplyVoucherRequest applyVoucherRequest, @PathVariable String voucherCode) {
        try {
            if (applyVoucherRequest == null) {
                ErrorResponse errorResponse = ErrorResponse.builder().message("Missing body.").build();
                return ResponseEntity.badRequest().body(gson.toJson(errorResponse));
            }
            List<BookingModel> listBooking = applyVoucherRequest.getBookingList();
            if (listBooking == null || listBooking.size() == 0) {
                ErrorResponse errorResponse = ErrorResponse.builder().message("List booking is empty").build();
                return ResponseEntity.badRequest().body(gson.toJson(errorResponse));
            }
            int slotId = listBooking.get(0).getSlotId();
            VoucherEntity voucherApply = voucherService.getValidVoucherByVoucherCodeAndSlotId(voucherCode, slotId);
            List<BookingApplyVoucherModel> bookingApplyVoucherList = voucherService.calculationPriceApplyVoucher(applyVoucherRequest.getBookingList(), voucherApply);
            ApplyVoucherResponse applyVoucherResponse = ApplyVoucherResponse.builder().voucherId(voucherApply.getId()).voucherCode(voucherApply.getVoucherCode()).bookingList(bookingApplyVoucherList).build();
            return ResponseEntity.ok(gson.toJson(applyVoucherResponse));
        } catch (ApplyVoucherException applyVoucherException) {
            ErrorResponse errorResponse = ErrorResponse.builder().message(applyVoucherException.getErrorMessage()).stack(applyVoucherException.getStack()).build();
            return ResponseEntity.badRequest().body(gson.toJson(errorResponse));
        }
    }
}
