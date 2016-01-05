package common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class TransactionBaseTest {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void test() {
		// 엔티티 매니저 팩토리 생성
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
				
				// 엔티티 매니저 생성
				EntityManager em = emf.createEntityManager();
				
				// 트랜잭션 획득
				EntityTransaction tx = em.getTransaction();
				
				try {
					tx.begin();	// Start Transaction
					doBusiness(em);
					tx.commit(); // Commit
				} catch(Exception e) {
					e.printStackTrace();
					em.close();
				}
				
				emf.close();
	}
	
	public abstract void doBusiness(EntityManager em);
}
