package mall.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import mall.dto.Item;
import mall.dto.Member;
import mall.dto.Order;
import mall.dto.OrderItem;
import mall.dto.OrderStatus;

import common.TransactionBaseTest;

public class Chap5Test extends TransactionBaseTest {

	@Override
	public void doBusiness(EntityManager em) {
		
		Member m = new Member();
		m.setName("HUN");
		m.setCity("SEL");
		m.setZipcode("012345");
		m.setStreet("Henry St");
		
		em.persist(m);
		
		Item book = new Item();
		book.setName("만화책");
		book.setPrice(5000);
		book.setQty(1);
		
		em.persist(book);
		
		OrderItem orderItem = new OrderItem();
		orderItem.setCount(3);
		orderItem.setItem(book);
		int orderPrice = orderItem.getCount() * orderItem.getItem().getPrice();
		orderItem.setOrderPrice(orderPrice);
		
		
		Order order = new Order();
		order.setMember(m);
		order.setOrderDate(new Date());
		order.setStatus(OrderStatus.ORDER);
		
		// set Order, OrderItem relationship
		orderItem.setOrder(order);
		List<OrderItem> orderItems = order.getOrderItems();
		orderItems.add(orderItem);
		
		em.persist(orderItem);
		em.persist(order);
	}
}
