package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.ServiceDetails;
import com.entity.User;

public class UserDAOImpl implements UserDAO {
	
	private Connection connection;

	public UserDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean userRegister(User user) {
		boolean flag = false;
		try {
			String sql = "insert into user(name, email, phno, password) values(?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhno());
			preparedStatement.setString(4, user.getPassword());
			
			int i = preparedStatement.executeUpdate();
			if(i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public User login(String email, String password) {
		User user = null;
		
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPhno(resultSet.getString(4));
				user.setPassword(resultSet.getString(5));
				user.setAddress(resultSet.getString(6));
				user.setLandmark(resultSet.getString(7));
				user.setCity(resultSet.getString(8));
				user.setState(resultSet.getString(9));
				user.setPincode(resultSet.getString(10));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean checkPassword(int id, String password) {
		boolean flag = false;
		try {
			String sql = "select * from user where id=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean updateProfile(User user) {
		boolean flag = false;
		try {
			String sql = "update user set name=?, email=?, phno=? where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhno());
			preparedStatement.setInt(4, user.getId());
			
			int i = preparedStatement.executeUpdate();
			if(i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean checkUser(String email) {
		boolean flag = true;
		
		try {
			String sql = "select * from user where email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		User user = null;
		
		try {
			String sql = "select * from user";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPhno(resultSet.getString(4));
				user.setAddress(resultSet.getString(6));
				user.setLandmark(resultSet.getString(7));
				user.setCity(resultSet.getString(8));
				user.setState(resultSet.getString(9));
				user.setPincode(resultSet.getString(10));
				list.add(user);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean flag = false;
		
		try {
			String sql = "delete from user where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int check = preparedStatement.executeUpdate();
			
			if(check == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
