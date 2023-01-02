package com.project.recycle.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportID;
    @Column()
    private LocalDate date;
    @Column(length = 300)
    private String reportMessage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zoneID")
    private Zone zone;

    @Column(name = "complainant")
    private String complainant;

    public Report() {

    }

    public Report(String reportMessage, Zone zone, String complainant) {
        this.date = LocalDate.now();
        this.reportMessage = reportMessage;
        this.zone = zone;
        this.complainant = complainant;
    }

    public Long getReportID() {
        return reportID;
    }

    public void setReportID(Long reportID) {
        this.reportID = reportID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReportMessage() {
        return reportMessage;
    }

    public void setReportMessage(String reportMessage) {
        this.reportMessage = reportMessage;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public String getComplainant() {
        return complainant;
    }

    public void setComplainant(String complainant) {
        this.complainant = complainant;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + reportID +
                ", date=" + date +
                ", reportMessage='" + reportMessage + '\'' +
                ", zone=" + zone +
                ", complainant='" + complainant + '\'' +
                '}';
    }
}
