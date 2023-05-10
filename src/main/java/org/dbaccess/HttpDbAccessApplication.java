package org.dbaccess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.LogManager;
@SpringBootApplication
public class HttpDbAccessApplication {

	public static void main(String[] args) {
		try {
			LogManager.getLogManager().readConfiguration(
					HttpDbAccessApplication.class.getResourceAsStream("/logging.properties"));
		}
		catch (IOException e) {
			System.err.println("Could not setup logger configuration: " + e.toString());
		}
		SpringApplication.run(HttpDbAccessApplication.class, args);
	}

}
