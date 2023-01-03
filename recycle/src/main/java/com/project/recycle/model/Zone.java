package com.project.recycle.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zoneID;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "classification")
    private Classification classification;

    @Column(name = "usedCapacityPercentage")
    private int usedCapacityPercentage;

    @Column(name = "supervisorsID")
    private List<Long> supervisorsID;

    public Zone(){}

    public Zone(String longitude, String latitude, Classification classification, Integer usedCapacityPercentage, List<Long> supervisorsID){
        this.longitude = longitude;
        this.latitude = latitude;
        this.classification = classification;
        this.usedCapacityPercentage = usedCapacityPercentage;
        this.supervisorsID = supervisorsID;
    }

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
}