package com.example.lettersmigrationpoc.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.lettersmigrationpoc.dos.EmployeeLetter;
import com.example.lettersmigrationpoc.repository.EmployeeLetterRepository;

@Service
public class EmployeeLetterService {
	
	@Autowired
	private EmployeeLetterRepository employeeLetterRepository;
	
	@Value("${migrate.letters.source}")
	private String source;
	
	@Value("${migrate.letters.destination}")
	private String dest;

	public ResponseEntity<String> uploadFileData() {
		
		File file = new File(source);
		String[] files = file.list();
		for(String f : files) {
			EmployeeLetter employeeLetter = new EmployeeLetter();
			String[] f1 = f.split("_"); //sample name - 101808_Appraisal Letter 20200804144958.pdf
			employeeLetter.setEmployeeId(Long.parseLong(f1[0]));
			String[] f2 = f1[1].split("\\s\\d+\\.pdf");
			employeeLetter.setDocType(f2[0]);
			String[] f3 = f1[1].split("\\D+");
			String[] f4 = f3[1].split("\\.pdf");
			employeeLetter.setDate(Long.parseLong(f4[0].substring(0, 8)));
			employeeLetterRepository.save(employeeLetter);
		}
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
	
	public void migrateLetters() {
		File sourcePath = new File(source);
		File[] sourceFiles = sourcePath.listFiles();
		try {
			for(File f : sourceFiles) {
				File destPath =  new File(dest+f.getName());
				Files.copy(f.toPath(), destPath.toPath());
			}
			
			System.out.println("Files migrated successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	

}
