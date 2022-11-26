package com.DAO;

import java.util.List;

import com.entity.ServiceOrder;

public interface ServiceOrderDAO {
	
	public boolean saveOrder(List<ServiceOrder> serviceList);
	
	public List<ServiceOrder> getService(String email);
	
	public List<ServiceOrder> getAllOrder();
	
}
