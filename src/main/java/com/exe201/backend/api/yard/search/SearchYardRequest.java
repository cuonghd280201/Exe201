package com.exe201.backend.api.yard.search;

import lombok.Data;

@Data
public class SearchYardRequest {
    private Integer provinceId;
    private Integer districtId;
    private Integer itemsPerPage;
    private Integer page;
}
