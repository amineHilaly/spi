package main.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "V_PROCESSUS_STAGE")
public class ProcessusStage implements Serializable{

	@Id
	@Column(name="CODE")
	private String code;
	
	@Column(name="SIGNIFICATION")
	private String sinification;

	public ProcessusStage(String code, String sinification) {
		super();
		this.code = code;
		this.sinification = sinification;
	}

	public ProcessusStage() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSinification() {
		return sinification;
	}

	public void setSinification(String sinification) {
		this.sinification = sinification;
	}

	@Override
	public String toString() {
		return "LieuRentree [code=" + code + ", sinification=" + sinification + "]";
	}
	
	
	
}
