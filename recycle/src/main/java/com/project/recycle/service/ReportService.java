package com.project.recycle.service;

import com.project.recycle.model.Report;
import com.project.recycle.model.Supervisor;
import com.project.recycle.model.Zone;
import com.project.recycle.repository.ReportRepository;
import com.project.recycle.repository.SupervisorRepository;
import com.project.recycle.repository.ZoneRepository;
import jakarta.persistence.JoinColumn;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    private final Log LOG = LogFactory.getLog(ReportService.class);
    private ReportRepository reportRepository;
    @Autowired
    SupervisorRepository supervisorRepository;

    @Autowired
    ZoneRepository  zoneRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public List<Report> getReportsByPages(int page, int size) {
        return reportRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public Report saveReport(Report report) {
        Report new_report = report;
        new_report.setZone(zoneRepository.findById(report.getZone().getZoneID()).get());
        return reportRepository.save(new_report);
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }

}
