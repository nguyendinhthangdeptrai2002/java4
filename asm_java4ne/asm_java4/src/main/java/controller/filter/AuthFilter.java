package controller.filter;

import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", value = {"/admin/*", "/change-password", "/update-profile","/update-like/*", "/favorite" })
public class AuthFilter extends HttpFilter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String uri = req.getRequestURI();
        User auth = (User) req.getSession().getAttribute("auth");
        if(auth == null){
            req.getRequestDispatcher("/jsp/auth/login.jsp").forward(req, res);
        }else if(!auth.getAdmin() && uri.contains("/admin/")){
            req.setAttribute("error", "Bạn không có quyền truy cập trang hiện tại. Vui lòng liên hệ quản trị viên nếu có lỗi xảy ra.");
            req.getRequestDispatcher("/jsp/errorPage.jsp").forward(req,res);
        }else{
            chain.doFilter(req, res);
        }
    }
}
