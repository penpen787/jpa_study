package mall.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MALL_ORDER")
public class Order {

	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ORDER_DATE")
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ORDER_STATUS")
	private OrderStatus status;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		// 기존 관계 제거
		if(this.member != null) {
			this.member.getOrders().remove(this);
		}
		this.member = member;
		member.getOrders().add(this);
	}

	public Long getId() {
		return id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
