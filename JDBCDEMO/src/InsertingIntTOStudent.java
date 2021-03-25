import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cg.jdbcdemo.dao.conn.DBConnection;

public class InsertingIntTOStudent {

	public static void main(String[] args) {
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pst=con.prepareStatement("insert  into  students values(?,?,?)")
				) {
			int count=0;
			pst.setInt(1, 1);
			pst.setString(2, "Ashsih");
			pst.setInt(3, 987654321);
			 count +=pst.executeUpdate();
			pst.setInt(1, 2);
			pst.setString(2, "Ashok");
			pst.setInt(3, 876543219);
			 count+=pst.executeUpdate();
			pst.setInt(1, 3);
			pst.setString(2, "Ramesh");
			pst.setInt(3, 765432189);
			count+=pst.executeUpdate();
			pst.setInt(1, 4);
			pst.setString(2, "Krishna");
			pst.setInt(3, 789456412);
			count+=pst.executeUpdate();
			System.out.println(count+" Rows inserted");
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
