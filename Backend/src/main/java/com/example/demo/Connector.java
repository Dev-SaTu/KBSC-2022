package com.example.demo;

import java.sql.*;

public class Connector {

	static String ip;
	static Connection con;
	static Statement stmt;

	private Connector() {
		try {
			String ip = "database-1.cegbnrakdnsa.ap-northeast-2.rds.amazonaws.com";

			Connection con = DriverManager.getConnection(String.format("jdbc:mysql://%s:3306/kb_db", ip), "gihwan", "1z2x3c4v");

			Statement stmt = con.createStatement();
			//String sql = "select * from user";
			//ResultSet result = stmt.executeQuery(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void MakeConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); 

			new Connector();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResultSet getResultSet(String sql) throws SQLException {
		return stmt.executeQuery(sql);
	}

	
}