package controler;


import java.io.IOException;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.jpaUtils;
import entiti.report.Report;


@WebServlet("/bai1_5")
public class bai1_5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManager em =jpaUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		em.close();// đóng EntiryManager khi DAO bị giải phóng
		super.finalize();
	}
  
    public bai1_5() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/bai1_5.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jpql = "SELECT new Report(o.video.title, count(o), max(o.likeDate), min(o.likeDate)) FROM Favorite o GROUP BY o.video.title";
		TypedQuery<Report> query = em.createQuery(jpql,Report.class);
		List<Report> list = query.getResultList();
		request.setAttribute("video", list);
		request.getRequestDispatcher("/views/bai1_5.jsp").forward(request, response);
		
	}

}
