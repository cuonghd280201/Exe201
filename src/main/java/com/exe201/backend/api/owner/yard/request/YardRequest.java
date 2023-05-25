package com.exe201.backend.api.owner.yard.request;

import lombok.Data;

import java.util.List;

@Data
public class YardRequest {
    private String name;
    private String address;
    private Integer districtId;
    private String openAt;
    private String closeAt;
    private String slotDuration;
    private List<SubYardRequest> subYards;
}
