package com.DAO;

import java.util.ArrayList;
import java.util.List;

import com.entity.ServiceDetails;

public interface ServiceDAO {
	
	public boolean addServices(ServiceDetails service);
		
	public List<ServiceDetails> getAllServices();
	
	public ServiceDetails getServiceById(int id);
	
	public boolean updateEditServices(ServiceDetails service);
	
	public boolean deleteService(int id);

	public List<ServiceDetails> getNewService();
	
	public List<ServiceDetails> getRecentServices();
	
	public List<ServiceDetails> getOldServices();
	
	public List<ServiceDetails> getAllRecentServices();
	
	public List<ServiceDetails> getAllNewServices();
	
	public List<ServiceDetails> getAllOldServices();
	
	public List<ServiceDetails> getServiceByOld(String email, String category);
	
	public boolean oldServiceDelete(String email, String category, int id);
	
	public List<ServiceDetails> getServiceBySerch(String сheck);
}
