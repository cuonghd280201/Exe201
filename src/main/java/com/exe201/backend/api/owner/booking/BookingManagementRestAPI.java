package com.exe201.backend.api.owner.booking;


import com.google.gson.Gson;
import com.exe201.backend.entity.BookingEntity;
import com.exe201.backend.service.BookingService;
import com.exe201.backend.service.SecurityContextService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/owner")
@AllArgsConstructor
public class BookingManagementRestAPI {
    private Gson gson;
    private BookingService bookingService;
    private SecurityContextService securityContextService;

    @GetMapping(value = "booking")
    public ResponseEntity<String> showAllBooking() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String ownerId = securityContextService.extractUsernameFromContext(securityContext);
        List<BookingEntity> booking = bookingService.getAllIncomeSlotByOwnerId(ownerId);
        return ResponseEntity.ok().body(gson.toJson(booking));
    }
}