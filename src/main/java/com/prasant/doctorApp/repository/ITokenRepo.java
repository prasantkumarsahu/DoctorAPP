package com.prasant.doctorApp.repository;

import com.prasant.doctorApp.model.AuthenticationToken;
import com.prasant.doctorApp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthenticationToken, Long> {


    AuthenticationToken findByPatient(Patient patient);

    AuthenticationToken findFirstByToken(String token);
}
