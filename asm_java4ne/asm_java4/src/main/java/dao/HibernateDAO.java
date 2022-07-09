package dao;

import util.JpaUtils;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class HibernateDAO<Entity, Key> {
    protected static EntityManager em = JpaUtils.getEntityManager();
//    @Override
//    protected void finalize() throws Throwable {
//        em.close();
//        super.finalize();
//    }

    public abstract Entity findById(Key id);
    public abstract List<Entity> findAll();
    public abstract List<Entity> findPage(int currentPage, int size);
    public boolean insert(Entity e) {
        return crud("insert", e);
    }


    public boolean update(Entity e) {
        return crud("update", e);
    }
//
    public boolean delete(Key id) {
        Entity e = this.findById(id);
        return crud("delete", e);
    }

    private boolean crud(String action, Entity entity) {
        em.getTransaction().begin();
        try {
            switch(action){
                case "insert":
                    em.persist(entity);
                    break;
                case "update":
                    em.merge(entity);
                    break;
                case "delete":
                    em.remove(entity);
                    break;
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
//            throw new RuntimeException(e.getMessage());
            System.out.println(action + " error: " + e.getMessage());
            return false;
        }
    }


//    public List<Video> findAll(boolean isFav){
//        String jpql = "SELECT o FROM Video o WHERE o.favoritesById IS NOT EMPTY";
//        if(!isFav) {
//            jpql = "SELECT o FROM Video o WHERE o.favoritesById IS EMPTY";
//        }
//        return em.createQuery(jpql, Video.class).getResultList();
//    }
//    public List<Video> findByKeyword(String keyword){
//        String jpql = "SELECT o.videosByVideoId FROM Favorite o WHERE o.videosByVideoId.title LIKE :keyword";
//        return em
//                .createQuery(jpql, Video.class)
//                .setParameter("keyword", "%" + keyword + "%")
//                .getResultList();
//    }
//
//    public List<User> findByRole(boolean role){
//        String jpql = "SELECT o FROM User o WHERE o.admin =:role";
//        TypedQuery<User> query = em.createQuery(jpql,User.class);
//        query.setParameter("role", role);
//        return query.getResultList();
//    }
//
//    public List<User> findByKeyword(String keyword){
//        String jpql = "SELECT o FROM User o WHERE o.fullName LIKE ?0";
//        TypedQuery<User> query = em.createQuery(jpql, User.class);
//        query.setParameter(0, keyword);
//
//        return query.getResultList();
//    }
//
//    public User findOne(String username, String password){
//        String jpql = "SELECT o FROM User o WHERE o.id =:id AND o.password=:pw";
//        TypedQuery<User> query = em.createQuery(jpql, User.class);
//        query.setParameter("id", username);
//        query.setParameter("pw", password);
//
//        return query.getSingleResult();
//    }
//
//    public List<User> findPage(int currentPage, int size){
//        String jpql = "SELECT o FROM User o";
//        TypedQuery<User> query = em.createQuery(jpql, User.class);
//        query
//                .setFirstResult(currentPage*size)
//                .setMaxResults(size);
//        return query.getResultList();
//    }
}
