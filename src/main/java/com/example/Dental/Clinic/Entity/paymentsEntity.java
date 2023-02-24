package com.example.Dental.Clinic.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class paymentsEntity {
    @Id
    @GeneratedValue
    Long id;
    @NonNull
    int value;
    @NonNull
    LocalDate date;
    @NonNull
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="patient_id")
    patientEntity patient;


}
