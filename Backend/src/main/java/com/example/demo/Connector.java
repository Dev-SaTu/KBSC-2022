package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connector {
		
	public Connector() {
	
		try {

			String ip = "database-1.cegbnrakdnsa.ap-northeast-2.rds.amazonaws.com";
			
			Connection con = DriverManager.getConnection(String.format("jdbc:mysql://%s:3306/kb_db", ip), "gihwan", "1z2x3c4v");
			
			Statement stmt = con.createStatement(); 

			String sql = "select * from user";
			ResultSet result = stmt.executeQuery(sql);

			while(result.next()) {

				System.out.println("next");

			}


		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); 

			new Connector();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	
}