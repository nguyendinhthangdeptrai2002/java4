package service;

import dao.VideoDAO;
import entity.Video;

public class VideoService {
    VideoDAO dao = new VideoDAO();

    public void insert(Video video) throws Exception {
        validate("insert", video);
        dao.insert(video);
    }

    public void update(Video video) throws Exception {
        validate("update", video);
        dao.update(video);
    }

    public void delete(Video video) throws Exception {
        validate("delete", video);
        dao.delete(video.getId());
    }

    public void validate(String action, Video video) throws Exception {
        switch (action) {
            case "insert":
                if (video == null) throw new Exception("Không thể thêm mới video: null");
                else if (video.getId() == null || video.getId().isEmpty()) throw new Exception("Chưa nhập Video ID");
                else if (dao.findById(video.getId())!= null) throw new Exception("ID Video đã tồn tại");
                else if(video.getTitle()== null || video.getTitle().isEmpty()) throw new Exception("Chưa nhập title video");
                System.out.println("After validate");
                    break;
            case "update":
                if (video == null) throw new Exception("Không thể cập nhật video");
                else if (video.getId() == null || video.getId().isEmpty()) throw new Exception("Chưa nhập Video ID");
                else if (dao.findById(video.getId()) == null) throw new Exception("Không tìm thấy Video ID");
                else if(video.getTitle()== null || video.getTitle().isEmpty()) throw new Exception("Chưa nhập title ID");
                break;
            case "delete":
                if (video == null || video.getId() == null || video.getId().isEmpty() || dao.findById(video.getId()) == null) {
                    throw new Exception("Không tìm thấy video cần xoá");
                }
                break;
        }
    }
}
