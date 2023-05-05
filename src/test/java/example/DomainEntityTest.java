package example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DomainEntityTest {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
	EntityManager em = factory.createEntityManager();
	
    @Test
	public void testNestedEmbeddedIds() {
		DomainEntity version = new DomainEntity(InnerWrappingId.of(1L), "key");

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(version);
		em.flush();
		tx.commit();

		// Kaboom!
		Object loaded = em.createQuery("select id from DomainEntity").getSingleResult();
		assertEquals(loaded, version.getId());
	}
}
