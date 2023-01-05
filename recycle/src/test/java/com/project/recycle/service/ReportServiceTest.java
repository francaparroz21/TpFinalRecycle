package com.project.recycle.service;

import com.project.recycle.model.Report;
import com.project.recycle.repository.ReportRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
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
        Report report1 = new Report(LocalDate.of(2021, 1, 18), "Denuncia por vandalismo de 3 chicos", "Zona 2", "Lucas Suarez");
        Report report2 = new Report(LocalDate.of(2021, 9, 23), "Denuncia por hurto", "Zona 3", "Mirta Braun");
        Report report3 = new Report(LocalDate.of(2022, 3, 03), "Denuncia por mal uso de los desechos", "Zona 1", "Marcos Acuña");
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
        Report report1 = new Report(LocalDate.of(2021, 1, 18), "Denuncia por vandalismo de 3 chicos", "Zona 2", "Lucas Suarez");
        when(reportRepository.save(report1)).thenReturn(report1);

        Report reportSaved = reportService.saveReport(report1);

        assertEquals(report1.getId(), reportSaved.getId());
    }

    @Test
    void deleteReport() {
        String deleted = reportService.deleteReport(1l);
        assertEquals("Report deleted succesfully", deleted);
    }
}