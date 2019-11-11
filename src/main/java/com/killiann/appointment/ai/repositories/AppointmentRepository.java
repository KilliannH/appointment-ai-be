package com.killiann.appointment.ai.repositories;

import com.killiann.appointment.ai.models.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> { // second param is the type of the id
    List<Appointment> findByName(String name);
}
