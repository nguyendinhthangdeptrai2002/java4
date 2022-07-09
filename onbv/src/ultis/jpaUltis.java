package ultis;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaUltis {
private static EntityManagerFactory factory;
	
	static public EntityManager getEntityManager() {
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("onthi");
		}
		return factory.createEntityManager();
	}

	static public void shutdown() {
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}
}
