package com.example.lettersmigrationpoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lettersmigrationpoc.service.EmployeeLetterService;

@SpringBootApplication
public class LettersMigrationPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(LettersMigrationPocApplication.class, args);
	}
	
	

}

@RestController
class LetterMigrationController{
	
	@Autowired
	private EmployeeLetterService employeeLetterService;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFileData(){
		return employeeLetterService.uploadFileData();
	}
	
	@PostMapping("/migrate")
	public void migrate() {
		employeeLetterService.migrateLetters();
	}
	
}