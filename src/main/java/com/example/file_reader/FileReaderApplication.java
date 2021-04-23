package com.example.file_reader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FileReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileReaderApplication.class, args);
	}

}
