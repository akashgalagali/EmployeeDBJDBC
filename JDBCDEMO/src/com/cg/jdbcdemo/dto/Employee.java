package com.cg.jdbcdemo.dto;
import java.time.LocalDate;

public class Employee {
	private int empid;
	private String ename;
	private double salary;
	LocalDate doj;
	
	public Employee() {
		
	}

	public Employee(int empid, String ename, double salary, LocalDate doj) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.salary = salary;
		this.doj = doj;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

}
