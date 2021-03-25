import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cg.jdbcdemo.dao.conn.DBConnection;

public class UpdateStudents {

	public static void main(String[] args) {
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pst=con.prepareStatement("update students set std_name=? where std_no=?");
				
				) {
			pst.setString(1,"Deepak");
			pst.setInt(2, 3);
			int count =pst.executeUpdate();
			System.out.println(count+" rows updated");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
