package org.dnyanyog.service;

import java.util.List;

import org.dnyanyog.dto.PatientRequest;

public interface PatientService {

	PatientRequest addPatient(PatientRequest patientRequest);

	PatientRequest updatePatient(PatientRequest patientRequest, Integer patientId);

	void deletePatient(Integer patientId);

	List<PatientRequest> getAllPatient();

	PatientRequest getPatientById(Integer patientId);

}
