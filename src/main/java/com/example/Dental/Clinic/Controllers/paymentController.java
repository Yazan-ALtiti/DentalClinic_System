package com.example.Dental.Clinic.Controllers;

import com.example.Dental.Clinic.DTO.doctorDTO;
import com.example.Dental.Clinic.DTO.pationtDTO;
import com.example.Dental.Clinic.DTO.paymetDTO;
import com.example.Dental.Clinic.Sirveses.PaymentServese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class paymentController {
    @Autowired
    PaymentServese PaymentServese;

    @PostMapping("/payment/add")
    public HttpStatus addPayment(@RequestBody paymetDTO paymetDTO) {
        return PaymentServese.addPayment(paymetDTO);
    }

    @DeleteMapping("/payment/delete/{id}")
    public HttpStatus deletePayment(@PathVariable("id") Long id) {
        return PaymentServese.deletePayment(id);
    }

    @PutMapping("/payment/update/{id}")
    public HttpStatus updatePayment(@RequestBody paymetDTO paymetDTO, @PathVariable("id") Long id) {
        return PaymentServese.updatePaymet(id, paymetDTO);
    }
}
