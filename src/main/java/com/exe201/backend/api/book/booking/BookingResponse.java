package com.exe201.backend.api.book.booking;

import com.exe201.backend.entity.BookingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class BookingResponse {
    private String message;
    private boolean isError;
    private List<BookingEntity> bookings;
}
