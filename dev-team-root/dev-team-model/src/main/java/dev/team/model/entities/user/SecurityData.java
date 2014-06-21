package dev.team.model.entities.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "security_data", catalog = "dev_team", schema = "user")
@SequenceGenerator(name = "SecurityDataSequence", sequenceName = "security_data_seq", initialValue = 1, allocationSize = 1, catalog = "dev_team", schema = "user")
public class SecurityData implements Serializable{

	private static final long serialVersionUID = -4277790492828644652L;

	@Id
	@GeneratedValue(generator = "SecurityDataSequence", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	protected SecurityData() {
	}
	
	public SecurityData(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
