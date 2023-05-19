package com.prasant.doctorApp.service;

import com.prasant.doctorApp.model.AuthenticationToken;
import com.prasant.doctorApp.model.Patient;

public interface IAuthService {

     void saveToken(AuthenticationToken token);
     AuthenticationToken getToken(Patient patient);
     boolean authenticate(String userEmail, String token);


}
