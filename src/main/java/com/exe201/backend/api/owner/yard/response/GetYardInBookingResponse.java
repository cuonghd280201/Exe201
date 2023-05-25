package com.exe201.backend.api.owner.yard.response;

import com.exe201.backend.model.SubYardSimpleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetYardInBookingResponse {
    private String yardId;
    private String yardName;
    private List<SubYardSimpleModel> subYards;
}
