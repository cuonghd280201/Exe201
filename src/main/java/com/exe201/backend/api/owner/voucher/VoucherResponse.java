package com.exe201.backend.api.owner.voucher;

import com.exe201.backend.model.VoucherModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoucherResponse {
    private int page;
    private int maxResult;
    private String message;
    private List<VoucherModel> vouchers;
}
