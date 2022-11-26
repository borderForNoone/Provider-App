package com.DAO;

import java.util.List;

import com.entity.Cart;
import com.entity.ServiceDetails;

public interface CartDAO {

	public boolean addCart(Cart cart);
	 
	public List<Cart> getServiceByUser(int userId);
	
	public boolean deleteService(int cartid, int serviceid, int userid);

}
