package com.emiliomoscatiello.brief_registrazione_utente;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class BriefRegistrazioneUtenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BriefRegistrazioneUtenteApplication.class, args);
	}

	// testo la connessione al db
	@Bean
	ApplicationRunner checkDbConnection(DataSource dataSource) {
		return args -> {
			try (Connection conn = dataSource.getConnection()) {
				System.out.println("Connessione al database riuscita: " + conn.getMetaData().getURL());
			} catch (Exception e) {
				System.err.println("Connessione al database fallita: " + e.getMessage());
			}
		};
	}

}
