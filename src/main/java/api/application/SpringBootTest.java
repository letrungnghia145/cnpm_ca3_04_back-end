package api.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.application.repository.Repository;

@SpringBootApplication
public class SpringBootTest implements CommandLineRunner {
	@Autowired
	@Qualifier("account")
	private Repository<?> repository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(repository.read("ACCOUNT01"));
	}
}
