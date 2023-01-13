package com.project.recycle.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "report")
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="id")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;
    @Column
    @NotNull(message = "The date attribute cannot be null")
    private LocalDate date;
    @Column(length = 300)
    @NotNull(message = "The reportMessage attribute cannot be null")
    private String reportMessage;

    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "The status attribute cannot be null")
    private ReportStatus status;

    @ManyToOne
    @JoinColumn(name = "zoneId")
    @NotNull(message = "The zone attribute cannot be null")
    private Zone zone;

    @Column(length = 50)
    @NotNull(message = "The complainant attribute cannot be null")
    private String complainant;

    public Report() {

    }

    public Report(LocalDate date, String reportMessage, ReportStatus status, Zone zone, String complainant) {
        this.date = date;
        this.reportMessage = reportMessage;
        this.status = status;
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

    public String getComplainant() {
        return complainant;
    }

    public void setComplainant(String complainant) {
        this.complainant = complainant;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", date=" + date +
                ", reportMessage='" + reportMessage + '\'' +
                ", status=" + status +
                ", zone=" + zone +
                ", complainant='" + complainant + '\'' +
                '}';
    }
}
