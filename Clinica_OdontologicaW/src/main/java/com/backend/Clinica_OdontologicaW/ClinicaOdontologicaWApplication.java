package com.backend.Clinica_OdontologicaW;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class ClinicaOdontologicaWApplication {

	private static Logger logger = LoggerFactory.getLogger(ClinicaOdontologicaWApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(ClinicaOdontologicaWApplication.class, args);
		crearTabla();
		logger.info("ClinicaOdontologica is now running...");
	}

	private static void crearTabla(){
		Connection connection = null;
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:~/clinicaC1;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}

}
