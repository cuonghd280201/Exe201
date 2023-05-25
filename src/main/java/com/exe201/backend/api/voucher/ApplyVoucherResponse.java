package com.exe201.backend.api.voucher;

import com.exe201.backend.model.BookingApplyVoucherModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ApplyVoucherResponse {
    private String voucherId;
    private String voucherCode;
    private List<BookingApplyVoucherModel> bookingList;
}
