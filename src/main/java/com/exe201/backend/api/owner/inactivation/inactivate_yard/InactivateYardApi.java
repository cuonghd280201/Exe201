package com.exe201.backend.api.owner.inactivation.inactivate_yard;

import com.google.gson.Gson;
import com.exe201.backend.exception.ErrorResponse;
import com.exe201.backend.exception.InactivateProcessException;
import com.exe201.backend.model.MessageResponse;
import com.exe201.backend.service.InactivationService;
import com.exe201.backend.service.ReactivationService;
import com.exe201.backend.service.SecurityContextService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/owners/me")
public class InactivateYardApi {
    private Gson gson;
    private InactivationService inactivationService;
    private ReactivationService reactivationService;
    private SecurityContextService securityContextService;

    @PutMapping(value = "yards/{yardId}/deactivate")
    public ResponseEntity<String> inactivateYard(@PathVariable String yardId) {
        try {
            SecurityContext context = SecurityContextHolder.getContext();
            String ownerId = securityContextService.extractUsernameFromContext(context);

            inactivationService.inactivateYard(ownerId, yardId);

            MessageResponse response = new MessageResponse("Deactivate successfully");
            return ResponseEntity.ok().body(gson.toJson(response));
        } catch (InactivateProcessException inactivateProcessException) {
            ErrorResponse response = ErrorResponse.builder().message(inactivateProcessException.getFilterMessage()).build();
            return ResponseEntity.badRequest().body(gson.toJson(response));
        }
    }

    @PutMapping(value = "yards/{yardId}/activate")
    public ResponseEntity<String> reactivateYard(@PathVariable String yardId) {
        try {
            SecurityContext context = SecurityContextHolder.getContext();
            String ownerId = securityContextService.extractUsernameFromContext(context);

            reactivationService.reactiveYard(ownerId, yardId);

            MessageResponse response = new MessageResponse("Activate successfully");
            return ResponseEntity.ok().body(gson.toJson(response));
        } catch (RuntimeException runtimeException) {
            ErrorResponse response = ErrorResponse.builder().message(runtimeException.getMessage()).build();
            return ResponseEntity.badRequest().body(gson.toJson(response));
        }
    }
}
