package com.exe201.backend.entity;

import com.exe201.backend.utils.DateHelper;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "votes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class VoteEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "booking_id")
    private String bookingId;
    @Column(name = "score")
    private int score;
    @Column(name = "comment")
    private String comment;
    @Column(name = "date")
    @Builder.Default
    private Timestamp date = DateHelper.getTimestampAtZone(DateHelper.VIETNAM_ZONE);
    @Column(name = "is_deleted")
    @Builder.Default
    private boolean deleted = false;
}
