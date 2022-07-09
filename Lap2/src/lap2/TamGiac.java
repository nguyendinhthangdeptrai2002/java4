package lap2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TamGiac
 */
@WebServlet({"/tamgiac","/dien-tich","/chu-vi"})
public class TamGiac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TamGiac() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/param/tam-giac.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double a =Double.parseDouble(req.getParameter("a"));
		double b =Double.parseDouble(req.getParameter("b"));
		double c =Double.parseDouble(req.getParameter("c"));
		
		if((a+b>c)&&(a+c>b)&&(b+c>a)) {
			double chuVi= a+b+c;
			String uri= req.getRequestURI();
			if(uri.contains("dien-tich")) {
				double dienTich = Math.sqrt(chuVi*(a+b-c)*(a+c-b)*(b+c-a))/4;
				req.setAttribute("message", "Diện tích tam giác : "+ dienTich);
			}
			else {
			req.setAttribute("message", "chu vi là :" + chuVi);	
			}
			
		}
		else
		{
			req.setAttribute("message", "không thỏa mãn điều kiện tam giác!");
		}
		req.getRequestDispatcher("/views/param/tam-giac.jsp").forward(req, resp);
		
		
	}
	

}
