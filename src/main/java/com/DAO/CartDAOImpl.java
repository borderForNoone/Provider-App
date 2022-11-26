package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;
import com.entity.ServiceDetails;

public class CartDAOImpl implements CartDAO {
	
	private Connection connection;
	
	public CartDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean addCart(Cart cart) {
		boolean flag = false;
		try {
			String sql = "insert into cart(serviceid, userid, serviceName, provider, price, total_price) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cart.getServiceid());
			preparedStatement.setInt(2, cart.getUserId());
			preparedStatement.setString(3, cart.getServiceName());
			preparedStatement.setString(4, cart.getProvider());
			preparedStatement.setDouble(5, cart.getPrice());
			preparedStatement.setDouble(6, cart.getTotalPrice());
			
			int index = preparedStatement.executeUpdate();
			if(index == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Cart> getServiceByUser(int userId) {
		List<Cart> list = new ArrayList<Cart>();
		Cart cart = null;
		double totalPrice = 0;
		try {
			String sql = "select * from cart where userid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				cart = new Cart();
				cart.setCartid(resultSet.getInt(1));
				cart.setServiceid(resultSet.getInt(2));
				cart.setUserId(resultSet.getInt(3));
				cart.setServiceName(resultSet.getString(4));
				cart.setProvider(resultSet.getString(5));
				cart.setPrice(resultSet.getDouble(6));
				
				totalPrice = totalPrice + resultSet.getDouble(7);
				cart.setTotalPrice(totalPrice);
				
				list.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteService(int cartid ,int serviceid, int userid) {
		boolean flag = false;
		try {
			String sql = "delete from cart where cartid=? and serviceid=? and userid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cartid);
			preparedStatement.setInt(2, serviceid);
			preparedStatement.setInt(3, userid);
			
			int index = preparedStatement.executeUpdate();
			if(index == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return flag;
	}
	
	
	
}
