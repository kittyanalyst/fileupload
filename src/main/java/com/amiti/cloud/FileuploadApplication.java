package com.amiti.cloud;

import com.amiti.cloud.platform.config.Profiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.context.annotation.Profile;

@Profile(Profiles.APPLICATION)
@SpringBootApplication (exclude = {
		FlywayAutoConfiguration.class
})
public class FileuploadApplication {

	private static Logger logger = LoggerFactory.getLogger(FileuploadApplication.class);

	public static void main(String[] args) {


		SpringApplication.run(FileuploadApplication.class, args);

		logger.info("Fileupload API is Ready!");
	}
}
