package dao;

import entity.Favorite;
import entity.Share;

import javax.persistence.TypedQuery;
import java.util.List;

public class ShareDAO extends HibernateDAO<Share, Long>{
    @Override
    public Share findById(Long id) {
        return em.find(Share.class, id);
    }

    @Override
    public List<Share> findAll() {
        String jpql = "SELECT o FROM Share o";
        return em.createQuery(jpql, Share.class).getResultList();
    }

    @Override
    public List<Share> findPage(int currentPage, int size) {
        String jpql = "SELECT o FROM Share o";
        TypedQuery<Share> query = em.createQuery(jpql, Share.class);
        query
                .setFirstResult(currentPage * size)
                .setMaxResults(size);
        return query.getResultList();
    }
}
