package chap4.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import start.Member;
import start.RoleType;

import common.TransactionBaseTest;

public class MemberSeqTest extends TransactionBaseTest {
	
	@Override
	public void doBusiness(EntityManager em) {
		String id = "id1";
		Member member = new Member();
		member.setId(id);
		member.setUsername("경훈");
		member.setAge(2);
		member.setRoleType(RoleType.USER);
		member.setJoinDate(new Date());
		member.setDescription("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		
		
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
