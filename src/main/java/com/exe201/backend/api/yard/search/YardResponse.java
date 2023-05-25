package com.exe201.backend.api.yard.search;

import com.exe201.backend.model.YardModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YardResponse {
    private List<YardModel> yards;
    private int page;
    private int maxResult;
}
