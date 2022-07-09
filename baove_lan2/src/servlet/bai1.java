package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.nhanvienDao;
import entity.nhanVien;

/**
 * Servlet implementation class bai1
 */
@WebServlet({"/baove_lan2/bai1","/user/edit/*","/user/update"})
public class bai1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bai1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
    	request.setCharacterEncoding("utf-8");
    	
		nhanvienDao dao= new nhanvienDao();
		String uri = request.getRequestURI();
		nhanVien nhanvien= new nhanVien();
		if(uri.contains("edit")) { //user/edit/id
			String id = uri.substring(uri.lastIndexOf("/")+1);
			nhanvien = dao.findById(id);
		}
		else if(uri.contains("update")) { //user/update
			try {
				BeanUtils.populate(nhanvien, request.getParameterMap());
				dao.update(nhanvien);
				
			}catch (Exception e) {
				request.setAttribute("message", "Cập nhật thất bại");
			}
		}
		request.setAttribute("form", nhanvien);
		request.setAttribute("nhanvien", dao.findAll());
		request.getRequestDispatcher("/views/bai1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
