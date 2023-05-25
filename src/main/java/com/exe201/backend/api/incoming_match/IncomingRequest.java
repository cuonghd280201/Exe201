package com.exe201.backend.api.incoming_match;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class IncomingRequest {
    private int itemsPerPage;
    private int page;
}
