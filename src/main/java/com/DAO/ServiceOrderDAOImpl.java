package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.ServiceOrder;

public class ServiceOrderDAOImpl implements ServiceOrderDAO {
	
	private Connection connection;

	public ServiceOrderDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean saveOrder(List<ServiceOrder> serviceList) {
		boolean flag = false;
		try {
			String sql = "insert into service_order(order_id, user_name, email, address, phone, service_name, provider, price, payment) values(?,?,?,?,?,?,?,?,?)";
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			for(ServiceOrder service : serviceList) {
				preparedStatement.setString(1, service.getOrderId());
				preparedStatement.setString(2, service.getUserName());
				preparedStatement.setString(3, service.getEmail());
				preparedStatement.setString(4, service.getFullAddress());
				preparedStatement.setString(5, service.getPhno());
				preparedStatement.setString(6, service.getServiceName());
				preparedStatement.setString(7, service.getProvider());
				preparedStatement.setString(8, service.getPrice());
				preparedStatement.setString(9, service.getPaymentType());
				preparedStatement.addBatch();
			}
			int[] count = preparedStatement.executeBatch();
			connection.commit();
			flag = true;
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<ServiceOrder> getService(String email) {
		List<ServiceOrder> list = new ArrayList<ServiceOrder>();
		ServiceOrder order = null;
		
		try {
			String sql = "select * from service_order where email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				order = new ServiceOrder();
				order.setId(resultSet.getInt(1));
				order.setOrderId(resultSet.getString(2));
				order.setUserName(resultSet.getString(3));
				order.setEmail(resultSet.getString(4));
				order.setFullAddress(resultSet.getString(5));
				order.setPhno(resultSet.getString(6));
				order.setServiceName(resultSet.getString(7));
				order.setProvider(resultSet.getString(8));
				order.setPrice(resultSet.getString(9));
				order.setPaymentType(resultSet.getString(10));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ServiceOrder> getAllOrder() {
		List<ServiceOrder> list = new ArrayList<ServiceOrder>();
		ServiceOrder order = null;
		
		try {
			String sql = "select * from service_order";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				order = new ServiceOrder();
				order.setId(resultSet.getInt(1));
				order.setOrderId(resultSet.getString(2));
				order.setUserName(resultSet.getString(3));
				order.setEmail(resultSet.getString(4));
				order.setFullAddress(resultSet.getString(5));
				order.setPhno(resultSet.getString(6));
				order.setServiceName(resultSet.getString(7));
				order.setProvider(resultSet.getString(8));
				order.setPrice(resultSet.getString(9));
				order.setPaymentType(resultSet.getString(10));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
