package com.project.recycle;

import com.project.recycle.model.Report;
import com.project.recycle.model.Zone;
import com.project.recycle.repository.ReportRepository;
import com.project.recycle.repository.ZoneRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RecycleApplication implements CommandLineRunner {
	private final Log LOG = LogFactory.getLog(RecycleApplication.class);
	private ReportRepository reportRepository;
	private ZoneRepository zoneRepository;

	@Autowired
	public RecycleApplication(ReportRepository reportRepository, ZoneRepository zoneRepository) {
		this.reportRepository = reportRepository;
		this.zoneRepository = zoneRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RecycleApplication.class, args);
	}

	public void saveReportsInDB() {
		Zone zone1 = new Zone("123123", "4124123", "glass", 50000, "Lucas");
		zoneRepository.save(zone1);
		Zone foundZone = zoneRepository.findById(1L).get();
		Report report1 = new Report(LocalDate.of(2021, 1, 18), "Denuncia por vandalismo de 3 chicos", foundZone, "Lucas Suarez");
		Report report2 = new Report(LocalDate.of(2021, 9, 23), "Denuncia por hurto", foundZone, "Mirta Braun");
		Report report3 = new Report(LocalDate.of(2022, 3, 03), "Denuncia por mal uso de los desechos", foundZone, "Marcos Acuña");
		Report report4 = new Report(LocalDate.of(2022, 12, 27), "Denuncia por robo de maquinaria", foundZone, "Pedro Fernandez");
		List<Report> list = Arrays.asList(report1, report2, report3, report4);
		list.forEach(reportRepository::save);

	}

	@Override
	public void run(String... args) {
		saveReportsInDB();
	}

}
