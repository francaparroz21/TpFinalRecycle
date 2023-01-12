package com.project.recycle.service;

import com.project.recycle.model.Report;
import com.project.recycle.model.Status;
import com.project.recycle.model.Zone;
import com.project.recycle.repository.ReportRepository;
import com.project.recycle.repository.ZoneRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Report> getReportsByStatus(Status status) {
        return reportRepository.findByStatus(status).get();
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
