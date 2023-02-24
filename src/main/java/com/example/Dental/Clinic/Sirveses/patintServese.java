package com.example.Dental.Clinic.Sirveses;

import com.example.Dental.Clinic.DTO.pationtDTO;
import com.example.Dental.Clinic.Entity.doctorEntity;
import com.example.Dental.Clinic.Entity.patientEntity;
import com.example.Dental.Clinic.Reposotory.reposotoryPationt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
public class patintServese {
    @Autowired
    reposotoryPationt reposotoryPationt;
    @Autowired
    doctorService doctorService;

    public HttpStatus addPationt(pationtDTO pationtDTo) {
        doctorEntity doctorEntity = doctorService.findDoctorById(pationtDTo.getDoctor_id());
        DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.UK);
        LocalDate localDate=LocalDate.parse(pationtDTo.getDateOfNextVisit(),dateFormat);

        patientEntity patient = new patientEntity(pationtDTo.getName(), pationtDTo.getLocation(), pationtDTo.getPartner(), pationtDTo.getPhone(),pationtDTo.getDayOfPay(),localDate, doctorEntity);
        reposotoryPationt.save(patient);

        return HttpStatus.OK;
    }

    public HttpStatus deletePationt(Long id) {
        reposotoryPationt.deleteById(id);
        return HttpStatus.OK;
    }

    public HttpStatus updatePationt(Long id, pationtDTO pationtDTO) {
        patientEntity patient = reposotoryPationt.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        patient.setName(pationtDTO.getName());
        patient.setPhone(pationtDTO.getPhone());
        patient.setPartner(pationtDTO.getPartner());
        patient.setLocation(pationtDTO.getLocation());
        reposotoryPationt.save(patient);
        return HttpStatus.OK;
    }

    public patientEntity findPationtById(Long id) {
        patientEntity patient = reposotoryPationt.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        return patient;
    }
    public List<patientEntity>notificationsOfPayment(int day){
         return reposotoryPationt.findBydayOfPay(day);

    }
    public List<patientEntity>notificationsOfPointent(String date){
        DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.UK);
        LocalDate localDate=LocalDate.parse(date,dateFormat);
        return reposotoryPationt.findBydateOfNextVisit(localDate);

    }

}

