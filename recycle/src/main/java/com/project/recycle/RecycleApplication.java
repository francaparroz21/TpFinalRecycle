package com.project.recycle;


import com.project.recycle.repository.ReportRepository;
import com.project.recycle.repository.ZoneRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecycleApplication {
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

}
