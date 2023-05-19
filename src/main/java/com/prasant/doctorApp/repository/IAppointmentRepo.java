package com.prasant.doctorApp.repository;

import com.prasant.doctorApp.model.Appointment;
import com.prasant.doctorApp.model.AppointmentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepo extends JpaRepository<Appointment, AppointmentKey> {

    public String findByIdAppId(Long id);
}
