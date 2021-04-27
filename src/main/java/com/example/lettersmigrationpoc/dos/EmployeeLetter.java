package com.example.lettersmigrationpoc.dos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "test_poc")
@Data
public class EmployeeLetter {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    
    @Column(name="EMPLOYEE_ID")
    private long employeeId;
    
	@Column(name="DOC_TYPE")
    private String docType;
    
    @Column(name="GENERATED_ON" ,columnDefinition = "bigint default 0")
    private long date;

}
