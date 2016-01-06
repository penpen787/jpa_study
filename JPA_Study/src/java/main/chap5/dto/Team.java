package chap5.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "chap5_team")
@Table(name = "C5_TEAM")
public class Team {

	@Id
	private String id;
	
	private String name;
	
	// 'mappedBy' property indicates the owner of the relationship,
	// in this case, it points Member.team
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<>();
	
	public Team() {}
	
	public Team(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

}
