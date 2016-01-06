package chap5.test;

import java.util.List;

import javax.persistence.EntityManager;

import chap5.dto.Member;
import chap5.dto.Team;

import common.TransactionBaseTest;

public class OneToManySelectTest extends  TransactionBaseTest {

	@Override
	public void doBusiness(EntityManager em) {
		
		Team team = em.find(Team.class, "team1");
		List<Member> members = team.getMembers();
		
		for (int i=0; i<members.size(); i++) {
			Member member = members.get(i);
			logger.debug(member.getUsername());
			
			member = new Member("M" + i,"MM" + i);
			em.persist(member);
		}
	}
}
