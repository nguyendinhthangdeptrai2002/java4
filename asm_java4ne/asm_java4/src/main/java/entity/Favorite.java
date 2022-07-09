package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "favorites", schema = "dbo", catalog = "asm_java4")
public class Favorite {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "likeDate", nullable = true)
    private Long likeDate;
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "videoID", nullable = false)
    private Video video;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Long likeDate) {
        this.likeDate = likeDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Favorite)) return false;
        Favorite favorite = (Favorite) o;
        return id == favorite.id && likeDate.equals(favorite.likeDate) && user.equals(favorite.user) && video.equals(favorite.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, likeDate, user, video);
    }

    public Favorite() {
    }

    public Favorite(User user, Video video) {
        this.likeDate = new Date().getTime();
        this.user = user;
        this.video = video;
    }
}
