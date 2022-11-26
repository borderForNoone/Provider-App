package com.admin.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.ServiceDAOImpl;
import com.DB.DBConnect;
import com.entity.ServiceDetails;

@WebServlet("/add_services")
@MultipartConfig
public class ServicesAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String serviceName = req.getParameter("serviceName");
			String provider = req.getParameter("provider");
			String price = req.getParameter("price");
			String categories = req.getParameter("categories");
			String status = req.getParameter("status");
			Part part = req.getPart("serviceImage");
			String fileName = part.getSubmittedFileName();
			
			ServiceDetails serviceSetail = new ServiceDetails(serviceName, provider, price, categories, status, fileName, "admin");
			
			ServiceDAOImpl dao = new ServiceDAOImpl(DBConnect.getConnection());
			
			boolean flag = dao.addServices(serviceSetail);
			
			HttpSession session = req.getSession();
			
			if(flag) {
				
				String path = getServletContext().getRealPath("") + "service";
				
				File file = new File(path);
				
				part.write(path + File.separator + fileName);
				
				
				session.setAttribute("succMsg", "Service Add Sucessfully");
				resp.sendRedirect("admin/add_services.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on Server");
				resp.sendRedirect("admin/add_services.jsp");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	

}
