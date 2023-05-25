package com.exe201.backend.api.book.booking;

import com.exe201.backend.model.BookingModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private String voucherCode;
    private List<BookingModel> bookingList;

    public boolean isValid() {
        for (BookingModel bookingModel : bookingList) {
            if (!bookingModel.isValid()) {
                return false;
            }
        }
        return true;
    }
}
