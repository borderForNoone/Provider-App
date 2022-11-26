package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.ServiceDetails;

public class ServiceDAOImpl implements ServiceDAO {
	
	private Connection connection;
	
	public ServiceDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean addServices(ServiceDetails service) {
		boolean flag = false;
		
		try {
			String sql = "insert into service_details(serviceName, provider, price, serviceCategory, status, photo, email) values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, service.getServiceName());
			preparedStatement.setString(2, service.getProvider());
			preparedStatement.setString(3, service.getPrice());
			preparedStatement.setString(4, service.getServiceCategory());
			preparedStatement.setString(5, service.getStatus());
			preparedStatement.setString(6, service.getPhotoName());
			preparedStatement.setString(7, service.getEmail());
			
			int сheck = preparedStatement.executeUpdate();
			
			if(сheck == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<ServiceDetails> getAllServices() {
		List<ServiceDetails> list = new ArrayList<ServiceDetails>();
		ServiceDetails service = null;
		
		try {
			String sql = "select * from service_details";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				service = new ServiceDetails();
				service.setServiceId(resultSet.getInt(1));
				service.setServiceName(resultSet.getString(2));
				service.setProvider(resultSet.getString(3));
				service.setPrice(resultSet.getString(4));
				service.setServiceCategory(resultSet.getString(5));
				service.setStatus(resultSet.getString(6));
				service.setPhotoName(resultSet.getString(7));
				service.setEmail(resultSet.getString(8));
				list.add(service);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ServiceDetails getServiceById(int id) {
		ServiceDetails service = null;
		
		try {
			String sql = "select * from service_details where serviceId=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				service = new ServiceDetails();
				service.setServiceId(resultSet.getInt(1));
				service.setServiceName(resultSet.getString(2));
				service.setProvider(resultSet.getString(3));
				service.setPrice(resultSet.getString(4));
				service.setServiceCategory(resultSet.getString(5));
				service.setStatus(resultSet.getString(6));
				service.setPhotoName(resultSet.getString(7));
				service.setEmail(resultSet.getString(8));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return service;
	}

	@Override
	public boolean updateEditServices(ServiceDetails service) {
		boolean flag = false;
		
		try {
			String sql = "update service_details set serviceName = ?, provider = ?, price = ?, status = ? where serviceId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, service.getServiceName());
			preparedStatement.setString(2, service.getProvider());
			preparedStatement.setString(3, service.getPrice());
			preparedStatement.setString(4, service.getStatus());
			preparedStatement.setInt(5, service.getServiceId());
			
			int check = preparedStatement.executeUpdate();
			
			if(check == 1) {
				flag = true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteService(int id) {
		boolean flag = false;
		
		try {
			String sql = "delete from service_details where serviceId=?";
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

	@Override
	public List<ServiceDetails> getNewService() {
		List<ServiceDetails> list = new ArrayList<ServiceDetails>();
		ServiceDetails service = null;
		try {
			String sql = "select * from service_details where serviceCategory=? and status=? order by serviceId DESC";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "New");
			preparedStatement.setString(2, "Active");
			ResultSet resultSet = preparedStatement.executeQuery();
			int item = 1; 
			while(resultSet.next() && item <= 4) {
				service = new ServiceDetails();
				service.setServiceId(resultSet.getInt(1));
				service.setServiceName(resultSet.getString(2));
				service.setProvider(resultSet.getString(3));
				service.setPrice(resultSet.getString(4));
				service.setServiceCategory(resultSet.getString(5));
				service.setStatus(resultSet.getString(6));
				service.setPhotoName(resultSet.getString(7));
				service.setEmail(resultSet.getString(8));
				list.add(service);
				item++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ServiceDetails> getRecentServices() {
		List<ServiceDetails> list = new ArrayList<ServiceDetails>();
		ServiceDetails service = null;
		try {
			String sql = "select * from service_details where status=? order by serviceId DESC";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "Active");
			ResultSet resultSet = preparedStatement.executeQuery();
			int item = 1; 
			while(resultSet.next() && item <= 4) {
				service = new ServiceDetails();
				service.setServiceId(resultSet.getInt(1));
				service.setServiceName(resultSet.getString(2));
				service.setProvider(resultSet.getString(3));
				service.setPrice(resultSet.getString(4));
				service.setServiceCategory(resultSet.getString(5));
				service.setStatus(resultSet.getString(6));
				service.setPhotoName(resultSet.getString(7));
				service.setEmail(resultSet.getString(8));
				list.add(service);
				item++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ServiceDetails> getOldServices() {
		List<ServiceDetails> list = new ArrayList<ServiceDetails>();
		ServiceDetails service = null;
		try {
			String sql = "select * from service_details where serviceCategory=? and status=? order by serviceId DESC";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "Old");
			preparedStatement.setString(2, "Active");
			ResultSet resultSet = preparedStatement.executeQuery();
			int item = 1; 
			while(resultSet.next() && item <= 4) {
				service = new ServiceDetails();
				service.setServiceId(resultSet.getInt(1));
				service.setServiceName(resultSet.getString(2));
				service.setProvider(resultSet.getString(3));
				service.setPrice(resultSet.getString(4));
				service.setServiceCategory(resultSet.getString(5));
				service.setStatus(resultSet.getString(6));
				service.setPhotoName(resultSet.getString(7));
				service.setEmail(resultSet.getString(8));
				list.add(service);
				item++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ServiceDetails> getAllRecentServices() {
		List<ServiceDetails> list = new ArrayList<ServiceDetails>();
		ServiceDetails service = null;
		try {
			String sql = "select * from service_details where status=? order by serviceId DESC";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "Active");
			ResultSet resultSet = preparedStatement.executeQuery();
	
			while(resultSet.next()) {
				service = new ServiceDetails();
				service.setServiceId(resultSet.getInt(1));
				service.setServiceName(resultSet.getString(2));
				service.setProvider(resultSet.getString(3));
				service.setPrice(resultSet.getString(4));
				service.setServiceCategory(resultSet.getString(5));
				service.setStatus(resultSet.getString(6));
				service.setPhotoName(resultSet.getString(7));
				service.setEmail(resultSet.getString(8));
				list.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ServiceDetails> getAllNewServices() {
		List<ServiceDetails> list = new ArrayList<ServiceDetails>();
		ServiceDetails service = null;
		try {
			String sql = "select * from service_details where serviceCategory=? and status=? order by serviceId DESC";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "New");
			preparedStatement.setString(2, "Active");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				service = new ServiceDetails();
				service.setServiceId(resultSet.getInt(1));
				service.setServiceName(resultSet.getString(2));
				service.setProvider(resultSet.getString(3));
				service.setPrice(resultSet.getString(4));
				service.setServiceCategory(resultSet.getString(5));
				service.setStatus(resultSet.getString(6));
				service.setPhotoName(resultSet.getString(7));
				service.setEmail(resultSet.getString(8));
				list.add(service);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ServiceDetails> getAllOldServices() {
		List<ServiceDetails> list = new ArrayList<ServiceDetails>();
		ServiceDetails service = null;
		try {
			String sql = "select * from service_details where serviceCategory=? and status=? order by serviceId DESC";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "Old");
			preparedStatement.setString(2, "Active");
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				service = new ServiceDetails();
				service.setServiceId(resultSet.getInt(1));
				service.setServiceName(resultSet.getString(2));
				service.setProvider(resultSet.getString(3));
				service.setPrice(resultSet.getString(4));
				service.setServiceCategory(resultSet.getString(5));
				service.setStatus(resultSet.getString(6));
				service.setPhotoName(resultSet.getString(7));
				service.setEmail(resultSet.getString(8));
				list.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ServiceDetails> getServiceByOld(String email, String category) {
		List<ServiceDetails> list = new ArrayList<ServiceDetails>();
		ServiceDetails service = null;
		try {
			String sql = "select * from service_details where serviceCategory=? and email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, category);
			preparedStatement.setString(2, email);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				service = new ServiceDetails();
				service.setServiceId(resultSet.getInt(1));
				service.setServiceName(resultSet.getString(2));
				service.setProvider(resultSet.getString(3));
				service.setPrice(resultSet.getString(4));
				service.setServiceCategory(resultSet.getString(5));
				service.setStatus(resultSet.getString(6));
				service.setPhotoName(resultSet.getString(7));
				service.setEmail(resultSet.getString(8));
				list.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean oldServiceDelete(String email, String category, int id) {
		boolean flag = false;
		try {
			String sql = "delete from service_details where serviceCategory=? and email=? and serviceId=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, category);
			preparedStatement.setString(2, email);
			preparedStatement.setInt(3, id);
			
			int check = preparedStatement.executeUpdate();
			if(check == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<ServiceDetails> getServiceBySerch(String сheck) {
		List<ServiceDetails> list = new ArrayList<ServiceDetails>();
		ServiceDetails service = null;
		try {
			String sql = "select * from service_details where serviceName like ? or provider like ? or serviceCategory like ? and status=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + сheck + "%");
			preparedStatement.setString(2, "%" + сheck + "%");
			preparedStatement.setString(3, "%" + сheck + "%");
			preparedStatement.setString(4, "Active");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				service = new ServiceDetails();
				service.setServiceId(resultSet.getInt(1));
				service.setServiceName(resultSet.getString(2));
				service.setProvider(resultSet.getString(3));
				service.setPrice(resultSet.getString(4));
				service.setServiceCategory(resultSet.getString(5));
				service.setStatus(resultSet.getString(6));
				service.setPhotoName(resultSet.getString(7));
				service.setEmail(resultSet.getString(8));
				list.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
