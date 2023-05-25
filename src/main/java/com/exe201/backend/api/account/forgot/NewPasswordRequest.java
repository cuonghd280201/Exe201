package com.exe201.backend.api.account.forgot;

import lombok.Data;

@Data
public class NewPasswordRequest {
    private String password;

    public boolean isValid() {
        return password != null && password.length() >= 8;
    }
}
