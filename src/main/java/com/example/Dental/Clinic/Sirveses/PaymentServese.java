package com.example.Dental.Clinic.Sirveses;

import com.example.Dental.Clinic.DTO.pationtDTO;
import com.example.Dental.Clinic.DTO.paymetDTO;
import com.example.Dental.Clinic.Entity.doctorEntity;
import com.example.Dental.Clinic.Entity.patientEntity;
import com.example.Dental.Clinic.Entity.paymentsEntity;
import com.example.Dental.Clinic.Reposotory.reposotoryPayments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class PaymentServese {
    @Autowired
    reposotoryPayments reposotoryPayments;
    @Autowired
    patintServese patintServese;

    public HttpStatus addPayment(paymetDTO paymetDTO) {
        DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.UK);
        LocalDate localDate=LocalDate.parse(paymetDTO.getDate(),dateFormat);
        patientEntity patient = patintServese.findPationtById(paymetDTO.getPationt_id());
        paymentsEntity payments = new paymentsEntity(paymetDTO.getValue(), localDate, patient);
        reposotoryPayments.save(payments);
        return HttpStatus.OK;
    }

    public HttpStatus deletePayment(Long id) {
        reposotoryPayments.deleteById(id);
        return HttpStatus.OK;
    }

    public HttpStatus updatePaymet(Long id, paymetDTO paymetDTO) {
        paymentsEntity payments = reposotoryPayments.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.UK);
        LocalDate localDate=LocalDate.parse(paymetDTO.getDate(),dateFormat);
        payments.setValue(paymetDTO.getValue());

        payments.setDate(localDate);
        reposotoryPayments.save(payments);
        return HttpStatus.OK;
    }
    public paymentsEntity findPaymentById(Long id) {
        paymentsEntity payments = reposotoryPayments.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid user id" + id));
        return payments;
    }


}
