package com.example.Dental.Clinic.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class historyDTO {
    Long pationt_id;
    String details;
    String date;

}
