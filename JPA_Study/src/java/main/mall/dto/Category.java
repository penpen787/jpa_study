package mall.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MALL_CATEGORY")
public class Category {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "PARENT_ID")
	private long parentId;

	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<CategoryGroup> categoryGroup;
	
	public List<CategoryGroup> getCategoryGroup() {
		return categoryGroup;
	}

	public void setCategoryGroup(List<CategoryGroup> categoryGroup) {
		this.categoryGroup = categoryGroup;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
