package com.exe201.backend.api.account.register;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {
    private String userId;
    private String fullName;
    private String email;
    private String role;
    private boolean isConfirmed;
    private String token;
}
