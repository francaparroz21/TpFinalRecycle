package com.project.recycle.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.util.List;

@Entity
@Table(name = "zone")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="id")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zoneID;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "classification")
    @Enumerated
    private Classification classification;

    @Column(name = "usedCapacityPercentage")
    @Min(value = 1, message = "Minium capacity is 1%")
    @Max(value = 100, message = "Maximum capacity is 100%")
    private int usedCapacityPercentage;

    @Column(name = "supervisors")
    @ElementCollection(targetClass= Long.class)
    private List<Long> supervisorsID;

    @OneToMany(mappedBy = "zone", orphanRemoval = true)
    private List<Report> reports;

    public Zone(String longitude, String latitude, Classification classification,
                int usedCapacityPercentage, List<Long> supervisorsID) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.classification = classification;
        this.usedCapacityPercentage = usedCapacityPercentage;
        this.supervisorsID = supervisorsID;
    }

    public Zone(Long zoneID, String longitude, String latitude, Classification classification, int usedCapacityPercentage, List<Long> supervisorsID) {
        this.zoneID = zoneID;
        this.longitude = longitude;
        this.latitude = latitude;
        this.classification = classification;
        this.usedCapacityPercentage = usedCapacityPercentage;
        this.supervisorsID = supervisorsID;
    }

    public Zone(){}
    
    public Long getZoneID() {
        return zoneID;
    }

    public void setZoneID(Long zoneID) {
        this.zoneID = zoneID;
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

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public int getUsedCapacityPercentage() {
        return usedCapacityPercentage;
    }

    public void setUsedCapacityPercentage(int usedCapacityPercentage) {
        this.usedCapacityPercentage = usedCapacityPercentage;
    }

    public List<Long> getSupervisorsID() {
        return supervisorsID;
    }

    public void setSupervisorsID(List<Long> supervisorsID) {
        this.supervisorsID = supervisorsID;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }


}
