package com.project.recycle.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;
    @Column(nullable = false)
    private LocalDate date;
    @Column(length = 300, nullable = false)
    private String reportMessage;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "zoneId", insertable = false, updatable = false)
    private Zone zone;
    @Column(length = 50, nullable = false)
    private String complainant;

    public Report() {

    }

    public Report(LocalDate date, String reportMessage, Zone zone, String complainant) {
        this.date = date;
        this.reportMessage = reportMessage;
        this.zone = zone;
        this.complainant = complainant;
    }

    public Report(Long id, LocalDate date, String reportMessage, Zone zone, String complainant) {
        this.reportId = id;
        this.date = date;
        this.reportMessage = reportMessage;
        this.zone = zone;
        this.complainant = complainant;
    }

    public Long getId() {
        return reportId;
    }

    public void setId(Long id) {
        this.reportId = id;
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
                "id=" + reportId +
                ", date=" + date +
                ", reportMessage='" + reportMessage + '\'' +
                ", zone=" + zone +
                ", complainant='" + complainant + '\'' +
                '}';
    }
}
