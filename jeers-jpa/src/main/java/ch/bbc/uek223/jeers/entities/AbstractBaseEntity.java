package ch.bbc.uek223.jeers.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

//	@Version
//	@Column(name = "VERSION")
//	private int version;

	@Column(name="MUTIERT_AM")
	private Timestamp mutiertAm;

	@Column(name="ERSTELLT_AM")
	private Timestamp erstelltAm;

//	public int getVersion() {
//		return version;
//	}
//
//	public void setVersion(int version) {
//		this.version = version;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Timestamp getMutiertAm() {
		return mutiertAm;
	}

	public void setMutiertAm(Timestamp mutiertAm) {
		this.mutiertAm = mutiertAm;
	}

	public Timestamp getErstelltAm() {
		return erstelltAm;
	}

	public void setErstelltAm(Timestamp erstelltAm) {
		this.erstelltAm = erstelltAm;
	}

	@PrePersist
	public void prePersist() {
		this.erstelltAm = new Timestamp(System.currentTimeMillis());
	}

	@PreUpdate
	public void preUpdate() {
		this.mutiertAm = new Timestamp(System.currentTimeMillis());
	}

}
