package com.exe201.backend.api.admin.accounts;

import com.exe201.backend.model.AccountModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAccountResponse {
    private int page;
    private int maxResult;
    private List<AccountModel> accounts;
}
