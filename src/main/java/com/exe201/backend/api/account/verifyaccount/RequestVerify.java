package com.exe201.backend.api.account.verifyaccount;

import com.exe201.backend.utils.RegexHelper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestVerify {
    private String otpCode;

    public boolean isValid() {
        return otpCode != null && otpCode.matches(RegexHelper.OTP_REGEX);
    }
}
