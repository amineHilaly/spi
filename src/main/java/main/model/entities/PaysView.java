package main.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name ="v_pays")
@Immutable
public class PaysView {
	
	@Id
	@Column(name ="code")
	private String code;
	
	@Column(name ="abreviation")
	private String abreviation;
	
	@Column(name ="signification")
	private String signification;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	public String getSignification() {
		return signification;
	}

	public void setSignification(String signification) {
		this.signification = signification;
	}

	public PaysView() {
		super();
	}
	
	

}
