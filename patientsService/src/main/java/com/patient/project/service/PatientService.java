package com.patient.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.patient.project.model.Patients;
import com.patient.project.repository.PatientRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.CacheManager;

@Service
public class PatientService {
	@Autowired
	PatientRepository patientRepository;

	public ResponseEntity<List<Patients>> getAllPatients() {
//		return patientRepository.findAll();
		try {
			return new ResponseEntity<>(patientRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Cacheable(value = "pCache", key = "#id")
	public ResponseEntity<Optional<Patients>> getPatientsById(Long id) {
		System.out.println("Fetching data from db");
		try {
			System.out.println("Fetching data from cache");
			return new ResponseEntity<>(patientRepository.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	
	public Patients addPatient(Patients patient) {
		try {
			System.out.println("Serivce");
			patientRepository.save(patient);
			return patient;
		} catch (Exception e) {
			return patient;
		}

	}

	@CachePut(value = "pCache", key = "#id")
	public ResponseEntity<Patients> updatePatient(Long id, Patients patient) {
		System.out.println("Interacting with db");

		Optional<Patients> patientData = patientRepository.findById(id);

		if (patientData.isPresent()) {
			Patients _patient = patientData.get();
			_patient.setName(patient.getName());
			_patient.setAge(patient.getAge());
			_patient.setGender(patient.getGender());

			return new ResponseEntity<>(patientRepository.save(_patient), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			throw new ResourceNotFoundException("Patient not found with id: " + id);
		}
	}

	@CacheEvict(value = "pCache", key = "#id")
	public ResponseEntity<HttpStatus> deletePatient(long id) {
		try {
			patientRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
