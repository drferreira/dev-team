package dev.team.model.entities.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user", catalog = "dev_team", schema = "user")
@SequenceGenerator(name = "UserSequence", sequenceName = "user_seq", initialValue = 1, allocationSize = 1, catalog = "dev_team", schema = "user")
public class User implements Serializable{

	private static final long serialVersionUID = -128640737043981840L;

	@Id
	@GeneratedValue(generator = "UserSequence", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private Date creationDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id")
	private Profile profile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "security_data_id")
	private SecurityData securityData;
	
	public User() {
		creationDate = new Date();
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Profile getProfile() {
		return profile;
	}

	public SecurityData getSecurityData() {
		return securityData;
	}
}
