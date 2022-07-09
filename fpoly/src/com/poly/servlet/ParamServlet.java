package com.poly.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
@WebServlet("/param.php")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.getRequestDispatcher("/view/param/form.jsp").forward(req, resp);
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String hoten = req.getParameter("hoten");		 
		req.setAttribute("message","xin chào "+ hoten);
		req.getRequestDispatcher("/view/param/success.jsp").forward(req, resp);
	}

}
