package com.example.Dental.Clinic.Entity;

import lombok.*;

import javax.persistence.*;
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
    String name;
    @NonNull
    String phone;
    @NonNull
    Date date;

    @ManyToOne
    @JoinColumn(name ="patient_id")
    doctorEntity patient;


}
