package com.exe201.backend.api.account.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountRequest {
    private String fullName;
    private String phone;
}
