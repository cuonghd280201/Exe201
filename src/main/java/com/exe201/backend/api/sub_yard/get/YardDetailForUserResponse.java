package com.exe201.backend.api.sub_yard.get;

import com.exe201.backend.model.YardData;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class YardDetailForUserResponse {
    private String message;
    private YardData data;
}
