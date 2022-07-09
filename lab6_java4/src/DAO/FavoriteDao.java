package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entiti.Favorite;





public class FavoriteDao {

	private EntityManager em = jpaUtils.getEntityManager();
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}
	
	public void insert(Favorite entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	
	public void update(Favorite entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	
	public void delete(Integer key) {
		Favorite favorite = this.findById(key);
		try {
			em.getTransaction().begin();	
			em.remove(favorite);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
		
	}

	
	public List<Favorite> findAll() {
		String jpql = "SELECT o FROM Favorite o";
		TypedQuery<Favorite> query = em.createQuery(jpql,Favorite.class);
		List<Favorite> list = query.getResultList();
		return list;
	}

	
	public Favorite findById(Integer key) {
		Favorite favorite = em.find(Favorite.class, key);
		return favorite;
	}
	
}
