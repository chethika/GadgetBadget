package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Researcher {

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

	public String insertResearcher(String rid, String name, String pname, String pid, String date) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into researcher(`rid`, `name`, `pname`, `pid`,`date`)" + " values ( ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, pname);
			preparedStmt.setString(4, pid);
			preparedStmt.setString(5, date);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the Researchers.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readResearchers() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Research ID</th><th>Research Name</th><th>Project Name</th><th>Project ID</th><th>Date</th></tr>";
			String query = "select * from researcher";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String rid = Integer.toString(rs.getInt("rid"));
				String name = rs.getString("name");
				String pname = rs.getString("pname");
				String pid = Integer.toString(rs.getInt("pid"));
				String date = rs.getString("date");

				output += "<tr><td>" + rid + "</td>";
				output += "<td>" + name + "</td>";
				output += "<td>" + pname + "</td>";
				output += "<td>" + pid + "</td>";
				output += "<td>" + date + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Researchers.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateResearcher(String rid, String name, String pname, String pid, String date) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE researcher SET name=?,pname=?,pid=?,date=?" + "WHERE rid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values

			preparedStmt.setString(1, name);
			preparedStmt.setString(2, pname);
			preparedStmt.setInt(3, Integer.parseInt(pid));
			preparedStmt.setString(4, date);
			preparedStmt.setInt(5, Integer.parseInt(rid));

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

	public String deleteResearcher(String rid) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from researcher where rid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(rid));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the Researcher.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
