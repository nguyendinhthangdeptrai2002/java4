package controller;

import dao.UserDAO;
import entity.User;
import org.apache.commons.beanutils.BeanUtils;
import service.LoginService;
import util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "LoginServlet", value = {"/login", "/logout", "/signup", "/forgot-password", "/update-profile","/change-password"})
public class LoginServlet extends HttpServlet {
    private UserDAO dao = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String fw = "";
        LoginService service = new LoginService(req, resp);
        if (uri.contains("logout")) service.logout();
        else if (uri.contains("signup")) req.getRequestDispatcher("/jsp/auth/signup.jsp").forward(req, resp);
        else if (uri.contains("login")) {
            req.setAttribute("username", CookieUtil.getValue("username", req));
            req.setAttribute("password", CookieUtil.getValue("password", req));
            req.getRequestDispatcher("/jsp/auth/login.jsp").forward(req, resp);
        } else if (uri.contains("forgot-password")) req.getRequestDispatcher("/jsp/auth/forgetPassword.jsp").forward(req, resp);
        else if (uri.contains("update-profile")) req.getRequestDispatcher("/jsp/auth/update.jsp").forward(req, resp);
        else if(uri.contains("change-password")) req.getRequestDispatcher("/jsp/auth/changePassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("logout")) new LoginService(req, resp).logout();
        else if (uri.contains("signup")) signup(req, resp);
        else if (uri.contains("login")) login(req, resp);
        else if (uri.contains("forgot-password")) forgotPassword(req, resp);
        else if (uri.contains("update-profile")) updateProfile(req, resp);
        else if(uri.contains("change-password")) changePassword(req, resp);
    }

    private void changePassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginService service = new LoginService(req, resp);
        try{
            User auth = (User) req.getSession().getAttribute("auth");
            System.out.println(auth);
            System.out.println(auth.getId());
            service.changePassword(auth);
            if(auth.getAdmin()) resp.sendRedirect("admin/video-list");
            else resp.sendRedirect("index");
        }catch(Exception e){
            req.getSession().setAttribute("error", e.getMessage());
            resp.sendRedirect("change-password");
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginService service = new LoginService(req, resp);
        User user = new User(req.getParameter("id"), req.getParameter("password"));
        try {
            service.login(user);
            System.out.println("Login success");
        } catch (Exception e) {
//            e.printStackTrace();
            req.getSession().setAttribute("error", e.getMessage());
            resp.sendRedirect("login");
        }
    }

    private void signup(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginService service = new LoginService(req, resp);
        User user = new User();
        try {
            BeanUtils.populate(user, req.getParameterMap());
            service.signup(user);
        } catch (Exception e) {
            req.getSession().setAttribute("error", e.getMessage());
            resp.sendRedirect("signup");
        }
    }

    private void forgotPassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginService service = new LoginService(req, resp);
        User user = new User();
        user.setId(req.getParameter("id"));
        user.setEmail(req.getParameter("email"));
        service.forgotPassword(user);

    }

    private void updateProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService service = new LoginService(req, resp);
        User user = new User();
        try {
            BeanUtils.populate(user, req.getParameterMap());
            service.update(user);
        } catch (Exception e) {
//            e.printStackTrace();
            req.getSession().setAttribute("error", e.getMessage());
            resp.sendRedirect("update-profile");
        }
    }


}
