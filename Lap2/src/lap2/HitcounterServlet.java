package lap2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HitcounterServlet")
public class HitcounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public HitcounterServlet() {
        super();
        
    }
	int count;
	Path path = Paths.get("c:/temp/count.txt");
	public void init(ServletConfig config)  throws ServletException {
			try {
				count = Integer.parseInt(Files.readAllLines(path).get(0));
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	public void destroy() {
		try {
			Files.write(path, String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//

	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count++;
		request.setAttribute("count", count);
		request.getRequestDispatcher("/views/param/hit-counter.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
