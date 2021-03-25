package com.cg.jdbcdemo.dao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.jdbcdemo.dto.Employee;
public class EmployeeDAO {
	ArrayList<Employee> elist=null;
	public EmployeeDAO()
	{
		elist=new ArrayList<>();
		elist.add(new Employee(101,"ajay",1000,LocalDate.of(20, 10, 11)));
		elist.add(new Employee(102,"Ashish",2000,LocalDate.of(20, 10, 12)));
		elist.add(new Employee(103,"Ramesh",3000,LocalDate.of(20, 10, 11)));
		elist.add(new Employee(104,"Krishna",4000,LocalDate.of(20, 11, 12)));
	}
	public List<Employee> getAllEmployee(){
		return elist;
	}
	public Employee getEmployee(int empid) {
		for(Employee e:elist)
			if(e.getEmpid()==empid)
				return e;
		throw new RuntimeException("Employee Not Found Exception");
	}
	public boolean deleteEmployee(int empid) {
		for(Employee e:elist)
			if(e.getEmpid()==empid)
				{
				elist.remove(e);
				return true;
				}
		return false;
	}
	public boolean insertEmployee(Employee e) {
		return elist.add(e);
	}
	public boolean modifyEmployee(Employee emp) {
		for(Employee e:elist) {
			if(e.getEmpid()==emp.getEmpid()) {
				e.setEname(emp.getEname());
				e.setSalary(emp.getSalary());
				return true;
			}
			
		}
		throw new RuntimeException("Employee Not Found Exception");
	}
	
}
