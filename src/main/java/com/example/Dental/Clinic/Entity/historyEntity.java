package com.example.Dental.Clinic.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class historyEntity {
    @Id
    @GeneratedValue
    Long id;
    @NonNull
    String details;
    @NonNull
    Date date;
    @ManyToOne
    @JoinColumn(name ="pationt_id")
    patientEntity patient;

}
