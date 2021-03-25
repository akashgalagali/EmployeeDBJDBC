import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cg.jdbcdemo.dao.conn.DBConnection;

public class SelectFormStudents {

	public static void main(String[] args) {
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pst =con.prepareStatement("select * from students");
				ResultSet rs=pst.executeQuery();
				) {
					while(rs.next())
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
