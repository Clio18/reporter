package com.tteam.reporter;

import com.tteam.reporter.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReporterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReporterApplication.class, args);
	}

}
