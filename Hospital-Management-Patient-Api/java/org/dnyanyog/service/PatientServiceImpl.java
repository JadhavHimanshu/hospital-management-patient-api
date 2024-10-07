package org.dnyanyog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.dnyanyog.dto.PatientRequest;
import org.dnyanyog.entity.Patient;
import org.dnyanyog.exception.ResourceNotFoundException;
import org.dnyanyog.repositories.PatientRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepo patientRepo;

	@Autowired
	private ModelMapper modelMapper;
   
	@Override
	public PatientRequest addPatient(PatientRequest patientRequest) {
		Patient patient = this.requestToPatient(patientRequest);
		Patient savePatient = this.patientRepo.save(patient);
		return this.patientToRequest(savePatient);
	}

	@Override    
	public PatientRequest getPatientById(Integer patientId) {
		Patient patient = this.patientRepo.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));

		return this.patientToRequest(patient);
	}

	@Override 
	public PatientRequest updatePatient(PatientRequest patientRequest, Integer patientId) {
		Patient patient = patientRepo.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "id", patientId));
		patient.setName(patientRequest.getName());
		patient.setMobile(patientRequest.getMobile());
		patient.setGender(patientRequest.getGender());
		patient.setBirthDate(patientRequest.getBirthDate());
		patient.setExaminationDate(patientRequest.getExaminationDate());
		patient.setAddress(patientRequest.getAddress());

		Patient updatePatient = this.patientRepo.save(patient);
		PatientRequest patientrequest = this.patientToRequest(updatePatient);
		return patientrequest;
	}

	@Override
	public void deletePatient(Integer patientId) {
		Patient patient = this.patientRepo.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));
		this.patientRepo.delete(patient);

	}

	@Override
	public List<PatientRequest> getAllPatient() {
		List<Patient> patients = this.patientRepo.findAll();
		List<PatientRequest> patientRequest = patients.stream().map(patient -> this.patientToRequest(patient))
				.collect(Collectors.toList());

		return patientRequest;
	}


	public Patient requestToPatient(PatientRequest Request) {

		Patient patient = this.modelMapper.map(Request, Patient.class);
		return patient;
	}

	public PatientRequest patientToRequest(Patient patient) {
		PatientRequest request = this.modelMapper.map(patient, PatientRequest.class);
		return request;
	}




}
