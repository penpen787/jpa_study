package mall.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Item {

	@Id @GeneratedValue
	private Long id;
	private String name;
	private int price;
	private int qty;
	
	@OneToMany(mappedBy = "item")
	private List<CategoryGroup> categoryGroup;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
