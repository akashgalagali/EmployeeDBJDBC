package com.cg.jdbcdemo.dao2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cg.jdbcdemo.dao.conn.DBConnection;
import com.cg.jdbcdemo.dto.Employee;

public class EmployeeDAO {
	ArrayList<Employee> elist =new ArrayList<>();
	public List<Employee> getAllEmployee(){
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pst=con.prepareStatement("select * from employee");
						ResultSet rs=pst.executeQuery() )
		{
			while(rs.next()) {
				elist.add(new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDate(4).toLocalDate()));
			}
	}catch(Exception ex) {
		System.out.println(ex);
	}
		return elist;
}
	
	public boolean insertEmployee(Employee e) {
		int count=0;
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pst=con.prepareStatement("insert into employee values(?,?,?,?)"))
		{
			pst.setInt(1, e.getEmpid());
			pst.setString(2,e.getEname());
			pst.setDouble(3,e.getSalary());
			pst.setDate(4, Date.valueOf(e.getDoj()));
			count=pst.executeUpdate();
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return count==1;
	}
}
