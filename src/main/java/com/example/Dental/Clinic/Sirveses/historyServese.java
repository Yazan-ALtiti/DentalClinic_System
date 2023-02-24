package com.example.Dental.Clinic.Sirveses;

import com.example.Dental.Clinic.DTO.doctorDTO;
import com.example.Dental.Clinic.DTO.historyDTO;
import com.example.Dental.Clinic.Entity.doctorEntity;
import com.example.Dental.Clinic.Entity.historyEntity;
import com.example.Dental.Clinic.Entity.patientEntity;
import com.example.Dental.Clinic.Reposotory.reposotoryDoctor;
import com.example.Dental.Clinic.Reposotory.reposotoryHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class historyServese {
    @Autowired
    reposotoryHistory reposotoryHistory;

    @Autowired
    patintServese patintServese;

    public HttpStatus addhistory(historyDTO historyDTO,Long id) {
        patientEntity pationt= patintServese.findPationtById(id);
        DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.UK);
        LocalDate localDate=LocalDate.parse(historyDTO.getDate(),dateFormat);
        historyEntity history = new historyEntity(historyDTO.getDetails(),localDate,pationt);
        reposotoryHistory.save(history);
        return HttpStatus.OK;
    }

    public HttpStatus deleteHistory(Long id) {
        reposotoryHistory.deleteById(id);
        return HttpStatus.OK;
    }

    public HttpStatus updateHistory(Long id, historyDTO historyDTO) {
        historyEntity history = reposotoryHistory.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.UK);
        LocalDate localDate=LocalDate.parse(historyDTO.getDate(),dateFormat);
        history.setDate(localDate);
        history.setDetails(historyDTO.getDetails());
        reposotoryHistory.save(history);
        return HttpStatus.OK;
    }

    public historyEntity findHistoryById(Long id) {
        historyEntity history = reposotoryHistory.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        return history;
    }
}
