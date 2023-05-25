package com.exe201.backend.api.account.forgot;

import com.exe201.backend.utils.RegexHelper;
import lombok.Data;

@Data
public class SendMailRequest {
    private String email;

    public boolean isValid() {
        return email != null && email.matches(RegexHelper.EMAIL_REGEX);
    }
}
