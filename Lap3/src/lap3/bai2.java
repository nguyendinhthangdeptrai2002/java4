package lap3;

import java.io.File;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;


import entity.staff;

/**
 * Servlet implementation class bai2
 */
@MultipartConfig
@WebServlet("/bai2")
public class bai2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bai2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/dangky/form.jsp").forward(request, response);
	}
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			File dir = new File(request.getServletContext().getRealPath("/files"));
			Part photo = request.getPart("photo_file");
			File photoFile = new File(dir, photo.getSubmittedFileName());
			photo.write(photoFile.getAbsolutePath());
			System.out.println(dir);
		    staff STAFF = new staff();
		
		    STAFF.setPhoto(photoFile.getName());

    ;
		 
			BeanUtils.populate(STAFF, request.getParameterMap());
			request.setAttribute("bean", STAFF);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	   request.getRequestDispatcher("/view/dangky/result.jsp").forward(request, response);

}}
