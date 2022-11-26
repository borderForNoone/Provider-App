package com.DAO;

import java.util.List;

import com.entity.ServiceDetails;
import com.entity.User;

public interface UserDAO {
	
	public boolean userRegister(User user);
	
	public User login(String email, String password);
	
	public boolean checkPassword(int id, String password);
	
	public boolean updateProfile(User user);
	
	public boolean checkUser(String email);
	
	public List<User> getAllUsers();
	
	public boolean deleteUser(int id);
}
