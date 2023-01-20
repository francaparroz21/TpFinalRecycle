package com.project.recycle.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "zone")
//@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="id")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zoneID;

    @Column(name = "longitude")
    @NotNull(message = "The longitude attribute cannot be null")
    private String longitude;


    @Column(name = "latitude")
    @NotNull(message = "The latitude attribute cannot be null")
    private String latitude;

    @Column(name = "classification")
    @NotNull(message = "The classification attribute cannot be null")
    @Enumerated
    private Classification classification;

    @Column (name = "status")
    @Enumerated(EnumType.STRING)
    private ZoneStatus zoneStatus = ZoneStatus.OK;

    @Column
    private boolean reclassification = false;

    @Column
    private Date startDate = new Date();

    @Column
    private Date fullFillDate = null;

    @Column
    private int usedCapacityPercentage = 0;

    @Column(name = "supervisors")
    @ElementCollection(targetClass= Long.class)
    private List<Long> supervisorsID;

    @OneToMany(mappedBy = "zone", orphanRemoval = true)
    private List<Report> reports;

    public Zone(String longitude, String latitude, Classification classification
                , List<Long> supervisorsID) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.classification = classification;
        this.supervisorsID = supervisorsID;
    }

    public Zone(Long zoneID, String longitude, String latitude, Classification classification, List<Long> supervisorsID) {
        this.zoneID = zoneID;
        this.longitude = longitude;
        this.latitude = latitude;
        this.classification = classification;
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

    public ZoneStatus getZoneStatus() {
        return zoneStatus;
    }

    public void setZoneStatus(ZoneStatus zoneStatus) {
        this.zoneStatus = zoneStatus;
    }

    public boolean isReclassification() {
        return reclassification;
    }

    public void setReclassification(boolean reclassification) {
        this.reclassification = reclassification;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFullFillDate() {
        return fullFillDate;
    }

    public void setFullFillDate(Date fullFillDate) {
        this.fullFillDate = fullFillDate;
    }

    public int getUsedCapacityPercentage() {
        if(usedCapacityPercentage == 100){

        }
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
