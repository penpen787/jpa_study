package mall.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Order {

	@Id @GeneratedValue
	private Long id;
	
	@Column(name = "MEMEBER_ID")
	private Long memberId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	public Long getId() {
		return id;
	}

	public Long getMemberId() {
		return memberId;
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

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
