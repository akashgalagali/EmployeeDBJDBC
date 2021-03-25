import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cg.jdbcdemo.dao.conn.DBConnection;

public class DeleteDataStudents {

	public static void main(String[] args) {
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pst=con.prepareStatement("Delete from students where std_no=?")
			
				) {
			pst.setInt(1, 1);
			int count=pst.executeUpdate();
			System.out.println(count+" ROws Deleted");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
