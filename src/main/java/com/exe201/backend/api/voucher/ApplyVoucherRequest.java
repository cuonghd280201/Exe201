package com.exe201.backend.api.voucher;

import com.exe201.backend.model.BookingModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyVoucherRequest {
    private String voucherCode;
    private List<BookingModel> bookingList;
}
