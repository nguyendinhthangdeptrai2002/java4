package dao;

import entity.Video;

import javax.persistence.TypedQuery;
import java.util.List;

public class VideoDAO extends HibernateDAO<Video, String> {
    @Override
    public Video findById(String id) {
        return em.find(Video.class, id);
    }

    @Override
    public List<Video> findAll() {
        String jpql = "SELECT o FROM Video o";
        return em.createQuery(jpql, Video.class).getResultList();
    }

    @Override
    public List<Video> findPage(int currentPage, int size) {
        String jpql = "SELECT o FROM Video o order by o.views desc";
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        query
                .setFirstResult(currentPage * size)
                .setMaxResults(size);
        return query.getResultList();
    }

    public List<Video> findByTitle(String title){
        String jpql = "SELECT o FROM Video o WHERE o.title like :title";
        return em.createQuery(jpql, Video.class).setParameter("title", "%" + title + "%").getResultList();
    }

    public List<Video> findFavoriteVideos(){
        String jpql = "SELECT o FROM Video o WHERE o.favoriteList is not empty";
        return em.createQuery(jpql, Video.class).getResultList();
    }

    public List<Video> findShareVideos(){
        String jpql = "SELECT o FROM Video o WHERE o.shareList is not empty";
        return em.createQuery(jpql, Video.class).getResultList();
    }

    public int getSize() {
        String sql = "SELECT COUNT(*) FROM Videos";
        return (int) em.createNativeQuery(sql).getSingleResult();
    }

    public List<Video> findByKeyword(String keyword){
        String jpql = "SELECT o FROM Video o WHERE o.title like :keyword";
        return em.createQuery(jpql, Video.class).setParameter("keyword", "%" + keyword + "%").getResultList();
    }

    public List<Video> findByKeyword(String keyword, int currentPage, int size){
        String jpql = "SELECT o FROM Video o WHERE o.title like :keyword";
        return em.createQuery(jpql, Video.class)
                .setParameter("keyword", "%" + keyword + "%")
                .setFirstResult(currentPage * size)
                .setMaxResults(size)
                .getResultList();
    }

}
