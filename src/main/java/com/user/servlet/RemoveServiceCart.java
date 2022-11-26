package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DB.DBConnect;

@WebServlet("/remove_service")
public class RemoveServiceCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cartidid = Integer.parseInt(req.getParameter("cartid"));
		int serviceid = Integer.parseInt(req.getParameter("serviceid"));
		int userid = Integer.parseInt(req.getParameter("userid"));
		CartDAOImpl dao = new CartDAOImpl(DBConnect.getConnection());
		boolean flag = dao.deleteService(cartidid ,serviceid, userid);
		HttpSession session = req.getSession();
		
		if(flag) {
			session.setAttribute("succMsg", "Service Removed from Cart");
			resp.sendRedirect("checkout.jsp");
		} else {
			session.setAttribute("failedMsg", "Something wrong on server");
			resp.sendRedirect("checkout.jsp");
		}	
	}
}
