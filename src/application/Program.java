package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
	
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"delete from department "
					+ "where Id = ?"
					);
			
			st.setInt(1, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Feito! Rows afetadas: " + rowsAffected);
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage()); 
		} finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}
		
	}

}
