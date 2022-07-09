package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase;


@WebServlet( {"/login","/loginup"})
public class test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
    public test1() {
        super();
        // TODO Auto-generated constructor stub
    }
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/view/user/loginup.jsp").forward(request, response);
		
	}   
        
	    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regex= ("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
	  
		String requesturi= request.getRequestURI().toString();   
	   if(requesturi.contains("login")) {
		   
		String user= request.getParameter("username").toString();
	    String pass= request.getParameter("password").toString(); 
		  
	   if(user.trim().length()==0 )
	   {
		   request.setAttribute("error", "tên đăng nhập không được để trống");
		   request.getRequestDispatcher("/view/user/login.jsp").forward(request, response);
	   }
	   else if(pass.trim().length()==0)
	   {
		   request.setAttribute("error", " mật khẩu không được để trống");
		   request.getRequestDispatcher("/view/user/login.jsp").forward(request, response);  
	   }
	   else if(user.trim().length()>6){
		   request.setAttribute("error", "Tên không được quá dài");
		   request.getRequestDispatcher("/view/user/login.jsp").forward(request, response);
	   }
	   else if(pass.trim().length()<6 ) {
		   request.setAttribute("error", "mật khẩu phải trên 6 ký tự");
		   request.getRequestDispatcher("/view/user/login.jsp").forward(request, response);
	   }
	   else if( !pass.matches(regex)) {
		   request.setAttribute("error", "mật khẩu phải có chữ hoa chữ thường <br> một số và một ký tự đặc biệt");
		   request.getRequestDispatcher("/view/user/login.jsp").forward(request, response);
	   }
	   
	   else if(!(user.equals("admin")&& pass.equals("Dinhthang1998!"))) {
		   request.setAttribute("error", "sai tài khoản và mật khẩu");
		   request.getRequestDispatcher("/view/user/login.jsp").forward(request, response);
	   }
	   else {
		   request.setAttribute("name", user);
		   request.getRequestDispatcher("/view/user/hello.jsp").forward(request, response);;
	   }
	   
	   
	   }
	   else {
		  request.getRequestDispatcher("/view/user/loginup.jsp").forward(request, response);
		
		  
		  
	}
		
		
	   
	   
		
	}
   private void dangky(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String regex= ("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
		  String regexemail = ("^[a-zA-Z][\\\\w-]+@([\\\\w]+\\\\.[\\\\w]+|[\\\\w]+\\\\.[\\\\w]{2,}\\\\.[\\\\w]{2,})$");
		String requesturi= request.getRequestURI().toString();  
	   String user= request.getParameter("username").toString();
	    String pass= request.getParameter("password").toString(); 
	    String confim = request.getParameter("confim-pass").toString();
	    String email = request.getParameter("email").toString();
	   if(user.trim().length()==0 )
	   {
		   request.setAttribute("error", "tên đăng nhập không được để trống");
		   request.getRequestDispatcher("/view/user/loginup.jsp").forward(request, response);
	   }
	   else if(pass.trim().length()==0)
	   {
		   request.setAttribute("error", " mật khẩu không được để trống");
		   request.getRequestDispatcher("/view/user/loginup.jsp").forward(request, response); 
	   }
	   else if(user.trim().length()>6){
		   request.setAttribute("error", "Tên không được quá dài");
		   request.getRequestDispatcher("/view/user/loginup.jsp").forward(request, response);
	   }
	   else if(pass.trim().length()<6 ) {
		   request.setAttribute("error", "mật khẩu phải trên 6 ký tự");
		   request.getRequestDispatcher("/view/user/loginup.jsp").forward(request, response);
	   }
	   else if( !pass.matches(regex)) {
		   request.setAttribute("error", "mật khẩu phải có chữ hoa chữ thường <br> một số và một ký tự đặc biệt");
		   request.getRequestDispatcher("/view/user/loginup.jsp").forward(request, response);
	   }
	   else if(!pass.equals(confim)) {
		   request.setAttribute("error", "xác nhận mật khẩu không đúng ");
		   request.getRequestDispatcher("/view/user/loginup.jsp").forward(request, response);
	   }
	   else if(!email.matches(regexemail)) {
		   request.setAttribute("error", "không đúng định dạng email");
		   request.getRequestDispatcher("/view/user/loginup.jsp").forward(request, response);
	   }
	   
   }
   
}
