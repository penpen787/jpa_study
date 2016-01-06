package chap5.test;

import javax.persistence.EntityManager;

import chap5.dto.Member;
import chap5.dto.Team;

import common.TransactionBaseTest;

public class RemoveTest extends  TransactionBaseTest {

	@Override
	public void doBusiness(EntityManager em) {
		
		Member m1 = em.find(Member.class, "member1");
		Member m2 = em.find(Member.class, "member2");
		
		Team team = m1.getTeam();
		
		// set team NULL before delete team (FK constraint)
		m1.setTeam(null);
		m2.setTeam(null);
		
		em.remove(team);
	
	}

}
