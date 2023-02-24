package com.example.Dental.Clinic;

import com.example.Dental.Clinic.DTO.doctorDTO;
import com.example.Dental.Clinic.Sirveses.doctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class DentalClinicApplicationTests {
@Autowired
doctorService doctorService;
	@Test
	void contextLoads() {
		doctorDTO doctor=new doctorDTO("wael","0455",522);

		assertEquals(doctorService.addDoctor(doctor), HttpStatus.OK);

	}

}
