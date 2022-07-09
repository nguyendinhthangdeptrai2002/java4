package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.NhanVienDao;

import entity.NhanVien;

/**
 * Servlet implementation class bai1
 */
@WebServlet("/bai1")
public class bai1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bai1() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
    	req.setCharacterEncoding("utf-8");
    	
		NhanVienDao dao= new NhanVienDao();
		NhanVien user = new NhanVien();
		
		
	
		req.setAttribute("form", user); //form: User
		req.setAttribute("nhanvien", dao.findAll()); //items: List<User>
		req.getRequestDispatcher("/views/bai1.jsp").forward(req, resp);
	}

}
