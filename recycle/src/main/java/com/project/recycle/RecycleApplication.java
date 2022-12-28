package com.project.recycle;

import com.project.recycle.model.Report;
import com.project.recycle.repository.ReportRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RecycleApplication implements CommandLineRunner {
	private final Log LOG = LogFactory.getLog(RecycleApplication.class);
	private ReportRepository reportRepository;

	@Autowired
	public RecycleApplication(ReportRepository repository) {
		this.reportRepository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RecycleApplication.class, args);
	}

	public void saveReportsInDB() {
		Report report1 = new Report(LocalDate.of(2021, 1, 18), "Denuncia por vandalismo de 3 chicos", "Zona 2", "Lucas Suarez");
		Report report2 = new Report(LocalDate.of(2021, 9, 23), "Denuncia por hurto", "Zona 3", "Mirta Braun");
		Report report3 = new Report(LocalDate.of(2022, 3, 03), "Denuncia por mal uso de los desechos", "Zona 1", "Marcos Acuña");
		Report report4 = new Report(LocalDate.of(2022, 12, 27), "Denuncia por robo de maquinaria", "Zona 2", "Pedro Fernandez");
		List<Report> list = Arrays.asList(report1, report2, report3, report4);
		list.forEach(reportRepository::save);
	}

	@Override
	public void run(String... args) throws Exception {
		saveReportsInDB();
	}

}
