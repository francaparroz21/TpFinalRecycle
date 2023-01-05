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

    private Classification classification;

    private int usedCapacityPercentage;

    private List<Long> supervisorsID;
    
    public Zone(){}

    public Zone(String longitude, String latitude, Classification classification, Integer capacity, List<Long> supervisors){
        this.longitude = longitude;
        this.latitude = latitude;
        this.classification = classification;
        this.capacity = capacity;
        this.supervisors = supervisors;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setId(Long zoneId) {
        this.zoneId = zoneId;
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
        this.v = usedCapacityPercentage;
    }

    public List<Long> getSupervisorsID() {
        return supervisorsID;
    }

    public void setSupervisorsID(String supervisorsID) {
        this.supervisorsID = supervisorsID;
    }
}
