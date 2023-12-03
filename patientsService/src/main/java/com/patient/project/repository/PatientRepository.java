package com.patient.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.project.model.Patients;

@Repository 
public interface PatientRepository extends JpaRepository<Patients, Long> {
	

}
