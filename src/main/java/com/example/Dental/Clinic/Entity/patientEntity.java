package com.example.Dental.Clinic.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class patientEntity {
    @Id
    @GeneratedValue
    Long id;
    @NonNull
    String name;
    @NonNull
    String location;
    @NonNull
    String partner;
    @NonNull
    String phone;
    @NonNull
    int dayOfPay;
    @NonNull
    LocalDate dateOfNextVisit;
    @NonNull
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="doctor_id")
    doctorEntity doctor;

    @OneToMany(mappedBy = "patient")
    List<historyEntity> histories;

    @OneToMany(mappedBy = "patient")
    List<paymentsEntity>payments;






}
