package chap7.joinstrategy.dto;

import javax.persistence.Entity;

@Entity
public class EntityChild extends NonEntityParent {

	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

}
