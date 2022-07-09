package com.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HinhChuNhat
 */
@WebServlet("/HinhChuNhat.php")
public class HinhChuNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HinhChuNhat() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/chunhat/form.jsp").forward(req, resp);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String x = req.getParameter("chieudai");
		double dai =Double.parseDouble(x);
		String y = req.getParameter("chieurong");
		double rong = Double.parseDouble(y);
		
	    double dientich = dai *rong;
		double chuvi=(dai+rong)*2;
		
		req.setAttribute("s", +dientich);
		req.setAttribute("c", +chuvi);	
		
		
		req.getRequestDispatcher("/view/chunhat/ket_qua.jsp").forward(req, resp);
	
		
	}

}
