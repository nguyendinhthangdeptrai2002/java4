package model;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import entiti.User;
import utisl.UserDao;



/**
 * Servlet implementation class ok
 */
@WebServlet({"/account/signin","/account/signup","/account/forgetpassword"})
public class ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ok() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/login.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		if(uri.contains("forgetpassword")) {
			this.fogotpass(request, response);
		}
		
	}
	protected void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		try {
			utisl.UserDao dao = new utisl.UserDao();
			User user = dao.findById(id);
			if (!user.getPassword().equals(pw)) {
				req.setAttribute("message", "Sai mật khẩu!");
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			} else {
				req.setAttribute("message", "Đăng nhập thành công!");
				req.getSession().setAttribute("user", user);
				req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
				
			}
		} catch (Exception e) {
			req.setAttribute("error", "Sai tên đăng nhập!");
			e.printStackTrace();
			System.out.println(e);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
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
			utisl.UserDao dao = new utisl.UserDao ();
			if(id.length()==0&&pw.length()==0&&fullname.length()==0&&email.length()==0) {
				request.setAttribute("message", "khong duoc bo trong");
			}
			else {
			dao.create(us);
			request.setAttribute("message", "dang ky thanh cong");
			request.getRequestDispatcher("/views/signup.jsp").forward(request, resp);
			
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Lỗi");
			request.setAttribute("message", "dang ky khong thanh cong");
		}
		request.getRequestDispatcher("/views/signup.jsp").forward(request, resp);
		

	}
	protected void fogotpass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
    	req.setCharacterEncoding("utf-8");
		
		
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		try {
			UserDao dao = new UserDao ();
			User user = dao.findById(id);
			if (!user.getEmail().equals(email)) {
				req.setAttribute("message", "Sai email!");
			} else {

				String to = email;
				String subject = "Quên mật khẩu";
				String body = "Mật khẩu của bạn là " + user.getPassword();
				Properties pros = new Properties();
				pros.put("mail.smtp.auth", "true");
				pros.put("mail.smtp.starttls.enable", "true");
				pros.put("mail.smtp.host", "smtp.gmail.com");
				pros.put("mail.smtp.port", 587);
				Session session = Session.getDefaultInstance(pros, new javax.mail.Authenticator() {
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication("thangkisdboy@gmail.com", "dinhthang2002");
					}
				});
				try {
					Message msg = new MimeMessage(session);
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
					msg.setSubject(subject);
					msg.setText(body);
					Transport.send(msg);
					req.setAttribute("message", "Gửi mail thành công");
					System.out.println("chay duoc");
					req.getRequestDispatcher("/views/forgetPassword.jsp").forward(req, resp);
					System.out.println("chay duoc");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception e) {
			req.setAttribute("error", "Sai tên đăng nhập!");
			e.printStackTrace();
			System.out.println("sai tai khoan");
		}

		req.getRequestDispatcher("/views/forgetPassword.jsp").forward(req, resp);

	}
}
