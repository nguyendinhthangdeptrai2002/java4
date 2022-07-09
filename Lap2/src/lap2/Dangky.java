package lap2;

import java.io.IOException;
import java.lang.reflect.Array;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicScrollPaneUI.ViewportChangeHandler;
import javax.swing.text.Document;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Servlet implementation class Dangky
 */
@WebServlet("/Dangky")
public class Dangky extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dangky() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		request.getRequestDispatcher("/views/dangky/form.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username").toString();
		String pass = request.getParameter("password");
		boolean gioitinh = Boolean.parseBoolean(request.getParameter("gender"));
		boolean maried = (request.getParameter("married")!=null);
		String country = request.getParameter("country");
		String notes= request.getParameter("notes");
		boolean sothich= Boolean.parseBoolean(request.getParameter("st"));
		System.out.println( ">>username :"+user);
		System.out.println(">>gender: "+ gioitinh);
		System.out.println(">>married: " + maried);
		System.out.println(">>country: " + country);
		if(gioitinh==true) {
			request.setAttribute("gender", "nam");
		}
		else {
			request.setAttribute("gender", "nữ");		
		}
		if( maried==true) {
			request.setAttribute("married", "đã kết hôn");
		}
		else {			
			request.setAttribute("married", "độc thân");		
		}
		String[] hobbies = request.getParameterValues("hobbies");
		System.out.println(">>hobbies: " + hobbies);	 
		request.getRequestDispatcher("/views/dangky/result.jsp").forward(request, response);
			
	}	
}
