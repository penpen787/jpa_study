package chap4.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(
		name = "BOARD_SEQ_GENERATOR",
		sequenceName = "BOARD_SEQ", // DB Sequence name
		initialValue = 1,
		allocationSize = 1
		)
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
		generator = "BOARD_SEQ_GENERATOR")
	private Long id;
	
	@Column(length = 255)
	private String data;
	
	
	public Long getId() {
		return id;
	}
	public String getData() {
		return data;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setData(String data) {
		this.data = data;
	}
}

