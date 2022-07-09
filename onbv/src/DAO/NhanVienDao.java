package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import entity.NhanVien;
import ultis.jpaUltis;


public class NhanVienDao {

	private EntityManager em =jpaUltis.getEntityManager();

	public void UserDAO() {

	}

	
	protected void finalize() throws Throwable {
		em.close();// đóng EntiryManager khi DAO bị giải phóng
		super.finalize();
	}
	public List<NhanVien> findAll() {
		String jpql = "SELECT o FROM NhanVien o";
		TypedQuery<NhanVien> query = em.createQuery(jpql, NhanVien.class);
		List<NhanVien> list = query.getResultList();
		return list;
	}
}
