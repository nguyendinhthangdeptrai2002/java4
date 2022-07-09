package dao;

import entity.Favorite;
import entity.User;
import entity.Video;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class FavoriteDAO extends HibernateDAO<Favorite, Long> {
    @Override
    public Favorite findById(Long id) {
        return em.find(Favorite.class, id);
    }

    @Override
    public List<Favorite> findAll() {
        String jpql = "SELECT o FROM Favorite o";
        return em.createQuery(jpql, Favorite.class).getResultList();
    }

    @Override
    public List<Favorite> findPage(int currentPage, int size) {
        String jpql = "SELECT o FROM Favorite o";
        TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
        query
                .setFirstResult(currentPage * size)
                .setMaxResults(size);
        return query.getResultList();
    }

    public Favorite findOne(User user, Video video) {
        String jpql = "SELECT o FROM Favorite o WHERE o.user =:user AND o.video =:video";
        try {
            return em
                    .createQuery(jpql, Favorite.class)
                    .setParameter("user", user)
                    .setParameter("video", video)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public Favorite findOne(User user, String videoID) {
        String jpql = "SELECT o FROM Favorite o WHERE o.user =:user AND o.video.id =:videoID";
        try {
            return em
                    .createQuery(jpql, Favorite.class)
                    .setParameter("user", user)
                    .setParameter("videoID", videoID)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<Favorite> findKeyword(String keyword, User user) {
        String jpql = "SELECT o FROM Favorite o WHERE o.user =:user AND o.video.title like :keyword";
        return em
                .createQuery(jpql, Favorite.class)
                .setParameter("user", user)
                .setParameter("keyword", "%"+ keyword + "%").getResultList();
    }

    public List<Favorite> findKeywordPage(String keyword, User user, int currentPage, int size) {
        String jpql = "SELECT o FROM Favorite o WHERE o.user =:user AND o.video.title like :keyword";
        return em
                .createQuery(jpql, Favorite.class)
                .setParameter("user", user)
                .setParameter("keyword", "%"+ keyword + "%")
                .setFirstResult(currentPage * size)
                .setMaxResults(size)
                .getResultList();
    }

    public List<Favorite> findByUser(User user, int currentPage, int size){
        String jpql = "SELECT o FROM Favorite o WHERE o.user =:user";
        return em
                .createQuery(jpql, Favorite.class)
                .setParameter("user", user)
                .setFirstResult(currentPage * size)
                .setMaxResults(size)
                .getResultList();
    }
}
