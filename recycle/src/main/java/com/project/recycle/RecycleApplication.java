package com.project.recycle;

import com.project.recycle.model.Classification;
import com.project.recycle.model.Report;
import com.project.recycle.model.Status;
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
public class RecycleApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecycleApplication.class, args);
	}


}
