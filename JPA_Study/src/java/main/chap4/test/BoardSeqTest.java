package chap4.test;

import java.util.Date;

import javax.persistence.EntityManager;

import chap4.dto.Board;

import common.TransactionBaseTest;

public class BoardSeqTest extends TransactionBaseTest {
	
	@Override
	public void doBusiness(EntityManager em) {
		
		String data = "Data : " + (new Date()).toString(); 
		
		Board board = new Board();
		board.setData(data);
		
		em.persist(board);
		
		// 삭제 
//		em.remove(member);
	}
}
