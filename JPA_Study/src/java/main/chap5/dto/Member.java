package chap5.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "chap5_member")
@Table(name = "C5_MEMBER")
public class Member {

	@Id
	private String id;
	private String username;

	
	/**
	 * 연관관계 매핑
	 */
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public Member() {}
	
	public Member(String id, String username) {
		this.id = id;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public Team getTeam() {
		return team;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTeam(Team team) {
		
		// if member already has team, remove this member from the team.
		if(this.team != null) {
			this.team.getMembers().remove(this);
		}
		
		// make relation each direction
		this.team = team;
		team.getMembers().add(this);
	}

}
