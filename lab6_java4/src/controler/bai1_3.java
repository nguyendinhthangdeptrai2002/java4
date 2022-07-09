package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;


@WebServlet("/bai1_3")
public class bai1_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public bai1_3() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/bai1_3.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoid = request.getParameter("videoid");
		UserDao userDao = new UserDao();
		request.setAttribute("videos", userDao.findUserlikeVideo(videoid));
		request.getRequestDispatcher("/views/bai1_3.jsp").forward(request, response);
	}

}
