package chap5.test;

import javax.persistence.EntityManager;

import chap5.dto.Member;
import chap5.dto.Team;

import common.TransactionBaseTest;

public class SelectTest extends  TransactionBaseTest {

	@Override
	public void doBusiness(EntityManager em) {
		
		logger.debug("It works");
		
		Member m1 = em.find(Member.class, "member1");
		
		Team team = m1.getTeam();
		
		logger.debug(team.getName());
	
	}

}
