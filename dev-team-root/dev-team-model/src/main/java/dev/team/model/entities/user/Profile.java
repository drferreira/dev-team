package dev.team.model.entities.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "profile", catalog = "dev_team", schema = "user")
@SequenceGenerator(name = "ProfileSequence", sequenceName = "profile_seq", initialValue = 1, allocationSize = 1, catalog = "dev_team", schema = "user")
public class Profile implements Serializable{

	private static final long serialVersionUID = -3093155038338078259L;

	@Id
	@GeneratedValue(generator = "ProfileSequence", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(nullable = false)
	private Date birthdate;
	
	protected Profile() {
	}
	
	public Profile(Date birthdate) {
		this.birthdate = birthdate;
	}
}
