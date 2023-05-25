package com.exe201.backend.api.yard_report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class YardReportOfUserRequest {
    private String reason;
}
