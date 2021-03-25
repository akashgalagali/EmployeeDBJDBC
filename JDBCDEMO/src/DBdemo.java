import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;
import com.cg.jdbcdemo.dao.conn.DBConnection;
import com.cg.jdbcdemo.dto.Employee;
import com.cg.jdbcdemo.service.EmployeeService;

import oracle.jdbc.pool.OracleDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBdemo {
	//allmost jdbc throws sql exception
	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeService();
		
		
		System.out.println(employeeService.insertEmployee(105,"Eashwar",5000, LocalDate.of(21,2,28)));
		
		//System.out.println(employeeService.modifyEmployee(102, "NEwname", 2200));
		
		//System.out.println(employeeService.deleteEmployee(113));
		//Employee e1=employeeService.getEmployee(103);
		//		if(e1!=null)
		//			System.out.println(e1.getEmpid()+e1.getEname()+e1.getSalary());
		List<Employee> elist=employeeService.getAllEmployee();
		for (Employee e : elist) {
			System.out.println(e.getEmpid()+" "+e.getEname()+" "+e.getSalary()+" "+e.getDoj());
			
		}
	}

}


/*


//Connection con=null;
//Statement st=null;
//ResultSet rs=null;
String url="jdbc:oracle:thin:@localhost:1521:xe";
try (Connection con=DBConnection.getConnection();
		//PreparedStatement pst=con.prepareStatement("select * from employee where dept_no=?")
		PreparedStatement pst=con.prepareStatement("select * from dept",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = pst.executeQuery()						//PreparedStatement pst=con.prepareStatement("insert  into  employee values(?,?,?,?,?)")
						//PreparedStatement pst=con.prepareStatement("update employee set emp_sal=? where emp_no=? ")
								//PreparedStatement pst=con.prepareStatement("delete from employee ")
						){
//	con.setAutoCommit(false);
//	pst.setInt(1, 109);
//	pst.setString(2, "Virat");
//	pst.setDouble(3, 405.3);
//	pst.setInt(4,10);
//	pst.setInt(5, 30);
//	int count=pst.executeUpdate();
//	System.out.println(count+" rows Inserted");
//	con.commit();
//	pst.setInt(1, 110);
//	pst.setString(2, "Dhoni");
//	pst.setDouble(3, 565);
//	pst.setInt(4,10);
//	pst.setInt(5, 30);			
//	int count1=pst.executeUpdate();
//	System.out.println(count1+" rows Deleted|Inserted");
//	con.rollback();
	//pst.setDouble(1, 256);
	//pst.setInt(2, 103);
	//int count1=pst.executeUpdate();
	//System.out.println(count1+" rows Inserted");
	//ResultSet rs=pst.executeQuery();
	//Class.forName("oracle.jdbc.driver.OracleDriver");
	//Properties props = new Properties();
	//props.setProperty("user", "scott");
	//props.setProperty("password","tiger");
	
	//con=DriverManager.getConnection(url,props);
	//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	//con = DriverManager.getConnection(url,"scott","tiger");
//	OracleDataSource ods = new OracleDataSource();
//	ods.setDriverType("oracle.jdbc.driver.OracleDriver");
//	ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
//	ods.setUser("scott");
//	ods.setPassword("tiger");
//	con=ods.getConnection();
//	st=con.createStatement();
//	con=DBConnection.getConnection();
//	st=con.createStatement();
//	rs=st.executeQuery("select * from employee");
//	ResultSetMetaData rsmd=rs.getMetaData();
	//int count=rsmd.getColumnCount();
	//for(int i=1;i<=count;i++)
		//	System.out.print(rsmd.getColumnName(i)+" \t");
	//System.out.println();
	while(rs.next()) {
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		//System.out.println(rs.getString("emp_no")+" "+rs.getString("emp_name")+" "+rs.getString("emp_sal")+" "+rs.getString(4));
		//for(int i=1;i<=count;i++) {
			//System.out.print(rs.getString(i)+"\t|\t");
		//}
		//System.out.println();
	
	}
	while(rs.previous())
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
}
catch(Exception e) {
	System.out.println(e);
}
//finally {
//	try {
//
//		if(rs!=null) rs.close();
//		if(st!=null) st.close();
//		if(con!=null) con.close();
//		
//	} catch (Exception e2) {
//		System.out.println(e2);
//	}
//}
*/