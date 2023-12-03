package com.patient.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.project.model.Patients;
import com.patient.project.service.PatientService;

@RestController
@RequestMapping("/patients")
public class patientController {
	@Autowired
	PatientService patientService;

	@GetMapping("/")
	
	public ResponseEntity<List<Patients>> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Patients>> getPatientById(@PathVariable Long id) {
		return patientService.getPatientsById(id);
	}
	
   @PostMapping("/")
    public ResponseEntity<Patients> createPatient(@RequestBody Patients patient) {
	  // ResponseEntity<Patients> res=  new ResponseEntity<Patients>(HttpStatus.CREATED);
	   //patientService.getPatientsById(id);
	   System.out.println("Controller");
	   Patients p=patientService.addPatient(patient);
	   System.out.println("P="+p);

	   return  ResponseEntity.ok(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patients> updatePatient(@PathVariable Long id, @RequestBody Patients updatedPatient) {
        return patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") Long id) {
        return patientService.deletePatient(id);
    }

}
