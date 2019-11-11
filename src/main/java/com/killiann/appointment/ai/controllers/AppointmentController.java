package com.killiann.appointment.ai.controllers;

import com.killiann.appointment.ai.models.Appointment;
import com.killiann.appointment.ai.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<Appointment> getAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/appointments/{id}")
    public Optional<Appointment> getAppointment(@PathVariable (value = "id") String appointmentId) {
        return appointmentService.getAppointment(appointmentId);
    }

    @PostMapping("/appointments/")
    public Appointment createAppointment(@Valid @RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }
}
