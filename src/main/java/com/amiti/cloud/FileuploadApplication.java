package com.amiti.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileuploadApplication {

	private static Logger logger = LoggerFactory.getLogger(FileuploadApplication.class);

	public static void main(String[] args) {


		SpringApplication.run(FileuploadApplication.class, args);

		logger.info("Fileupload API is Ready!");
	}
}
