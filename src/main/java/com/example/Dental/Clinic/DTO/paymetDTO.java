package com.example.Dental.Clinic.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class paymetDTO {
    Long pationt_id;
    int value;
    String date;
}
