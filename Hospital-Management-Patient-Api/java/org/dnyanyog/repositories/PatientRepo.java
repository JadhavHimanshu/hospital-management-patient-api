package org.dnyanyog.repositories;

import java.util.List;

import org.dnyanyog.dto.PatientRequest;
import org.dnyanyog.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient ,Integer>  {

	  void save(PatientRequest user);


}
