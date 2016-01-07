package mall.test;

import java.util.List;

import javax.persistence.EntityManager;

import mall.dto.Item;
import mall.dto.Member;
import mall.dto.Order;
import mall.dto.OrderItem;

import common.TransactionBaseTest;

public class Chap5TraversalTest extends TransactionBaseTest {

	@Override
	public void doBusiness(EntityManager em) {

		long id = 9L;
		Member m = em.find(Member.class, id);

		logger.debug(m.getName());

		List<Order> orderList = m.getOrders();

		for (Order order : orderList) {
			logger.debug("OrderID: " + order.getId());

			List<OrderItem> orderItems = order.getOrderItems();

			for (int i = 0; i < orderItems.size(); i++) {
				OrderItem orderItem = orderItems.get(i);
				logger.debug("Order Price : " + orderItem.getOrderPrice());

				Item item = orderItem.getItem();

				logger.debug("ITEM : " + item.getName());
			}
		}
	}
}
