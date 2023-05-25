package com.exe201.backend.api.owner.yard;


import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.exe201.backend.api.owner.yard.request.YardRequest;
import com.exe201.backend.api.owner.yard.response.*;
import com.exe201.backend.api.owner.yard.updateYardRequest.UpdateYardRequest;
import com.exe201.backend.entity.YardEntity;
import com.exe201.backend.exception.ErrorResponse;
import com.exe201.backend.exception.InactivateProcessException;
import com.exe201.backend.model.MessageResponse;
import com.exe201.backend.model.SearchModel;
import com.exe201.backend.service.*;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/owners/me")
public class YardRestApi {
    private YardService yardService;
    private YardUpdateService yardUpdateService;
    private SecurityContextService securityContextService;
    private InactivationService inactivationService;
    private Gson gson;

    @PostMapping(value = "yards")
    public ResponseEntity<String> createYard(@RequestParam(name = "yard") String yard, @RequestParam(name = "images", required = false) MultipartFile[] images) {
        YardRequest yardRequest;
        try {
            yardRequest = gson.fromJson(yard, YardRequest.class);
        } catch (JsonParseException exception) {
            exception.printStackTrace();
            yardRequest = null;
        }

        if (yardRequest == null) {
            return ResponseEntity.badRequest().body("Missing body");
        }
        try {
            SecurityContext context = SecurityContextHolder.getContext();
            String userId = securityContextService.extractUsernameFromContext(context);
            yardService.createNewYard(userId, yardRequest, images);
            CreateYardSuccessResponse successResponse = CreateYardSuccessResponse.builder().message("Create yard success!").build();
            return ResponseEntity.ok(gson.toJson(successResponse));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping(value = "yards/search")
    public ResponseEntity<String> showAllYard(@RequestBody(required = false) SearchModel searchModel) {
        try {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            String ownerId = securityContextService.extractUsernameFromContext(securityContext);
            GetYardResponse response = yardService.findAllYardByOwnerId(ownerId, searchModel);
            return ResponseEntity.ok().body(gson.toJson(response));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(value = "yards/search/{yardId}")
    public ResponseEntity<String> showYardById(@PathVariable String yardId) {
        try {
            GetYardDetailResponse response;
            SecurityContext securityContext = SecurityContextHolder.getContext();
            String ownerId = securityContextService.extractUsernameFromContext(securityContext);

            YardEntity yardEntity = yardService.getYardByIdAndNotDeleted(yardId);

            if (yardEntity == null) {
                ErrorResponse error = ErrorResponse.builder().message("The yard is deleted or not existed.").build();
                return ResponseEntity.badRequest().body(gson.toJson(error));
            }

            if (!yardEntity.getOwnerId().equals(ownerId)) {
                ErrorResponse error = ErrorResponse.builder().message("The owner is not author of this yard.").build();
                return ResponseEntity.badRequest().body(gson.toJson(error));
            }

            response = yardService.getYardDetailResponseFromYardId(yardId);

            return ResponseEntity.ok().body(gson.toJson(response));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "yards/{yardId}")
    public ResponseEntity<String> deleteYardById(@PathVariable String yardId) {
        try {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            String ownerId = securityContextService.extractUsernameFromContext(securityContext);

            inactivationService.deleteYard(ownerId, yardId);
            MessageResponse response = new MessageResponse("Delete yard successfully");
            return ResponseEntity.ok().body(gson.toJson(response));
        } catch (InactivateProcessException inactivateProcessException) {
            ErrorResponse response = ErrorResponse.builder().message(inactivateProcessException.getFilterMessage()).build();
            return ResponseEntity.badRequest().body(gson.toJson(response));
        }
    }

    @PutMapping(value = "yards/{yardId}")
    public ResponseEntity<String> updateYardById(@RequestParam(name = "yard") String yard,
                                                 @RequestParam(name = "newImages", required = false) MultipartFile[] newImages,
                                                 @RequestParam(name = "images") String images,
                                                 @PathVariable String yardId) {
        UpdateYardRequest request;
        List<String> imagesConverted;
        try {
            request = gson.fromJson(yard, UpdateYardRequest.class);
            imagesConverted = gson.fromJson(images, List.class);
        } catch (JsonParseException exception) {
            return ResponseEntity.badRequest().body("Cannot parse the request.");
        }

        try {
            SecurityContext context = SecurityContextHolder.getContext();
            String userId = securityContextService.extractUsernameFromContext(context);

            yardUpdateService.updateYard(userId, request, imagesConverted, newImages, yardId);
            MessageResponse response = new MessageResponse("Update successfully");
            return ResponseEntity.ok(gson.toJson(response));
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @GetMapping(value = "all-yards")
    public ResponseEntity<String> getAllYardInBookingManagement() {
        List<GetYardInBookingResponse> response;
        try {
            String ownerId = securityContextService.extractUsernameFromContext(SecurityContextHolder.getContext());
            response = yardService.getSimpleYardDetailsFromOwner(ownerId);
            return ResponseEntity.ok(gson.toJson(response));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body("Server error " + ex.getMessage());
        }
    }
}
