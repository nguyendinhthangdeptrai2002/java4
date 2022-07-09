package entity.report;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name="Report.FavoriteCount", query = "SELECT new FavoriteReport(o.video.title, count(o), min(o.likeDate), max (o.likeDate)) FROM Favorite o group by o.video.title order by count(o) desc")
})
@Entity
public class FavoriteReport {
    @Id
    private Serializable group;
    private long likes;
    private long oldest;
    private long newest;

    public FavoriteReport() {
    }

    public FavoriteReport(Serializable group, long likes, long oldest, long newest) {
        this.group = group;
        this.likes = likes;
        this.oldest = oldest;
        this.newest = newest;
    }

    public Serializable getGroup() {
        return group;
    }

    public void setGroup(Serializable group) {
        this.group = group;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getOldest() {
        return oldest;
    }

    public void setOldest(long oldest) {
        this.oldest = oldest;
    }

    public long getNewest() {
        return newest;
    }

    public void setNewest(long newest) {
        this.newest = newest;
    }
}
