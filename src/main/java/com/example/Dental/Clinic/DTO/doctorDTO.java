package com.example.Dental.Clinic.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor

public class doctorDTO {
    String name;
    String phone;
    int salary;

}
