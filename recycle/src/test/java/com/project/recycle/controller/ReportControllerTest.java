package com.project.recycle.controller;

import com.project.recycle.model.Report;
import com.project.recycle.model.ReportStatus;
import com.project.recycle.model.Zone;
import com.project.recycle.service.ReportService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class ReportControllerTest {
    @Mock
    ReportService reportService;
    @InjectMocks
    ReportController reportController;

    @Test
    void getAllReports() {
        Report report1 = new Report(LocalDate.of(2021, 1, 18), "Denuncia por vandalismo de 3 chicos", ReportStatus.RESOLVED, new Zone(), "Lucas Suarez");
        Report report2 = new Report(LocalDate.of(2021, 9, 23), "Denuncia por hurto", ReportStatus.PENDING, new Zone(), "Mirta Braun");
        Report report3 = new Report(LocalDate.of(2022, 3, 03), "Denuncia por mal uso de los desechos", ReportStatus.RESOLVED, new Zone(), "Marcos Acuña");
        when(reportService.getAllReports()).thenReturn(Arrays.asList(report1, report2, report3));

        ResponseEntity<List<Report>> getReports = reportController.getAllReports();
        assertNotNull(getReports);
        assertEquals(3, getReports.getBody().size());
        assertEquals(LocalDate.of(2021, 1, 18), getReports.getBody().get(0).getDate());
    }

    @Test
    void getByPages() {
        Report report3 = new Report(LocalDate.of(2022, 3, 03), "Denuncia por mal uso de los desechos", ReportStatus.RESOLVED, new Zone(), "Marcos Acuña");
        Report report4 = new Report(LocalDate.of(2022, 12, 27), "Denuncia por robo de maquinaria", ReportStatus.RESOLVED, new Zone(), "Pedro Fernandez");

        when(reportService.getReportsByPages(1, 3)).thenReturn(Arrays.asList(report3, report4));
        ResponseEntity<List<Report>> reportsByPages = reportController.getByPages(1, 3);

        assertEquals(2, reportsByPages.getBody().size());
    }

    @Test
    void newReport() {
        Report report1 = new Report(LocalDate.of(2021, 1, 18), "Denuncia por vandalismo de 3 chicos", ReportStatus.RESOLVED, new Zone(), "Lucas Suarez");
        when(reportService.saveReport(report1)).thenReturn(report1);
        HttpStatus reportStatus = reportController.newReport(report1).getStatusCode();
        ResponseEntity<Report> reportSaved = reportController.newReport(report1);

        assertEquals(HttpStatus.valueOf(201), reportStatus);
        assertEquals(report1, reportSaved.getBody());
        assertEquals(report1.getZone(), reportSaved.getBody().getZone());

    }

    @Test
    void deleteReport() {
        Report report1 = new Report(LocalDate.of(2021, 1, 18), "Denuncia por vandalismo de 3 chicos", ReportStatus.RESOLVED, new Zone(), "Lucas Suarez");
        report1.setId(1L);
        HttpStatus reportStatus = reportController.deleteReport(1l).getStatusCode();
        assertEquals(HttpStatus.valueOf(204), reportStatus);
    }
}