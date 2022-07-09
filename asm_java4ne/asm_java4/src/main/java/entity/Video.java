package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Videos", schema = "dbo", catalog = "asm_java4")
public class Video {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 50)
    private String id;
    @Basic
    @Column(name = "title", nullable = true, length = 250)
    private String title;
    @Basic
    @Column(name = "poster", nullable = true, length = 250)
    private String poster;
    @Basic
    @Column(name = "views", nullable = true)
    private Integer views;
    @Basic
    @Column(name = "description", nullable = true, length = 2147483647)
    private String description;
    @Basic
    @Column(name = "active", nullable = true)
    private Boolean active;
    @OneToMany(mappedBy = "video", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.MERGE)
    private Collection<Favorite> favoriteList = new ArrayList<>();
    @OneToMany(mappedBy = "video", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.MERGE)
    private Collection<Share> shareList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(id, video.id) && Objects.equals(title, video.title) && Objects.equals(poster, video.poster) && Objects.equals(views, video.views) && Objects.equals(description, video.description) && Objects.equals(active, video.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, poster, views, description, active);
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
        return "Video{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", views=" + views +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }
}
