 	package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import DAO.VideoDao;
import entiti.Favorite;
import entiti.User;
import entiti.Video;

/**
 * Servlet implementation class bai2
 */
@WebServlet("/index")
public class bai1_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bai1_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**	
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("/views/bai1_1.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		UserDao daoUser = new UserDao(); 
		User user = daoUser.findById(username);
		List<Favorite> favorites = user.getFavorites();
		request.setAttribute("user", user);
		request.setAttribute("favorites", favorites);
		request.getRequestDispatcher("/views//bai1_1.jsp").forward(request, response);
	
		}
	}


