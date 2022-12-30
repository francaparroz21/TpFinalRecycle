package com.project.recycle.model;

import jakarta.annotation.Nonnull;
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
    private Long id;

    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 30, message = "The name cannot contain more than 30 letters.")
    @NotNull(message = "First name field cannot be null")
    private String first_name;

    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 30, message = "The last name cannot contain more than 30 letters.")
    @NotNull(message = "Last name field cannot be null")
    private String last_name;

    @Email(message = "Write a real email.")
    @Column(name = "email", nullable = false)
    @NotNull(message = "Email field cannot be null")
    private String email;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull(message = "Zone in supervision field cannot be null")
    @Nonnull
    private Zone zone_in_supervision;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Nullable
    private List<Report> reports;

    public Supervisor(){};

    public Supervisor(String first_name, String last_name, String email, Zone zone_in_supervision, List<Report> reports) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.zone_in_supervision = zone_in_supervision;
        this.reports = reports;
    }

    public Supervisor(Long id, String first_name, String last_name, String email, Zone zone_in_supervision, List<Report> reports) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.zone_in_supervision = zone_in_supervision;
        this.reports = reports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Zone getZone_in_supervision() {
        return zone_in_supervision;
    }

    public void setZone_in_supervision(Zone zone_in_supervision) {
        this.zone_in_supervision = zone_in_supervision;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
