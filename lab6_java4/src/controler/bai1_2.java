package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VideoDao;
import entiti.Video;


@WebServlet("/bai1_2")
public class bai1_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public bai1_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/bai2_2.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keywword = request.getParameter("keyword");
		VideoDao dao = new VideoDao();
		
		request.setAttribute("videos", dao.findByKeyWord(keywword));
		request.getRequestDispatcher("/views/bai2_2.jsp").forward(request, response);
	}

}
