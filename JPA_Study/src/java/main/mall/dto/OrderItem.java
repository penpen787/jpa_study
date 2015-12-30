package mall.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class OrderItem {

	@Id @GeneratedValue
	private Long id;
	
	@Column(name = "ITEM_ID")
	private Long itemId;
	
	private int orderPrice;
	private int count;

	public Long getId() {
		return id;
	}

	public Long getItemId() {
		return itemId;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public int getCount() {
		return count;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
