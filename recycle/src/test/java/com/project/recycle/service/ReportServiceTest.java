package com.project.recycle.service;

import com.project.recycle.model.Report;
import com.project.recycle.model.ReportStatus;
import com.project.recycle.repository.ReportRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class ReportServiceTest {

    @Mock
    ReportRepository reportRepository;

    @InjectMocks
    ReportService reportService;

    @Test
    void getAllReports() {
        Report report1 = new Report();
        report1.setDate(LocalDate.of(2021, 9, 23));
        report1.setReportMessage("Denuncia por vandalismo de 3 chicos.");
        report1.setZone(new Zone());
        report1.setComplainant("Cristian Romero");
        report1.setStatus(ReportStatus.RESOLVED);
        Report report2 = new Report(LocalDate.of(2021, 9, 23), "Denuncia por hurto", ReportStatus.RESOLVED , new Zone(), "Mirta Braun");
        Report report3 = new Report(LocalDate.of(2022, 3, 03), "Denuncia por mal uso de los desechos", ReportStatus.RESOLVED, new Zone(), "Marcos Acuña");
        when(reportRepository.findAll()).thenReturn(Arrays.asList(report1, report2, report3));

        List<Report> getReports = reportService.getAllReports();

        assertNotNull(getReports);
        assertEquals(3, reportService.getAllReports().size());

    }

    @Test
    void getReportsByPages() {
    }

    @Test
    void saveReport() {
        Report report1 = new Report(LocalDate.of(2021, 1, 18), "Denuncia por vandalismo de 3 chicos", ReportStatus.RESOLVED, new Zone(), "Lucas Suarez");
        when(reportRepository.save(report1)).thenReturn(report1);

        Report reportSaved = reportService.saveReport(report1);

        assertEquals(report1.getId(), reportSaved.getId());
        assertEquals(report1.getStatus(), reportSaved.getStatus());
        assertEquals(report1.getComplainant(), reportSaved.getComplainant());
        assertEquals(report1.getReportMessage(), reportSaved.getReportMessage());
    }

    @Test
    void deleteReport() {
        boolean deleted = reportService.deleteReport(1l);
        assertEquals(false, deleted);
    }
}