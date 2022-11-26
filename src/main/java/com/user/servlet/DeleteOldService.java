package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ServiceDAOImpl;
import com.DB.DBConnect;

@WebServlet("/delete_old_service")
public class DeleteOldService extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		int id = Integer.parseInt(req.getParameter("id"));
		ServiceDAOImpl dao = new ServiceDAOImpl(DBConnect.getConnection());
		boolean flag = dao.oldServiceDelete(email, "Old", id);
		HttpSession session = req.getSession();
		
		if(flag) {
			session.setAttribute("succMsg", "Old Service Delete Sucessfully");
			resp.sendRedirect("old_service.jsp");
		} else {
			session.setAttribute("failedMsg", "Something wrong on server");
			resp.sendRedirect("old_service.jsp");
		}
	}
	
	
}
