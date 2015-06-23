package com.StudentDetail.DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.StudentDetail.Model.Students;

public class StudentDetailDAOImpl implements IStudentDetailDAO {

	public Connection getConnection() throws Exception {
		System.out.println("Driver Loading......");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded in Memory.");

		System.out.println("Establish Connection...........");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/studentdetail", "root", "12345");
		System.out.println("Connection Established.");
		return connection;
	}

	public boolean registerStudent(Students objectStudent) {
		Connection connection;
		boolean status = false;
		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("Insert into studentsdetail values(?,?,?,?,?)");
			preparedStatement.setInt(1, objectStudent.getRollNumber());
			preparedStatement.setString(2, objectStudent.getName());
			preparedStatement.setString(3, objectStudent.getAddress());
			preparedStatement.setString(4, objectStudent.getCity());
			preparedStatement.setString(5, objectStudent.getPassword());
			System.out.println("Added Successfully");
			System.out.println();
			int numberOfUpdates = preparedStatement.executeUpdate();
			if (numberOfUpdates == 1) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public boolean removeStudent(Students objectStudent) {
		Connection connection;
		boolean status = false;
		try {
			connection = getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("Delete from studentsdetail where ROLL_NUMBER=? ");
			preparedStatement.setInt(1, objectStudent.getRollNumber());
			System.out.println("Deleted.");
			System.out.println();
			int numberOfUpdates = preparedStatement.executeUpdate();
			if (numberOfUpdates == 1) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public boolean modifyStudent(Students objectStudent) {
		Connection connection;
		boolean status = false;
		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE STUDENTSDETAIL SET NAME=? where ROLL_NUMBER=?");
			System.out.println("dfhgjkdrighuhg");
			preparedStatement.setInt(1, objectStudent.getRollNumber());
			preparedStatement.setString(2, objectStudent.getName());

			/*
			 * preparedStatement.setString(3, objectStudent.getAddress());
			 * preparedStatement.setString(4, objectStudent.getCity());
			 * preparedStatement.setString(5, objectStudent.getPassword());
			 */

			System.out.println();
			int numberOfUpdate = preparedStatement.executeUpdate();
			System.out.println("dfhgjkdrighuhg");
			if (numberOfUpdate >= 1) {
				System.out.println("Updated");
				status = true;
			} else {
				System.out.println("SORRY");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public void searchStudent(Students objectStudent) {
		Connection connection;

		try {
			connection = getConnection();
			PreparedStatement Preparedstatement = connection
					.prepareStatement("select * from studentsdetail where ROLL_NUMBER=?");
			Preparedstatement.setInt(1, objectStudent.getRollNumber());
			ResultSet resultSet = Preparedstatement.executeQuery();
			while (resultSet.next()) {
				System.out.println();
				System.out.println("Roll Number : "
						+ resultSet.getInt("ROLL_NUMBER") + "\nName : "
						+ resultSet.getString("NAME") + "\nAddress : "
						+ resultSet.getString("ADDRESS") + "\nCity : "
						+ resultSet.getString("CITY") + "\nPassword : "
						+ resultSet.getString("PASSWORD"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void listStudent(Students objectStudent) {
		Connection connection;

		try {
			connection = getConnection();
			PreparedStatement Preparedstatement = connection
					.prepareStatement("select * from studentsdetail ");
			ResultSet resultSet = Preparedstatement.executeQuery();
			while (resultSet.next()) {
				System.out.println();
				System.out.println("Roll Number : "
						+ resultSet.getInt("ROLL_NUMBER") + "\nName : "
						+ resultSet.getString("NAME") + "\nAddress : "
						+ resultSet.getString("ADDRESS") + "\nCity : "
						+ resultSet.getString("CITY") + "\nPassword : "
						+ resultSet.getString("PASSWORD"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean sortByRollNumber(Students objectStudent) {
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement Preparedstatement = connection
					.prepareStatement("select * from studentsdetail order by ROLL_NUMBER ");
			ResultSet resultSet = Preparedstatement.executeQuery();
			while (resultSet.next()) {

				System.out.println("Roll Number : "
						+ resultSet.getInt("ROLL_NUMBER") + "\tName : "
						+ resultSet.getString("NAME") + "\tAddress : "
						+ resultSet.getString("ADDRESS") + "\tCity : "
						+ resultSet.getString("CITY") + "\tPassword : "
						+ resultSet.getString("PASSWORD"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean sortByname(Students objectStudent) {
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement Preparedstatement = connection
					.prepareStatement("select * from studentsdetail order by NAME ");
			ResultSet resultSet = Preparedstatement.executeQuery();
			while (resultSet.next()) {

				System.out.println("Roll Number : "
						+ resultSet.getInt("ROLL_NUMBER") + "\tName : "
						+ resultSet.getString("NAME") + "\tAddress : "
						+ resultSet.getString("ADDRESS") + "\tCity : "
						+ resultSet.getString("CITY") + "\tPassword : "
						+ resultSet.getString("PASSWORD"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

	public boolean sortByAddress(Students objectStudent) {
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement Preparedstatement = connection
					.prepareStatement("select * from studentsdetail order by ADDRESS ");
			ResultSet resultSet = Preparedstatement.executeQuery();
			while (resultSet.next()) {

				System.out.println("Roll Number : "
						+ resultSet.getInt("ROLL_NUMBER") + "\tName : "
						+ resultSet.getString("NAME") + "\tAddress : "
						+ resultSet.getString("ADDRESS") + "\tCity : "
						+ resultSet.getString("CITY") + "\tPassword : "
						+ resultSet.getString("PASSWORD"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean sortByCity(Students objectStudent) {
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement Preparedstatement = connection
					.prepareStatement("select * from studentsdetail order by CITY ");
			ResultSet resultSet = Preparedstatement.executeQuery();
			while (resultSet.next()) {

				System.out.println("Roll Number : "
						+ resultSet.getInt("ROLL_NUMBER") + "\tName : "
						+ resultSet.getString("NAME") + "\tAddress : "
						+ resultSet.getString("ADDRESS") + "\tCity : "
						+ resultSet.getString("CITY") + "\tPassword : "
						+ resultSet.getString("PASSWORD"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

	public boolean sortByPassword(Students objectStudent) {
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement Preparedstatement = connection
					.prepareStatement("select * from studentsdetail order by PASSWORD ");
			ResultSet resultSet = Preparedstatement.executeQuery();
			while (resultSet.next()) {

				System.out.println("Roll Number : "
						+ resultSet.getInt("ROLL_NUMBER") + "\tName : "
						+ resultSet.getString("NAME") + "\tAddress : "
						+ resultSet.getString("ADDRESS") + "\tCity : "
						+ resultSet.getString("CITY") + "\tPassword : "
						+ resultSet.getString("PASSWORD"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
