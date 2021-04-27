package com.example.lettersmigrationpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lettersmigrationpoc.dos.EmployeeLetter;

public interface EmployeeLetterRepository extends JpaRepository<EmployeeLetter, Long>{

}
