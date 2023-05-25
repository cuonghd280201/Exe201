package com.exe201.backend.api.account.forgot;

import com.exe201.backend.utils.RegexHelper;
import lombok.Data;

@Data
public class VerifyOtpRequest {
    String email;
    String otpCode;

    public boolean isValid() {
        if (email == null || otpCode == null) {
            return false;
        }
        return email.matches(RegexHelper.EMAIL_REGEX) && otpCode.matches(RegexHelper.OTP_REGEX);
    }
}
