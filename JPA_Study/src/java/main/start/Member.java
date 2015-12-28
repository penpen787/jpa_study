package start;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
/* Unique Constraint 는 DDL 이 생성될때만 영향을 준다
 * But 기술해 놓으면 개발자가 코드만 보고 테이블의 Unique 조건을 알 수 있다.
 * @see 그렇다면 테이블과 코드의 Sync 문제는? 죽은코드가 되는게 아닐까?
 */ 
@Table(name="MEMBER", uniqueConstraints = {
		@UniqueConstraint(
				name ="NAME_AGE_UNIQUE",
				columnNames = {"NAME", "AGE"}
				)
})
public class Member {
	
	@Id	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME", nullable = false, length = 10)
	private String username;
	
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date joinDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Lob
	private String description;
	
	
	/**
	 * Getters & Setters
	 */
	public String getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public Integer getAge() {
		return age;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public RoleType getRoleType() {
		return roleType;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}


