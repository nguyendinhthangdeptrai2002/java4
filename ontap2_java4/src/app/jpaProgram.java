package app;



import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entiti.User;





public class jpaProgram {
	// Náº¡p persistence.xml vÃ  táº¡o EntityManagerFactory
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ontap_java41");
	// Táº¡o EntityManager Ä‘á»ƒ báº¯t Ä‘áº§u lÃ m viá»‡c vá»›i CSDL
	static EntityManager em = emf.createEntityManager();
	
    public static void main (String[] args) {
    	
    			
    			try {
    				em.getTransaction().begin(); // Báº¯t Ä‘áº§u Transaction
    				// MÃƒ THAO TÃ�C
    				
    	
    				
    				em.getTransaction().commit(); // Cháº¥p nháº­n káº¿t quáº£ thao tÃ¡c
    				
    			} catch (Exception e) {
    				em.getTransaction().rollback(); // Há»§y thao tÃ¡c
    				
    			}
    			
    			
    	
    	//delete();
    	//findAll();
    	//findByRole(true);
    	//findByKeyword("nguyen");
    	
    }


}
