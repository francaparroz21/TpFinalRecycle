package com.project.recycle.model;
import  jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zoneId;

    private String longitude;

    private String latitude;

    private String classification;

    private int capacity;

    private String supervisors;

    @OneToMany(mappedBy = "zone")
    private List<Report> reports;

    public Zone(){}

    public Zone(String longitude, String latitude, String classification, Integer capacity, String supervisors){
        this.longitude = longitude;
        this.latitude = latitude;
        this.classification = classification;
        this.capacity = capacity;
        this.supervisors = supervisors;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setId(Long id) {
        this.zoneId = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public void addReports(Report report) {
        this.reports.add(report);
    }

    public String getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(String supervisors) {
        this.supervisors = supervisors;
    }
}
