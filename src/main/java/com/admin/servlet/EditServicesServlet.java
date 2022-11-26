package com.admin.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ServiceDAOImpl;
import com.DB.DBConnect;
import com.entity.ServiceDetails;

@WebServlet("/edit_services")
public class EditServicesServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String serviceName = req.getParameter("serviceName");
			String provider = req.getParameter("provider");
			String price = req.getParameter("price");
			String status = req.getParameter("status");
			
			ServiceDetails service = new ServiceDetails();
			service.setServiceId(id);
			service.setServiceName(serviceName);
			service.setProvider(provider);
			service.setPrice(price);
			service.setStatus(status);
			
			ServiceDAOImpl dao = new ServiceDAOImpl(DBConnect.getConnection());
			boolean flag = dao.updateEditServices(service);
			
			HttpSession session = req.getSession();
			
			if(flag) {
				session.setAttribute("succMsg", "Service Update Successfully..");
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
