package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "shares", schema = "dbo", catalog = "asm_java4")
public class Share {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "email", nullable = true, length = 150)
    private String email;
    @Basic
    @Column(name = "shareDate", nullable = true)
    private Long shareDate;
    @ManyToOne
    @JoinColumn(name = "userID", nullable = true)
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getShareDate() {
        return shareDate;
    }

    public void setShareDate(Long shareDate) {
        this.shareDate = shareDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Share)) return false;
        Share share = (Share) o;
        return id == share.id && email.equals(share.email) && Objects.equals(shareDate, share.shareDate) && user.equals(share.user) && video.equals(share.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, shareDate, user, video);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User usersByUserId) {
        this.user = usersByUserId;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video videosByVideoId) {
        this.video = videosByVideoId;
    }

    public Share() {
    }

    public Share(String email, User user, Video video) {
        this.email = email;
        this.shareDate = new Date().getTime();
        this.user = user;
        this.video = video;
    }
}
