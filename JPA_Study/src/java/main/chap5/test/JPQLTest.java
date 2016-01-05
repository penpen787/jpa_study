package chap5.test;

import java.util.List;

import javax.persistence.EntityManager;

import chap5.dto.Member;
import common.TransactionBaseTest;

public class JPQLTest extends TransactionBaseTest {

	@Override
	public void doBusiness(EntityManager em) {

		// JPQL is CASE SENSITIVE for object & field names.
		String query = "SELECT M FROM chap5_member M "
				+ "JOIN M.team T WHERE T.name=:teamName";

		List<Member> resultList = em.createQuery(query, Member.class)
				.setParameter("teamName", "팀1")
				.getResultList();

		for (Member member : resultList) {
			logger.debug(member.getUsername());
			
		}
		
	}

}
