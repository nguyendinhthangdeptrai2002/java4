package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list.php")
public class ListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Item> items = Arrays.asList(new Item[] {
				new Item("acer 2020", "hinh1.jpg", 500, 0.1),
				new Item("iphone 5", "hinh2.jpg", 700, 0.15),
				new Item("iPhone X", "hinh1.jpg", 900, 0.25),
				new Item("xiaomi", "hinh2.jpg", 55, 0.3),
				new Item("vinsmart", "hinh1.jpg", 70, 0.5),
				new Item("Oppo 2021", "hinh2.jpg", 200, 0.2)
		});
		req.setAttribute("items", items);
		req.getRequestDispatcher("/views/item/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
