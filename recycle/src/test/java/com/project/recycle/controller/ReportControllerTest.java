package com.project.recycle.controller;

import com.project.recycle.model.Report;
import com.project.recycle.model.Zone;
import com.project.recycle.service.ReportService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
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
        Report report1 = new Report(LocalDate.of(2021, 1, 18), "Denuncia por vandalismo de 3 chicos", new Zone(), "Lucas Suarez");
        Report report2 = new Report(LocalDate.of(2021, 9, 23), "Denuncia por hurto", new Zone(), "Mirta Braun");
        Report report3 = new Report(LocalDate.of(2022, 3, 03), "Denuncia por mal uso de los desechos", new Zone(), "Marcos Acuña");
        when(reportService.getAllReports()).thenReturn(Arrays.asList(report1, report2, report3));

        ResponseEntity<List<Report>> getReports = reportController.getAllReports();
        assertNotNull(getReports);
        assertEquals(getReports.getBody().size(), 3);
    }

    @Test
    void getByPages() {
        Report report3 = new Report(LocalDate.of(2022, 3, 03), "Denuncia por mal uso de los desechos", new Zone(), "Marcos Acuña");
        Report report4 = new Report(LocalDate.of(2022, 12, 27), "Denuncia por robo de maquinaria", new Zone(), "Pedro Fernandez");

        when(reportService.getReportsByPages(1, 3)).thenReturn(Arrays.asList(report3, report4));
        ResponseEntity<List<Report>> reportsByPages = reportController.getByPages(1, 3);

        assertEquals(2, reportsByPages.getBody().size());
    }

    @Test
    void newReport() {
        Report report1 = new Report(LocalDate.of(2021, 1, 18), "Denuncia por vandalismo de 3 chicos", new Zone(), "Lucas Suarez");
        when(reportService.saveReport(report1)).thenReturn(report1);
        HttpStatusCode reportStatus = reportController.newReport(report1).getStatusCode();
        ResponseEntity<Report> reportSaved = reportController.newReport(report1);

        assertEquals(HttpStatusCode.valueOf(201), reportStatus);
        assertEquals(report1, reportSaved.getBody());

    }

    @Test
    void deleteReport() {
        Report report1 = new Report(1l, LocalDate.of(2021, 1, 18), "Denuncia por vandalismo de 3 chicos", new Zone(), "Lucas Suarez");

        HttpStatusCode reportStatus = reportController.deleteReport(1l).getStatusCode();
        assertEquals(HttpStatusCode.valueOf(204), reportStatus);
    }
}