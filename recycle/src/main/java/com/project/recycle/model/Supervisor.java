package com.project.recycle.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "supervisor")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supervisorID;

    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 30, message = "The name cannot contain more than 30 letters.")
    @NotNull(message = "First name field cannot be null")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 30, message = "The last name cannot contain more than 30 letters.")
    @NotNull(message = "Last name field cannot be null")
    private String lastName;

    @Email(message = "Write a real email.")
    @Column(nullable = false)
    @NotNull(message = "Email field cannot be null")
    private String email;
    @ManyToOne
    @JoinColumn(name = "zoneID")
    private Zone zoneInSupervision;

    @ElementCollection(targetClass=String.class)
    private List<String> reports;

    public Supervisor(){};

    public Supervisor(String firstName, String lastName, String email, Zone zoneInSupervision, List<String> reports) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.zoneInSupervision = zoneInSupervision;
        this.reports = reports;
    }

    public Supervisor(Long supervisorID, String firstName, String lastName, String email, Zone zoneInSupervision, List<String> reports) {
        this.supervisorID = supervisorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.zoneInSupervision = zoneInSupervision;
        this.reports = reports;
    }

    public Long getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(Long supervisorID) {
        this.supervisorID = supervisorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Zone getZoneInSupervision() {
        return zoneInSupervision;
    }

    public void setZoneInSupervision(Zone zoneInSupervision) {
        this.zoneInSupervision = zoneInSupervision;
    }

    public List<String> getReports() {
        return reports;
    }

    public void setReports(List<String> reports) {
        this.reports = reports;
    }
}
