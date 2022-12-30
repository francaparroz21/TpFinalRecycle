package com.project.recycle.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
    @Column(name = "email", nullable = false)
    @NotNull(message = "Email field cannot be null")
    private String email;

    @Column(name = "zoneInSupervisionID", nullable = false)
    @NotNull(message = "Zone in supervision field cannot be null")
    private Long zoneInSupervisionID;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Nullable
    private List<Report> reports;

    public Supervisor(){};

    public Supervisor(String firstName, String lastName, String email, Long zoneInSupervisionID, List<Report> reports) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.zoneInSupervisionID = zoneInSupervisionID;
        this.reports = reports;
    }

    public Supervisor(Long supervisorID, String firstName, String lastName, String email, Long zoneInSupervisionID, List<Report> reports) {
        this.supervisorID = supervisorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.zoneInSupervisionID = zoneInSupervisionID;
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

    public Long getZoneInSupervisionID() {
        return zoneInSupervisionID;
    }

    public void setZoneInSupervisionID(Long zoneInSupervisionID) {
        this.zoneInSupervisionID = zoneInSupervisionID;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
