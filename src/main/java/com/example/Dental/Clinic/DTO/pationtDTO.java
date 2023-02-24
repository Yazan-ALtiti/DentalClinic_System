package com.example.Dental.Clinic.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class pationtDTO {
    Long doctor_id;
    String name;

    String location;

    String partner;

    String phone;
    int dayOfPay;
    String dateOfNextVisit;
}
