package dao;

import entity.report.FavoriteReport;
import util.JpaUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class ReportDAO {

    private EntityManager em = JpaUtils.getEntityManager();

    public List<FavoriteReport> getFavoriteCount(){
        return em.createNamedQuery("Report.FavoriteCount", FavoriteReport.class).getResultList();
    }
}
