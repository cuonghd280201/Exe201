package com.exe201.backend.api.slot;

import com.exe201.backend.model.Slot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SlotResponse {
    private String message;
    private List<Slot> data;
}
