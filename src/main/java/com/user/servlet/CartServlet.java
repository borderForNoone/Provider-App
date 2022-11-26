package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.ServiceDAOImpl;
import com.DB.DBConnect;
import com.entity.Cart;
import com.entity.ServiceDetails;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int serviceid = Integer.parseInt(req.getParameter("serviceid"));
		int userid = Integer.parseInt(req.getParameter("userid"));
		
		ServiceDAOImpl dao = new ServiceDAOImpl(DBConnect.getConnection());
		ServiceDetails service = dao.getServiceById(serviceid);
		
		Cart cart = new Cart();
		cart.setServiceid(serviceid);
		cart.setUserId(userid);
		cart.setServiceName(service.getServiceName());
		cart.setProvider(service.getProvider());
		cart.setPrice(Double.parseDouble(service.getPrice()));
		cart.setTotalPrice(Double.parseDouble(service.getPrice()));
		
		CartDAOImpl dao2 = new CartDAOImpl(DBConnect.getConnection());
		boolean flag = dao2.addCart(cart);
		
		HttpSession session = req.getSession(); 
		
		if(flag) {
			session.setAttribute("succMsg", "Service Added to cart");
			resp.sendRedirect("all_new_services.jsp");
		} else {
			session.setAttribute("failedMsg", "Something Wrong on server");
			resp.sendRedirect("all_new_services.jsp");
		}
	}
	

}
