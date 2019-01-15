package org.zerock.persistence;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try (Connection conn = 
				DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"book_ex",
					"book_ex"))
		{
			log.info(conn);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
