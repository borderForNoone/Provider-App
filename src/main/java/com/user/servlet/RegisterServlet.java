package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("fname");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String password = req.getParameter("password");
		String check = req.getParameter("check");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhno(phno);
		user.setPassword(password);
		
		HttpSession session = req.getSession();
		
		if(check != null) {
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConnection());
			
			boolean userNotExist = dao.checkUser(email);
			if(userNotExist) {
				boolean flag = dao.userRegister(user);
				
				if(flag) {
					session.setAttribute("succMsg", "Registration Successfully..");
					resp.sendRedirect("register.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server..");
					resp.sendRedirect("register.jsp");
				}
			} else {
				session.setAttribute("failedMsg", "User Already Exist Try Another Email");
				resp.sendRedirect("register.jsp");
			}
		} else {
			session.setAttribute("failedMsg", "Please Check Agree & Terms Condition");
			resp.sendRedirect("register.jsp");
		}
	}
	
	

}
