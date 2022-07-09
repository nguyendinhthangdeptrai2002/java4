package lap3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bai4
 */
@WebServlet("/bai4")
public class bai4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bai4() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    //coockie
    public static class CookieUtils {
    	
    	public static Cookie add(String name, String value, int hours,HttpServletResponse response) {
    		Cookie cookie = new Cookie(name, value);
    		cookie.setMaxAge(hours*60*60);
    		cookie.setPath("/");
    		response.addCookie(cookie);
    		return cookie;
    	}
    
    //đọc giá trị cookie từ cilent 
    public static String get(String name ,HttpServletRequest request) {
    	
    	Cookie[] cookies= request.getCookies();
    	if(cookies != null) {
    		for(Cookie cookie:cookies) {
    			if (cookie.getName().equalsIgnoreCase(name)) {
    				return cookie.getValue();
					
				}
    		}
    	}
		return "";
    	
    }
}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = CookieUtils.get("username", request);
		String password = CookieUtils.get("password", request);
		request.getRequestDispatcher("/view/login/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String remember = request.getParameter("remember");
		
		if(!username.equalsIgnoreCase("fpoly")) {
			request.setAttribute("message", "sai tên đăng nhập!");
		}
		else if(password.length()<6) {
			request.setAttribute("message", "sai mật khẩu !");
		}
		else {
			request.setAttribute("message", "đăng nhâp thành công ");
			//ghi nhớ hoặc xóa tài khoản bằng cookie
			int hours = (remember== null)?0:30*24;//0=xóa
			CookieUtils.add("username", username, hours, response);
			CookieUtils.add("password", password, hours, response);
			
		}
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/view/login/login.jsp").forward(request, response);
	}

}
