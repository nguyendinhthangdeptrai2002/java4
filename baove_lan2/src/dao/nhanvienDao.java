package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import entity.nhanVien;
import ultis.jpaUltis;





public class nhanvienDao {

	
	private EntityManager em =jpaUltis.getEntityManager();

	public void UserDAO() {

	}

	@Override
	protected void finalize() throws Throwable {
		em.close();// đóng EntiryManager khi DAO bị giải phóng
		super.finalize();
	}

	public nhanVien create(nhanVien entity) {
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

	public nhanVien update(nhanVien entity) {
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

	public nhanVien remove(String id) {
		try {
			nhanVien entity = this.findById(id);
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public nhanVien findById(String id) {
		nhanVien entity = em.find(nhanVien.class, id);
		return entity;
	}

	public List<nhanVien> findAll() {
		String jpql = "SELECT o FROM nhanVien o";
		TypedQuery<nhanVien> query = em.createQuery(jpql, nhanVien.class);
		List<nhanVien> list = query.getResultList();
		return list;
	}
}
