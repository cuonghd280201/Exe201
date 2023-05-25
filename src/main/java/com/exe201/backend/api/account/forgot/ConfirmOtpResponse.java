package com.exe201.backend.api.account.forgot;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ConfirmOtpResponse {
    private String token;
}
