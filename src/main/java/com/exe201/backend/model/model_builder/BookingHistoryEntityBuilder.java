package com.exe201.backend.model.model_builder;

import com.exe201.backend.entity.BookingEntity;
import com.exe201.backend.entity.BookingHistoryEntity;
import com.exe201.backend.utils.DateHelper;

import java.util.UUID;

public class BookingHistoryEntityBuilder {
    public static BookingHistoryEntity buildFromBookingEntity(BookingEntity bookingEntity, String reason) {
        String id = UUID.randomUUID().toString();
        BookingHistoryEntity bookingHistoryEntity = BookingHistoryEntity.builder()
                .bookingId(bookingEntity.getId())
                .createdBy(bookingEntity.getAccountId())
                .createdAt(DateHelper.getTimestampAtZone(DateHelper.VIETNAM_ZONE))
                .bookingStatus(bookingEntity.getStatus())
                .id(id)
                .note(reason)
                .build();
        return bookingHistoryEntity;
    }
}
