package com.exe201.backend.api.vote;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VoteRequest {
    private String voteId;
    private String bookingId;
    private Integer score;
    private String comment;
}
