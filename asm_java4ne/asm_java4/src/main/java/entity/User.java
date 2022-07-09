package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "dbo", catalog = "asm_java4")
public class User {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 50)
    private String id;
    @Basic
    @Column(name = "password", nullable = true, length = 50)
    private String password;
    @Basic
    @Column(name = "email", nullable = true, length = 150)
    private String email;
    @Basic
    @Column(name = "fullName", nullable = true, length = 250)
    private String fullName;
    @Basic
    @Column(name = "admin", nullable = true)
    private Boolean admin;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.MERGE)
    private Collection<Favorite> favoriteList = new ArrayList<>();
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.MERGE)
    private Collection<Share> shareList = new ArrayList<>();

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin != null && admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(fullName, user.fullName) && Objects.equals(admin, user.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, email, fullName, admin);
    }

    public Collection<Favorite> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(Collection<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public Collection<Share> getShareList() {
        return shareList;
    }

    public void setShareList(Collection<Share> shareList) {
        this.shareList = shareList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", admin=" + admin +
                '}';
    }
}
