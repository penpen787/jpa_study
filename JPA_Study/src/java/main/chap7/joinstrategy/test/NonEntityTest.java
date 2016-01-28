package chap7.joinstrategy.test;

import javax.persistence.EntityManager;

import chap7.joinstrategy.dto.EntityChild;
import common.TransactionBaseTest;

public class NonEntityTest extends TransactionBaseTest {

	@Override
	public void doBusiness(EntityManager em) {
		EntityChild ec = new EntityChild();
		ec.setNontEntityParent("Parent");
		ec.setChildName("CHILD");
		
		em.persist(ec);
	}

}
