package APP;



import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entiti.User;





public class jpaProgram {
	// Nạp persistence.xml và tạo EntityManagerFactory
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
	// Tạo EntityManager để bắt đầu làm việc với CSDL
	static EntityManager em = emf.createEntityManager();
	
    public static void main (String[] args) {
    	
    			
    			try {
    				em.getTransaction().begin(); // Bắt đầu Transaction
    				// MÃ THAO TÁC
    				
    	
    				
    				em.getTransaction().commit(); // Chấp nhận kết quả thao tác
    				
    			} catch (Exception e) {
    				em.getTransaction().rollback(); // Hủy thao tác
    				
    			}
    			
    			
    	create();
    	//update();
    	//delete();
    	//findAll();
    	//findByRole(true);
    	//findByKeyword("nguyen");
    	
    }

	private static void create() {
		
		User entity = new User();
		entity.setId("");
		entity.setFullname("");
		entity.setEmail("");
		entity.setPassword("");
	
		// Insert vào CSDL
		em.persist(entity);
	
	}
	private static void update() {
		// Truy vấn thực thể theo id
		User entity = em.find(User.class, "TeoNV");
		// Thay đổi thông tin thực thể
		entity.setPassword("poly@2020");
		entity.setAdmin(true);
		// Cập nhật thực th
	
	}
	private static void delete() {
		
		User entity = em.find(User.class, "TeoNV");
		em.remove(entity);
	}
	private static void findAll() {
		
		// Câu lệnh truy vấn JPQL
		String jpql = "SELECT o FROM User o";
		// Tạo đối tượng truy vấn
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		// Truy vấn
		List<User> list = query.getResultList();
		// Hiển thị kết quả truy vấn
		for(User user: list) {
		System.out.println(">>Fullname: " + user.getFullname());
		System.out.println(">>Is Admin: " + user.getAdmin());

	}
	}
	private static void findByRole(boolean role) {
		
		// Câu lệnh truy vấn JPQL
		String jpql = "SELECT o FROM User o WHERE o.admin=:role";
		// Tạo đối tượng truy vấn
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("role", role);
		// Truy vấn
		List<User> list = query.getResultList();
		// Hiển thị kết quả truy vấn

	}
	private static void findByKeyword(String keywork) {
		
		// Câu lệnh truy vấn JPQL
		String jpql = "SELECT o FROM User o WHERE o.fullname LIKE ?0";
		// Tạo đối tượng truy vấn
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter(0, keywork);
		// Truy vấn
		List<User> list = query.getResultList();
	}
	private static void findOne(String username, String password) {
		
		// Câu lệnh truy vấn JPQL
		String jpql = "SELECT o FROM User o WHERE o.id=:id AND o.password=:pw";
		// Tạo đối tượng truy vấn
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("id", username);
		query.setParameter("Password", password);
		// Truy vấn một thực thể
		User user = query.getSingleResult();
		System.out.println(">>Fullname: " + user.getFullname());
		System.out.println(">>Is Admin: " + user.getAdmin());
	}
	private static void findPage(int page, int size) {
		
		
		// Câu lệnh truy vấn JPQL
		String jpql = "SELECT o FROM User o";
		// Tạo đối tượng truy vấn
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		// Truy vấn
		List<User> list = query.getResultList();
		// Hiển thị kết quả truy vấn
		for(User user: list) {
		System.out.println(">>Fullname: " + user.getFullname());
		System.out.println(">>Is Admin: " + user.getAdmin());
	}

}
}