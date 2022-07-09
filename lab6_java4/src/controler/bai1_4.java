package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VideoDao;


@WebServlet("/bai1_4")
public class bai1_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public bai1_4() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   request.getRequestDispatcher("/views/bai1_4.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VideoDao dao = new VideoDao();
		boolean favorite =Boolean.parseBoolean(request.getParameter("favorite"));
		request.setAttribute("favorite", dao.showVideo(favorite));
		request.getRequestDispatcher("/views/bai1_4.jsp").forward(request, response);
	}

}
