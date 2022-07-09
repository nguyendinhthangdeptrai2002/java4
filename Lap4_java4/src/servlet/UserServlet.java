package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user.php")
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// chia sáº» dá»¯ liá»‡u cho jsp
		List<User> users = Arrays.asList(new User[] {
			new User("Nguyễn đình thắng", "123", true),
			new User("hoàng xuân quang", "1234", false),
			new User("mã văn tài", "12345", true)
		});
		req.setAttribute("message", "Quản lý người sử dụng");
		req.setAttribute("form", users.get(0));
		req.setAttribute("items", users);
   // chuyển trang
		req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
