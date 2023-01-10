package com.project.recycle.controller;

import com.project.recycle.model.Report;
import com.project.recycle.model.ReportStatus;
import com.project.recycle.repository.ReportRepository;
import com.project.recycle.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private ReportService reportService;
    private final ReportRepository reportRepository;

    @Autowired
    public ReportController(ReportService reportService,
                            ReportRepository reportRepository) {
        this.reportService = reportService;
        this.reportRepository = reportRepository;
    }

    @GetMapping
    ResponseEntity<List<Report>> getAllReports() {
        try {
            return new ResponseEntity<>(reportService.getAllReports(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{status}")
    ResponseEntity<List<Report>> getByStatus(@PathVariable ReportStatus status) {
        try {
            return new ResponseEntity<>(reportRepository.findByStatus(status).get(), HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pages")
    ResponseEntity<List<Report>> getByPages(@RequestParam int page, @RequestParam int size) {
        try {
            return new ResponseEntity<>(reportService.getReportsByPages(page, size), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    ResponseEntity<Report> newReport(@RequestBody Report newReport) {
        try {
            return new ResponseEntity<>(reportService.saveReport(newReport), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteReport(@PathVariable Long id){
        reportService.deleteReport(id);
        return new ResponseEntity(this.reportService.deleteReport(id) ?
                HttpStatus.OK: HttpStatus.NOT_FOUND);
    }
}
