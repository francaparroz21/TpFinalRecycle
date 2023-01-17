package com.project.recycle.service;

import com.project.recycle.model.Report;
import com.project.recycle.model.ReportStatus;
import com.project.recycle.repository.ReportRepository;
import com.project.recycle.repository.ZoneRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Ref;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ReportService {
    private final Log LOG = LogFactory.getLog(ReportService.class);
    private ReportRepository reportRepository;
    private ZoneRepository zoneRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository, ZoneRepository zoneRepository) {
        this.reportRepository = reportRepository;
        this.zoneRepository = zoneRepository;
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public List<Report> getReportsByPages(int page, int size) {
        return reportRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public List<Report> getReportsByStatus(ReportStatus status) {
        return reportRepository.findByStatus(status).get();
    }

    public Report updateReportStatus(Long id, Report report1) {
        Report report = reportRepository.findById(id).get();
        report.setStatus(report1.getStatus());

        return reportRepository.save(report);
    }

    public Report saveReport(Report report) {

        return reportRepository.save(report);
    }

    public boolean deleteReport(Long id) {
        try {
            reportRepository.deleteById(id);
            return true;
        } catch(Exception ex) {
            return false;
        }
    }

}
