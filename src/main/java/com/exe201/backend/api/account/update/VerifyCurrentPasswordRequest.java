package com.exe201.backend.api.account.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerifyCurrentPasswordRequest {
    private String password;
}
