package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class FundingBodies {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/paf?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertFundingBodies(String fid, String des, String amount, String date) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into funding_bodies(`fid`,`des`, `amount`, `date`)" + " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, des);
			preparedStmt.setString(3, amount);
			preparedStmt.setString(4, date);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the FundingBodiess.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readFundingBodiess() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Funding ID</th><th>Description</th><th>Amount</th><th>Date</th></tr>";
			String query = "select * from funding_bodies";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String fid = Integer.toString(rs.getInt("fid"));
				String des = rs.getString("des");
				String amount = Float.toString(rs.getFloat("amount"));
				String date = rs.getString("date");

				output += "<tr><td>" + fid + "</td>";
				output += "<td>" + des + "</td>";
				output += "<td>" + amount + "</td>";
				output += "<td>" + date + "</td>";
				
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the FundingBodiess.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateFundingBodies(String fid, String des, String amount, String date) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE funding_bodies SET des=?,amount=?,date=? WHERE fid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values

			preparedStmt.setString(1, des);
			preparedStmt.setFloat(2, Float.parseFloat(amount));
			preparedStmt.setString(3, date);
			preparedStmt.setInt(4, Integer.parseInt(fid));
			

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deleteFundingBodies(String fid) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from funding_bodies where fid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(fid));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the FundingBodies.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
