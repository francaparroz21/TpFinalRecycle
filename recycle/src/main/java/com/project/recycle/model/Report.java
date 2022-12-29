package com.project.recycle.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private LocalDate date;
    @Column(length = 300)
    private String reportMessage;

    private String zone;
    @Column(length = 50)
    private String complainant;

    public Report() {

    }

    public Report(LocalDate date, String reportMessage, String zone, String complainant) {
        this.date = date;
        this.reportMessage = reportMessage;
        this.zone = zone;
        this.complainant = complainant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
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
                "id=" + id +
                ", date=" + date +
                ", reportMessage='" + reportMessage + '\'' +
                ", zone=" + zone +
                ", complainant='" + complainant + '\'' +
                '}';
    }
}
