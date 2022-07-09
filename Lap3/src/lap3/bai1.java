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

//không được quên 
@MultipartConfig
@WebServlet("/Upload")
public class bai1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public bai1() {
        super();
      
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/view/upload/form.jsp").forward(request, response);
	}
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	   
	   File dir= new File(request.getServletContext().getRealPath("/files"));
	   System.out.println(dir);
	    
	   Part photo = request.getPart("photo_file"); 
	   File photofile = new File(dir,photo.getSubmittedFileName());
	   photo.write(photofile.getAbsolutePath());
	   
	   System.out.println(""+dir);	
	   Part doc = request.getPart("doc_file");
	   File docFile =new File(dir,doc.getSubmittedFileName());
	   doc.write(docFile.getAbsolutePath());
	   // hien thi
	   request.setAttribute("img", photofile);
	   request.setAttribute("doc", docFile);
	   
	   request.getRequestDispatcher("/view/upload/result.jsp").forward(request, response);
	 		
	}

}
