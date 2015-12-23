package start;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMain {
	
	public static void main(String... args) {
		
		
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

	public static void doBusiness(EntityManager em) {
		String id = "id4";
		Member member = new Member();
		member.setId(id);
		member.setUsername("경훈");
		member.setAge(2);
		
		
		em.persist(member);
		
		// Update
		member.setAge(20);
		
		// 한 건 조회
		Member findMember = em.find(Member.class, id);
		System.out.println("findMemeber : " + findMember.getUsername() + findMember.getAge());
		
		// 목록 조회
		List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
		
		System.out.println("members size=" + members.size());
		
		// 삭제 
//		em.remove(member);
	}
}
