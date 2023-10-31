package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="emp")
public class Employee implements Serializable {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "EMP_ID_SEQ",initialValue = 8000,allocationSize = 1)
	@GeneratedValue(generator ="gen1",strategy = GenerationType.SEQUENCE )
	private Integer empno;	
	@Column(length = 30)
	private String ename;
	@Column(length = 30)
	private String job;
	
	private Integer mgr;
	
	private Double sal;
	
	private Integer deptno;
}