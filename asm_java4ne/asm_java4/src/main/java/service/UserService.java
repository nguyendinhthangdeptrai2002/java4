package service;

import dao.UserDAO;
import dao.VideoDAO;
import entity.User;
import entity.Video;

public class UserService {
    UserDAO dao = new UserDAO();

    public void insert(User user) throws Exception {
        validate("insert", user);
        dao.insert(user);
    }

    public void update(User user) throws Exception {
        validate("update", user);
        dao.update(user);
    }

    public void delete(User user) throws Exception {
        validate("delete", user);
        dao.delete(user.getId());
    }

    public void validate(String action, User user) throws Exception {
        switch (action) {
            case "insert":
                if (user == null) throw new Exception("Không thể thêm mới người dùng: null");
                else if (user.getId() == null || user.getId().isEmpty()) throw new Exception("Chưa nhập User ID");
                else if (dao.findById(user.getId())!= null) throw new Exception("ID User đã tồn tại");
                else if(user.getFullName()== null || user.getFullName().isEmpty()) throw new Exception("Chưa nhập username");
                break;
            case "update":
                if (user == null) throw new Exception("Không thể cập nhật người dùng");
                else if (user.getId() == null || user.getId().isEmpty()) throw new Exception("Chưa nhập User ID");
                else if (dao.findById(user.getId()) == null) throw new Exception("Không tìm thấy User ID");
                else if(user.getFullName()== null || user.getFullName().isEmpty()) throw new Exception("Chưa nhập tên người dùng");
                else if(user.getPassword()== null || user.getPassword().isEmpty()) throw new Exception("Chưa nhập mật khẩu người dùng");
                else if(user.getPassword().length()<8) throw new Exception("Mật khẩu dài hơn 8 kí tự");
                break;
            case "delete":
                if (user == null || user.getId() == null || user.getId().isEmpty() || dao.findById(user.getId()) == null) {
                    throw new Exception("Không tìm thấy user cần xoá");
                }
                break;
        }
    }
}
