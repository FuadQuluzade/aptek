package az.orient.aptek.metods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Methods {
	public static void closeConnection(Connection c, PreparedStatement ps, ResultSet rs) throws Exception {
		if (c != null)
			c.close();
		if (ps != null)
			ps.close();
		if (rs != null)
			rs.close();

	}

}

