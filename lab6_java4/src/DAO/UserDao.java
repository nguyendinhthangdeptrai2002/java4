package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entiti.User;
import entiti.Video;

public class UserDao {
	private EntityManager em =jpaUtils.getEntityManager();
	public void UserDao() {}
	@Override
	protected void finalize() throws Throwable {
		em.close();// đóng EntiryManager khi DAO bị giải phóng
		super.finalize();
	
}
	public User findById(String id) {
		User entity = em.find(User.class, id);
		return entity;
	}
	public List<User> findAll() {
		String jpql = "SELECT o FROM User o";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		List<User> list = query.getResultList();
		return list;
	}
	public 	List<User> findUserlikeVideo (String videoID){
		String jpql = "select o.user from Favorite o where o.video.id= :vd";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		query.setParameter("vd", videoID);
		List<User> list= query.getResultList();
		
		return list;
		
	}
}
