package com.javajdbcpostgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectdb {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "Shreya@7")) {

			System.out.println("Java JDBC PostgreSQL Example");
		
			System.out.println("Connected to PostgreSQL database!");
			Statement statement = connection.createStatement();
			System.out.println("Reading car records...");
			System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
			ResultSet resultSet = statement.executeQuery("SELECT * FROM public.cars");
			while (resultSet.next()) {
				System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("model"), resultSet.getString("price"));
			}

		} /*catch (ClassNotFoundException e) {
			System.out.println("PostgreSQL JDBC driver not found.");
			e.printStackTrace();
		}*/ catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
	}
}

