package service;

import dao.UserDAO;
import entity.User;
import util.CookieUtil;
import util.XMail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginService {
    private UserDAO dao = new UserDAO();
    private HttpServletRequest request;
    private HttpServletResponse response;

    public LoginService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void login(User user) throws Exception {

        validate("login", user);
        User auth = dao.findById(user.getId());
        request.getSession().setAttribute("auth", auth);
        boolean remember = Boolean.parseBoolean(request.getParameter("remember"));
        if (remember) {
            saveCookies(auth);
        } else {
            removeCookies();
        }
        response.sendRedirect("index");
    }

    public void logout() throws IOException {
        System.out.println("Logging out");
        request.getSession().removeAttribute("auth");
        response.sendRedirect("login");
    }

    public void validate(String action, User user) throws Exception {
        switch (action) {
            case "login":
                if (user.getId() == null || user.getId().isEmpty()) throw new Exception("Chưa nhập username");
                else if (user.getPassword() == null || user.getPassword().isEmpty())
                    throw new Exception("Chưa nhập password");
                else if (user.getPassword().length() < 8) throw new Exception("Mật khẩu không hợp lệ");
                else {
                    User auth = dao.findById(user.getId());
                    if (auth == null || !auth.getId().equals(user.getId()) || !auth.getPassword().equals(user.getPassword()))
                        throw new Exception("Tên đăng nhập hoặc mật khẩu không trùng khớp");
                }
                break;
            case "forgot":
                if (user.getId() == null || user.getId().isEmpty() || user.getEmail() == null || user.getEmail().isEmpty())
                    throw new Exception("Thông tin user không hợp lệ");
                else {
                    User dbUser;
                    if ((dbUser = dao.findById(user.getId()) )== null) throw new Exception("Không tìm thấy người dùng");
                    else if (!dbUser.getEmail().equals(user.getEmail())) throw new Exception("Địa chỉ email không hợp lệ");
                }
                break;
        }
    }

    private void saveCookies(User user) {
        CookieUtil.addCookie("username", user.getId(), 60 * 60 * 24, response);
        CookieUtil.addCookie("password", user.getPassword(), 60 * 60 * 24, response);
    }

    private void removeCookies() {
        CookieUtil.addCookie("username", "", 0, response);
        CookieUtil.addCookie("password", "", 0, response);
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void signup(User user) throws Exception {
        UserService service = new UserService();
        service.insert(user);
    }

    public void forgotPassword(User user) throws IOException {
        try {
            validate("forgot", user);
            User dbUser = dao.findById(user.getId());
            XMail.sendMail(dbUser.getEmail(), "Your password is: " + dbUser.getPassword(),"RECOVER PASSWORD");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().getMessage());
        }finally {
            response.sendRedirect("login");
        }

    }

    public void update(User user) throws Exception {
        UserService service = new UserService();
        service.update(user);
        User dbUser = dao.findById(user.getId());
        response.sendRedirect("/asm_java4/index");
    }

    public void changePassword(User auth) throws Exception {
        String id = request.getParameter("id");
        String current = request.getParameter("current");
        String newPass = request.getParameter("new");
        String confirm = request.getParameter("confirm");
        if(auth== null || id==null|| id.isEmpty()) throw new Exception("Không tìm thấy ID");
        else if (!auth.getPassword().equals(current)) throw new Exception("Mật khẩu hiện tại không đúng");
        else if(newPass.length()<8) throw new Exception("Mật khẩu mới không đủ 8 kí tự");
        else if(!newPass.equals(confirm)) throw new Exception("Mật khẩu mới không trùng khớp!");
        else{
            UserService service = new UserService();
            auth.setPassword(newPass);
            service.update(auth);
        }

    }
}
