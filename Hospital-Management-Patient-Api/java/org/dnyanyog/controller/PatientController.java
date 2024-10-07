 package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.PatientRequest;
import org.dnyanyog.dto.PatientResponse;
import org.dnyanyog.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientservice;

	@PostMapping("/addpatient")
	public ResponseEntity<PatientResponse> addPatient(@RequestBody PatientRequest patientRequest) {
		this.patientservice.addPatient(patientRequest);
		return new ResponseEntity<>(new PatientResponse("Patient Added Successfully", "0000"), HttpStatus.CREATED);

	}

	@PostMapping("/addpatient/{patientId}")
	public ResponseEntity<PatientResponse> updatePatient(@RequestBody PatientRequest patientRequest,
			@PathVariable Integer patientId) {
		this.patientservice.updatePatient(patientRequest, patientId);
		return new ResponseEntity<>(new PatientResponse("Patient Uapdated SucessFully", "0000"), HttpStatus.OK);

	} 

	@DeleteMapping("/addpatient/{patientId}")
	public ResponseEntity<PatientResponse> deletePatient(@PathVariable Integer patientId) {
		this.patientservice.deletePatient(patientId);
		return new ResponseEntity<>(new PatientResponse("Patient Deleted sucessfully", "0000"), HttpStatus.OK);
	}

	@GetMapping("addpatient/getAll")
	public ResponseEntity<List<PatientRequest>> getAllPatient() {
		return ResponseEntity.ok(this.patientservice.getAllPatient());
	}

	@GetMapping("/addpatient/{patientId}")
	public ResponseEntity<PatientRequest> getPatientById(@PathVariable int patientId) {
		return ResponseEntity.ok(this.patientservice.getPatientById(patientId));
	}

}
