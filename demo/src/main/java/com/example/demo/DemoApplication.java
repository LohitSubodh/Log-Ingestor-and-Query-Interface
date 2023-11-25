package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@SpringBootApplication
@RestController
//@EnableScheduling
public class DemoApplication {

	@Autowired
	private LogRepository logRepository;

	@PostMapping(value = "/")
	public void ingestLogs(@RequestBody Log log) {

		logRepository.save(log);

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

