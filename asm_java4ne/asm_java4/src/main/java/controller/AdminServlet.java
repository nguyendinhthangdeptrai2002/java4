package controller;

import dao.*;
import entity.Favorite;
import entity.Share;
import entity.User;
import entity.Video;
import entity.report.FavoriteReport;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.VideoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "AdminServlet", value = {"/admin/*"})
public class AdminServlet extends HttpServlet {
    private final VideoDAO vDAO = new VideoDAO();
    private final UserDAO uDAO = new UserDAO();
    private final ReportDAO rDAO = new ReportDAO();
    private final FavoriteDAO fDAO = new FavoriteDAO();
    private final ShareDAO sDAO = new ShareDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("favorite-user")) openFavoriteUser(req, resp);
        else if (uri.contains("index") || uri.contains("favorite"))
            openFavoriteReport(req, resp);
        else if (uri.contains("share-user")) openShareUser(req, resp);
        else if (uri.contains("user-edition")) openUserEdition(req, resp);
        else if (uri.contains("user-list")) openUserList(req, resp);
        else if (uri.contains("video-edition")) openVideoEdition(req, resp);
        else if (uri.contains("video-list")) openVideoList(req, resp);
//        else openUserList(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/video-edition")) editVideo(request, response);
        else if (uri.contains("/user-edition")) editUser(request, response);
        else if (uri.contains("/favorite-user")) openFavoriteUser(request, response);
    }

    private void openShareUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Video> videoList = vDAO.findShareVideos();
        String title = req.getParameter("title");
        List<Video> list = vDAO.findByTitle(title);
        req.setAttribute("videoList", videoList);
        List<Share> shareList = list == null || list.isEmpty() ? null : new ArrayList<>(list.get(0).getShareList());
        if(shareList!=null) shareList.sort((s1, s2)-> s2.getShareDate().compareTo(s1.getShareDate()));
        req.setAttribute("shareList", shareList);
        req.setAttribute("title", title);
        req.getRequestDispatcher("/jsp/admin/share-user.jsp").forward(req, resp);
    }

    private void openFavoriteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Video> videoList = vDAO.findFavoriteVideos();
        req.setCharacterEncoding("utf-8");
        String title = req.getParameter("title");
        List<Video> list = vDAO.findByTitle(title);
        req.setAttribute("videoList", videoList);
        List<Favorite> favList =  list == null || list.isEmpty() ? null : new ArrayList<>(list.get(0).getFavoriteList());
        if(favList!=null) favList.sort((f1, f2)-> f2.getLikeDate().compareTo(f1.getLikeDate()));
        req.setAttribute("favList",favList);
        req.setAttribute("title", title);
        req.getRequestDispatcher("/jsp/admin/favorite-user.jsp").forward(req, resp);
    }

    private void openFavoriteReport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FavoriteReport> list = rDAO.getFavoriteCount();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/jsp/admin/favorite.jsp").forward(req, resp);
    }

    private void openUserList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPage = req.getParameter("page");
        String sSize = req.getParameter("size");
        int page = sPage == null ? 0 : Integer.parseInt(sPage);
        int size = sSize == null ? 10 : Integer.parseInt(sSize);
        int total = uDAO.getSize();
        int lastPage = total % size == 0 ? total / size - 1 : total / size;
        List<User> list = uDAO.findPage(page, size);
        req.setAttribute("list", list);
        req.setAttribute("totalSize", total);
        req.setAttribute("lastPage", lastPage);
        req.setAttribute("currentPage", page);
        req.setAttribute("nextPage", page == lastPage ? page : page + 1);
        req.setAttribute("prevPage", page == 0 ? page : page - 1);
        req.getRequestDispatcher("/jsp/admin/user-list.jsp").forward(req, resp);
    }


    private void openVideoList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPage = req.getParameter("page");
        String sSize = req.getParameter("size");
        int page = sPage == null ? 0 : Integer.parseInt(sPage);
        int size = sSize == null ? 10 : Integer.parseInt(sSize);
        int total = vDAO.getSize();
        int lastPage = total % size == 0 ? total / size - 1 : total / size;
        List<Video> list = vDAO.findPage(page, size);
        req.setAttribute("list", list);
        req.setAttribute("totalSize", total);
        req.setAttribute("lastPage", lastPage);
        req.setAttribute("currentPage", page);
        req.setAttribute("nextPage", page == lastPage ? page : page + 1);
        req.setAttribute("prevPage", page == 0 ? page : page - 1);
        req.getRequestDispatcher("/jsp/admin/video-list.jsp").forward(req, resp);
    }

    private void openVideoEdition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Video video = id == null ? null : vDAO.findById(id);
        req.setAttribute("video", video);
        req.getRequestDispatcher("/jsp/admin/video-edition.jsp").forward(req, resp);
    }

    private void openUserEdition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = id == null ? null : uDAO.findById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/jsp/admin/user-edition.jsp").forward(req, resp);
    }


    private void editVideo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("reset")) response.sendRedirect("/asm_java4/admin/video-edition");
        else {
            VideoService service = new VideoService();
            Video video = new Video();
            try {
                BeanUtils.populate(video, request.getParameterMap());
                video.setActive(video.getActive() != null && video.getActive());
                System.out.println(video);
                if (uri.contains("create")) service.insert(video);
                else if (uri.contains("update")) service.update(video);
                else if (uri.contains("delete")) service.delete(video);
                response.sendRedirect("/asm_java4/admin/video-list");
            } catch (Exception e) {
//                e.printStackTrace();
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/jsp/errorPage.jsp").forward(request, response);
            }
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("reset")) response.sendRedirect("/asm_java4/admin/user-edition");
        else {
            UserService service = new UserService();
            User user = new User();
            try {
                BeanUtils.populate(user, request.getParameterMap());
                user.setAdmin(user.getAdmin() != null && user.getAdmin());
                System.out.println(user);
                if (uri.contains("create")) {
                    service.insert(user);
                    response.sendRedirect("/asm_java4/admin/user-edition?id=" + user.getId());
                } else if (uri.contains("update")) {
                    service.update(user);
                    response.sendRedirect("/asm_java4/admin/user-edition?id=" + user.getId());
                } else if (uri.contains("delete")) {
                    service.delete(user);
                    response.sendRedirect("/asm_java4/admin/user-list");
                }
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/jsp/errorPage.jsp").forward(request, response);
            }
        }
    }
}
