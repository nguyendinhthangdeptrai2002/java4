package controller;

import dao.FavoriteDAO;
import dao.ShareDAO;
import dao.UserDAO;
import dao.VideoDAO;
import entity.Favorite;
import entity.Share;
import entity.User;
import entity.Video;
import util.XMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientServlet", value = {"/index", "/favorite", "/about", "/detail/*", "/share-mail/*", "/update-like/*"})
public class ClientServlet extends HttpServlet {

    private final VideoDAO vDAO = new VideoDAO();
    private final UserDAO uDAO = new UserDAO();
    private final ShareDAO sDAO = new ShareDAO();
    private final FavoriteDAO fDAO = new FavoriteDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/index")) openIndex(req, resp);
        else if (uri.contains("/favorite")) openFavorite(req, resp);
        else if (uri.contains("/detail")) openDetail(req, resp);
        else openAbout(req, resp);
    }

//    private void fakeAuth(HttpServletRequest request){
//        User auth = uDAO.findById("bcaret1");
//        request.getSession().setAttribute("auth", auth);
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/share-mail")) sendMail(request, response);
        else if (uri.contains("/update-like")) updateLike(request, response);
    }


    private void openIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doSearch(req, resp);
        req.getRequestDispatcher("/jsp/client/index.jsp").forward(req, resp);
    }

    private void openFavorite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doSearch(req, resp);
        req.getRequestDispatcher("/jsp/client/favorite.jsp").forward(req, resp);
    }

    private void openAbout(HttpServletRequest req, HttpServletResponse resp) {

    }


    private void openDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Video vid;
        if (id == null || (vid = vDAO.findById(id)) == null) {
            resp.sendRedirect("index");
        } else {
            List<Video> list = vDAO.findPage((int) (Math.random() * (vDAO.getSize() / 10) + 1), 10);
            updateView(vid);
            req.setAttribute("video", vid);
            req.setAttribute("list", list);
            System.out.println(vDAO.getSize());
            req.getRequestDispatcher("/jsp/client/detail.jsp").forward(req, resp);
        }
    }


    private void updateView(Video vid) {
        vid.setViews(vid.getViews() + 1);
        vDAO.update(vid);
    }

    private void updateLike(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //kiểm tra user đã đăng nhập hay chưa
//        fakeAuth(request);
        User auth = (User) request.getSession().getAttribute("auth");
        String videoID = request.getParameter("id");
        Video video = videoID == null ? null : vDAO.findById(videoID);
        if (auth == null || video == null) {
            System.out.println("Video is " + video);
        } else {
            Favorite fav = fDAO.findOne(auth, video);
            if (fav == null) {
                fav = new Favorite(auth, video);
                fDAO.insert(fav);
            } else {
                fDAO.delete(fav.getId());
            }

            String uri = request.getRequestURI();
            String fw = "";
            if (uri.contains("detail")) fw = "/asm_java4/detail?id=" + video.getId();
            else if (uri.contains("favorite")) fw = "/asm_java4/favorite";
            else if (uri.contains("index")) fw = "/asm_java4/index";
            response.sendRedirect(fw);
        }
    }

    private void sendMail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        Video video = vDAO.findById(id);
        User user = (User) request.getSession().getAttribute("auth");
        try {
            XMail.sendMail(email, video.getTitle() + ": " + "https://www.youtube.com/watch?v=" + video.getId(), "VIDEO SHARING");
            Share share = new Share(email, user, video);
            sDAO.insert(share);

            String uri = request.getRequestURI();
            String fw = "";
            if (uri.contains("detail")) fw = "/asm_java4/detail?id=" + video.getId();
            else if (uri.contains("favorite")) fw = "/asm_java4/favorite";
            else if (uri.contains("index")) fw = "/asm_java4/index";

            response.sendRedirect(fw);
        } catch (Exception e) {
            request.getRequestDispatcher("/asm-java4/error").forward(request, response);
        }
    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword");
        String uri = request.getRequestURI();
        User auth = (User) request.getSession().getAttribute("auth");
        String sPage = request.getParameter("page");
        String sSize = request.getParameter("size");
        int page = sPage == null ? 0 : Integer.parseInt(sPage);
        int size = sSize == null ? 12 : Integer.parseInt(sSize);
        int total = 0;

        if (keyword != null && !keyword.isEmpty()) {
            request.setAttribute("keyword", keyword);
            if (uri.contains("favorite") && auth != null) {
                List<Favorite> listTotal = fDAO.findKeyword(keyword, auth);
                total = listTotal.size();
                List<Favorite> listPage = fDAO.findKeywordPage(keyword, auth, page, size);
                request.setAttribute("favList", listPage);
            } else {
                List<Video> list = vDAO.findByKeyword(keyword);
                total = list.size();
                List<Video> listPage = vDAO.findByKeyword(keyword, page, size);
                request.setAttribute("list", listPage);
            }
        } else {
            if (uri.contains("/favorite") && auth != null) {
                List<Favorite> list = fDAO.findByUser(auth, page, size);
                total = auth.getFavoriteList().size();
                request.setAttribute("favList", list);
            } else {
                List<Video> list = vDAO.findPage(page, size);
                total = vDAO.getSize();
                request.setAttribute("list", list);
            }
        }
        int lastPage = total % size == 0 ? total / size - 1 : total / size;
        request.setAttribute("lastPage", lastPage);
        request.setAttribute("currentPage", page);
        request.setAttribute("nextPage", page == lastPage ? page : page + 1);
        request.setAttribute("prevPage", page == 0 ? page : page - 1);
    }
}
