package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.ServiceOrderDAOImpl;
import com.DB.DBConnect;
import com.entity.Cart;
import com.entity.ServiceDetails;
import com.entity.ServiceOrder;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id = Integer.parseInt(req.getParameter("id"));
		
		String name = req.getParameter("username");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String address = req.getParameter("address");
		String landmark = req.getParameter("landmark");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String pincode = req.getParameter("pincode");
		String paymentType = req.getParameter("payment");
		String fullAddress = address + ", " + landmark + ", " + city + ", " + state + ", " + pincode;
		CartDAOImpl dao = new CartDAOImpl(DBConnect.getConnection());
		List<Cart> serviceList = dao.getServiceByUser(id);
		
		if(serviceList.isEmpty()) {
			session.setAttribute("failedMsg", "Add Item");
			resp.sendRedirect("checkout.jsp");
		} else {
			ServiceOrderDAOImpl dao2 = new ServiceOrderDAOImpl(DBConnect.getConnection());
			
			ServiceOrder order = null;
			ArrayList<ServiceOrder> orderList = new ArrayList<ServiceOrder>();
			Random random = new Random(); 
			for (Cart cart : serviceList) {
				order = new ServiceOrder();
				order.setOrderId("SERVICE-ORDER-00" + random.nextInt(1000));
				order.setUserName(name);
				order.setEmail(email);
				order.setPhno(phno);
				order.setFullAddress(fullAddress);
				order.setServiceName(cart.getServiceName());
				order.setProvider(cart.getProvider());
				order.setPrice(cart.getPrice()+"");
				order.setPaymentType(paymentType);
				orderList.add(order);
			}
			
			if("noselect".equals(paymentType)) {
				session.setAttribute("failedMsg", "Choose Payment Method");
				resp.sendRedirect("checkout.jsp");
			} else {
				boolean flag = dao2.saveOrder(orderList);
				if(flag) {
					resp.sendRedirect("order_success.jsp");
				} else {
					session.setAttribute("failedMsg", "Your Order Failed");
					resp.sendRedirect("checkout.jsp");
				}
			}
		}
	}
	

}
