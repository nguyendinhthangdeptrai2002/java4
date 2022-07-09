package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import entiti.User;
import utils.UserDao;



/**
 * Servlet implementation class AcountServlet
 */
@WebServlet({ "/account/signin", "/account/signup","/account/edit"})
public class AcountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/account/sign-in.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
    	request.setCharacterEncoding("utf-8");
    	String uri = request.getRequestURI().toString();
		if (uri.contains("signin")) {
			this.doSignIn(request, response);
		}
		if (uri.contains("signup")) {
			this.doSignUp(request, response);
		}

	
		if (uri.contains("edit")) {
			this.doEditProfile(request, response);
		}
		
	}
	protected void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		try {
			UserDao dao = new UserDao();
			User user = dao.findById(id);
			if (!user.getPassword().equals(pw)) {
				req.setAttribute("message", "Sai mật khẩu!");
				req.getRequestDispatcher("/views/account/sign-in.jsp").forward(req, resp);
			} else {
				req.setAttribute("message", "Đăng nhập thành công!");
				req.getSession().setAttribute("user", user);
				req.getRequestDispatcher("/views/account/sign-in.jsp").forward(req, resp);
				
			}
		} catch (Exception e) {
			req.setAttribute("error", "Sai tên đăng nhập!");
			e.printStackTrace();
			System.out.println(e);
			req.getRequestDispatcher("/lab5_java4/account/sign-in.jsp").forward(req, resp);
		}

	}

	protected void doSignUp(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw= request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String email= request.getParameter("email");
		try {
			User us = new User();
			BeanUtils.populate(us, request.getParameterMap());
			UserDao dao = new UserDao();
			if(id.length()==0&&pw.length()==0&&fullname.length()==0&&email.length()==0) {
				request.setAttribute("message", "khong duoc bo trong");
			}
			else {
			dao.create(us);
			request.setAttribute("message", "dang ky thanh cong");
			request.getRequestDispatcher("/views/account/sign-up.jsp").forward(request, resp);
			
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Lỗi");
			request.setAttribute("message", "dang ky khong thanh cong");
		}
		request.getRequestDispatcher("/views/account/sign-up.jsp").forward(request, resp);
		

	}

	protected void doEditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		try {
			BeanUtils.populate(user, req.getParameterMap());
			UserDao dao = new UserDao();
			dao.update(user);
			req.setAttribute("message", "Cập nhật tài khoản thành công!");
		} catch (Exception e) {
			req.setAttribute("error", "Lỗi cập nhật tài khoản!");
			System.out.println("lỗi ở đây nè"
					+ "");
		}
		req.getRequestDispatcher("/views/account/edit-profile.jsp").forward(req, resp);
	}

}
