package com.gl.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gl.model.Contacts;

public class ConatctPersistence {

	private static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/contactDB";
		String userName = "root";
		String password = "password";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public String save(Contacts contacts) {
		Connection connection = getConnection();
		try {
			Statement createStatement = connection.createStatement();
			String querry = "INSERT INTO contacts VALUES('" + contacts.getContactId() + "', '" + contacts.getName()
					+ "', '" + contacts.getEmail() + "','" + contacts.getAddress() + "', '" + contacts.getMobileNumber()
					+ "')";
			int executeUpdate = createStatement.executeUpdate(querry);
			if (executeUpdate != 0) {
				return +executeUpdate + " :Contact added to database";
			} else {
				return +executeUpdate + " :Error while adding to database";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error while adding to database";
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Contacts> findContact(Contacts contacts) {
		Connection connection = getConnection();
		ResultSet set = null;
		List<Contacts> list = new ArrayList<>();
		try {
			Statement createStatement = connection.createStatement();
			String querry = "select * from contacts where mobilenumber = '" + contacts.getMobileNumber() + "'";
			set = createStatement.executeQuery(querry);
			while (set.next()) {
				Contacts contact = new Contacts();
				contact.setContactId(Integer.parseInt(set.getString(1)));
				contact.setName(set.getString(2));
				contact.setEmail(set.getString(3));
				contact.setAddress(set.getString(4));
				contact.setMobileNumber(set.getString(5));
				list.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public List<Contacts> findContactById(int contactId) {
		Connection connection = getConnection();
		ResultSet set = null;
		List<Contacts> list = new ArrayList<>();
		try {
			Statement createStatement = connection.createStatement();
			String querry = "select * from contacts where contactId = '" + contactId + "'";
			set = createStatement.executeQuery(querry);
			while (set.next()) {
				Contacts contact = new Contacts();
				contact.setContactId(Integer.parseInt(set.getString(1)));
				contact.setName(set.getString(2));
				contact.setEmail(set.getString(3));
				contact.setAddress(set.getString(4));
				contact.setMobileNumber(set.getString(5));
				list.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public List<Contacts> getContacts() {
		Connection connection = getConnection();
		List<Contacts> list = new ArrayList<>();
		ResultSet set = null;
		try {
			Statement createStatement = connection.createStatement();
			String querry = "select * from contacts";
			set = createStatement.executeQuery(querry);
			while (set.next()) {
				Contacts contact = new Contacts();
				contact.setContactId(Integer.parseInt(set.getString(1)));
				contact.setName(set.getString(2));
				contact.setEmail(set.getString(3));
				contact.setAddress(set.getString(4));
				contact.setMobileNumber(set.getString(5));
				list.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public String update(int contactId, String mobileNumber) {
		Connection connection = getConnection();
		try {
			Statement createStatement = connection.createStatement();
			String querry = "update contacts set mobileNumber = '" + mobileNumber + "' where contactId = '" + contactId
					+ "'";
			int executeUpdate = createStatement.executeUpdate(querry);
			if (executeUpdate != 0) {
				return +executeUpdate + " :contact updated in database";
			} else {
				return +executeUpdate + " :Error while updating in database";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error while updating in database";
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String delete(int contactId) {
		Connection connection = getConnection();
		try {
			Statement createStatement = connection.createStatement();
			String querry = "delete from contacts where contactId = '" + contactId + "'";
			int executeUpdate = createStatement.executeUpdate(querry);
			if (executeUpdate != 0) {
				return +executeUpdate + " :contact deleted in database";
			} else {
				return +executeUpdate + " :Error while deleting in database";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error while deleting in database";
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
