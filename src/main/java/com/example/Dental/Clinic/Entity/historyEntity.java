package com.example.Dental.Clinic.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
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
    LocalDate date;
    @NonNull
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="pationt_id")
    patientEntity patient;

}
