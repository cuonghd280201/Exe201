package com.exe201.backend.api.account.update;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyCurrentPasswordResponse {
    private String token;
    private String message;
}
