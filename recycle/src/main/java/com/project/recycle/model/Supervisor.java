package com.project.recycle.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "supervisor")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "zoneInSupervision")
    private String zone_in_supervision;

    @Column(name = "reports")
    private List<String> reports;

    public Supervisor(){};

    public Supervisor(String first_name, String last_name, String email, String zone_in_supervision, List<String> reports) {
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

    public String getZone_in_supervision() {
        return zone_in_supervision;
    }

    public void setZone_in_supervision(String zone_in_supervision) {
        this.zone_in_supervision = zone_in_supervision;
    }

    public List<String> getReports() {
        return reports;
    }

    public void setReports(List<String> reports) {
        this.reports = reports;
    }
}
