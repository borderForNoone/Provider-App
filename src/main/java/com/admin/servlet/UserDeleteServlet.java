package com.admin.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ServiceDAOImpl;
import com.DAO.UserDAOImpl;
import com.DB.DBConnect;

@WebServlet("/deleteUser")
public class UserDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConnection());
			boolean flag = dao.deleteUser(id);
			HttpSession session = req.getSession();
			
			if(flag) {
				session.setAttribute("succMsg", "User Delete Successfully..");
				resp.sendRedirect("admin/all_users.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on server");
				resp.sendRedirect("admin/all_users.jsp");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
