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
 * Servlet implementation class Servlet
 */ 
@WebServlet({"/user/index","/user/edit/*","/user/create","/user/update","/user/delete"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// thêm hai dòng để fix tiếng việt
    	resp.setContentType("text/html;charset=UTF-8");
    	req.setCharacterEncoding("utf-8");
    	
		UserDao dao = new UserDao();
		User user = new User();
		String uri = req.getRequestURI();
		
		if(uri.contains("edit")) { //user/edit/id
			String id = uri.substring(uri.lastIndexOf("/")+1);
			user = dao.findById(id);
		}else if(uri.contains("create")) { //user/create
			try {
				BeanUtils.populate(user, req.getParameterMap());
				dao.create(user);
				req.setAttribute("message", "Thêm mới thành công");
			}catch (Exception e) {
				req.setAttribute("message", "Thêm mới thất bại");
			}
		}else if(uri.contains("update")) { //user/update
			try {
				BeanUtils.populate(user, req.getParameterMap());
				dao.update(user);
				req.setAttribute("message", "Cập nhật thành công");
			}catch (Exception e) {
				req.setAttribute("message", "Cập nhật thất bại");
			}
		}else if(uri.contains("delete")) { //user/delete
			try {
				String id = req.getParameter("id");
				dao.remove(id);
				req.setAttribute("message", "Xóa thành công");
			}catch (Exception e) {
				req.setAttribute("message", "Xóa thất bại");
			}
		}
		
		req.setAttribute("form", user); //form: User
		req.setAttribute("items", dao.findAll()); //items: List<User>
		/*
		// Truy vấn
		List<User> list = dao.findAll();
		// Hiển thị kết quả truy vấn
		for(User u : list) {
			System.out.println("--------------------------");
			System.out.println(">>ID: " + u.getId());
			System.out.println(">>Fullname: " + u.getFullname());
			System.out.println(">>Email: " + u.getEmail());
			System.out.println(">>Is Admin: " + u.getAdmin());
		}
		*/
		req.getRequestDispatcher("/views/User.jsp").forward(req, resp);
	}
}

   