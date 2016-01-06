package chap5.test;

import javax.persistence.EntityManager;

import chap5.dto.Member;
import chap5.dto.Team;

import common.TransactionBaseTest;

public class Chap5Test extends  TransactionBaseTest {

	@Override
	public void doBusiness(EntityManager em) {
		
		Member m1 = new Member("member3", "회원1");
		Member m2 = new Member("member4", "회원2");
		
		Team team1 = new Team("team1", "팀1");
		
		m1.setTeam(team1);
		m2.setTeam(team1);
		
		Team findTeam = m1.getTeam();
		
		em.persist(team1);
		em.persist(m1);
		em.persist(m2);
		
	}

}