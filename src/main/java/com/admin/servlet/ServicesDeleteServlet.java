package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;

import com.DAO.ServiceDAOImpl;
import com.DB.DBConnect;

@WebServlet("/deleteService")
public class ServicesDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			
			ServiceDAOImpl dao = new ServiceDAOImpl(DBConnect.getConnection());
			boolean flag = dao.deleteService(id);
			HttpSession session = req.getSession();
			
			if(flag) {
				session.setAttribute("succMsg", "Service Delete Successfully..");
				resp.sendRedirect("admin/all_services.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on server");
				resp.sendRedirect("admin/all_services.jsp");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
