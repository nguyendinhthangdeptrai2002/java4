package model;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ClientServlet", value = {"/index", "/favorite", "/about", "/detail/*"})
public class ClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String func = req.getServletPath().substring(req.getServletPath().lastIndexOf("/") + 1); //lay ra duong dan chuc nang can lam
        String uri = "/views/";
        switch(func){
            case "index":
                uri += "index.jsp";
                break;
            case "favorite":
                uri += "favorite.jsp";
                break;
            case "about":
                return;
            case "detail":
                uri += "detail.jsp";
        }
        req.getRequestDispatcher(uri).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
