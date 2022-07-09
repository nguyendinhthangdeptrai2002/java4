package entity.report;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UserFavoriteByVideoReport {
    @Id
    private Serializable group;
}
