package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entiti.User;
import entiti.Video;



public class VideoDao {
	private EntityManager em =jpaUtils.getEntityManager();
	public void VideoDao() {}
	@Override
	protected void finalize() throws Throwable {
		em.close();// đóng EntiryManager khi DAO bị giải phóng
		super.finalize();
	}
	
	public Video findById(String id) {
		Video entity = em.find(Video.class, id);
		return entity;
	}
	public List<Video> findAll() {
		String jpql = "SELECT o FROM User o";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		List<Video> list = query.getResultList();
		return list;
	}
	public List<Video> findByKeyWord(String keyword){
		String jpql = "SELECT DISTINCT o.video FROM Favorite o"
						+" WHERE o.video.title LIKE :keyword";
		TypedQuery<Video> query = em.createQuery(jpql,Video.class);
		query.setParameter("keyword","%"+ keyword + "%");
		List<Video> list = query.getResultList();
		return list;
	}
	public List<Video> showVideo(boolean favorite){
		String jpql = "SELECT o FROM Video o WHERE o.favorites IS EMPTY";
		if(favorite) {
			jpql = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY";
		}
		TypedQuery<Video> query = em.createQuery(jpql,Video.class);
		List<Video> list = query.getResultList();
		return list;
	}
}
