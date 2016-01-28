package chap7.joinstrategy.dto;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NonEntityParent {
	
	@Id
	private String nonEntityParent;

	public String getNontEntityParent() {
		return nonEntityParent;
	}

	public void setNontEntityParent(String nontEntityParent) {
		this.nonEntityParent = nontEntityParent;
	}

}
