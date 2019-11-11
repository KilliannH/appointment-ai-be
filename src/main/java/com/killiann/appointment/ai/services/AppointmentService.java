package com.killiann.appointment.ai.services;

import com.killiann.appointment.ai.exception.ResourceNotFoundException;
import com.killiann.appointment.ai.models.Appointment;
import com.killiann.appointment.ai.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointment(String appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(String appointmentId, Appointment appointmentRequest) {
        return appointmentRepository.findById(appointmentId).map(appointment -> {
            appointment.setName(appointmentRequest.getName());
            appointment.setDatetime(appointmentRequest.getDatetime());
            appointment.setEnabled(appointmentRequest.getEnabled());
            appointment.setUsername(appointmentRequest.getUsername());
            appointment.setEmail(appointmentRequest.getEmail());
            return appointmentRepository.save(appointment);
        }).orElseThrow(() -> new ResourceNotFoundException("AppointmentId " + appointmentId + " not found"));
    }

    public void deleteAppointment(String appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
