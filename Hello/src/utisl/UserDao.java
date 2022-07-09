package utisl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entiti.User;

public class UserDao {
	private EntityManager em =jpaUtils.getEntityManager();

	public void UserDAO() {

	}

	@Override
	protected void finalize() throws Throwable {
		em.close();// đóng EntiryManager khi DAO bị giải phóng
		super.finalize();
	}

	public User create(User entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public User update(User entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public User remove(String id) {
		try {
			User entity = this.findById(id);
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
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
}
