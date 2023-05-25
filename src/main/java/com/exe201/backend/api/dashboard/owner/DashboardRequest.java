package com.exe201.backend.api.dashboard.owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DashboardRequest {
    private String startTime;
    private String endTime;
}
