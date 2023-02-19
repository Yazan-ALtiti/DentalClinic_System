package com.example.Dental.Clinic.Entity;

import lombok.*;

import javax.persistence.*;
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
    @ManyToOne
    @JoinColumn(name ="doctor_id")
    doctorEntity doctor;

    @OneToMany(mappedBy = "patient")
    List<historyEntity> histories;

    @OneToMany(mappedBy = "payment_id")
    List<paymentsEntity>payments;






}
