package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myutils.Util;

public class UserDataAccess {

	private Connection con;
	public static int currentUserID;

	public UserDataAccess() {
		try {
			this.con = Util.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean registerUser(String username, String password) {
		try {
			String query = "INSERT INTO users (username, password) VALUES (?, ?)";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, username);
			stm.setString(2, Util.hashPassword(password));
			int row = stm.executeUpdate();

			if (row > 0) {
				return true;

			} else {
				return false;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

	}

	public boolean loginUser(String username, String password) {

		String hashPassword = Util.hashPassword(password);

		try {
			String query = "SELECT * FROM users WHERE username = ? AND PASSWORD = ?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, username);
			stm.setString(2, hashPassword);
			ResultSet results = stm.executeQuery();

			while (results.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
