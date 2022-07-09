package dao;

import entity.User;
import entity.Video;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO extends HibernateDAO<User, String>{

    @Override
    public User findById(String id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        String jpql = "SELECT o FROM User o";
        return em.createQuery(jpql, User.class).getResultList();
    }

    @Override
    public List<User> findPage(int currentPage, int size) {
        String jpql = "SELECT o FROM User o order by o.admin desc";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query
                .setFirstResult(currentPage*size)
                .setMaxResults(size);
        return query.getResultList();
    }

    public int getSize() {
        String sql = "SELECT COUNT(*) FROM Users";
        return (int) em.createNativeQuery(sql).getSingleResult();
    }
}
