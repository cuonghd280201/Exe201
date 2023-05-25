package com.exe201.backend.api.slot;

import com.exe201.backend.utils.DateHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSlotRequest {
    private String date;

    public boolean isValid() {
        Timestamp dateParsed = DateHelper.parseFromStringToTimestamp(date);
        return dateParsed != null;
    }
}
