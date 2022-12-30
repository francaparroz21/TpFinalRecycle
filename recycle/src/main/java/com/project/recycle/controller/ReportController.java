package com.project.recycle.controller;

import com.project.recycle.model.Report;
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

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;

    }

    @GetMapping
    ResponseEntity<List<Report>> getAllReports() {
        return new ResponseEntity<>(reportService.getAllReports(), HttpStatus.OK);
    }

    @GetMapping("/pages")
    ResponseEntity<List<Report>> getByPages(@RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(reportService.getReportsByPages(page, size), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Report> newReport(@RequestBody Report newReport) {
        return new ResponseEntity<>(reportService.saveReport(newReport), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteReport(@PathVariable Long id){
        reportService.deleteReport(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
