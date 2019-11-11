package com.killiann.appointment.ai.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Appointments")
public class Appointment {

    @Id
    private String id;
    private String name;
    private Integer datetime;
    private String username;
    private String email;
    private Boolean enabled;

    public Appointment() { }

    public Appointment(String id, String name, Integer datetime, String username, String email, Boolean enabled) {
        super();
        this.id = id;
        this.name = name;
        this.datetime = datetime;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDatetime() {
        return datetime;
    }

    public void setDatetime(Integer datetime) {
        this.datetime = datetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
