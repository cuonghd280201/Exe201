package com.exe201.backend.api.incoming_match;

import com.exe201.backend.model.MatchModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IncomingResponse {
    private String message;
    private int page;
    private int maxResult;
    private List<MatchModel> data;
}
