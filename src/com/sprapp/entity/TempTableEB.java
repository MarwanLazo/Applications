package com.sprapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "temp_table")
@Indexed
@Audited
//@Cacheable 
//@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class TempTableEB implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Id
	@Column(name = "TEMP_NAME")
	@Field(analyze = Analyze.YES, index = Index.YES, store = Store.NO)
	private String				tempName;
	@Field(analyze = Analyze.YES, index = Index.YES, store = Store.NO)
	@Column(name = "TEMP_EMAIL")
	private String				tempEmail;
	@Field(analyze = Analyze.YES, index = Index.YES, store = Store.NO)
	@Column(name = "TEMP_REF")
	private String				tempRef;
	@Transient
	private String				tempNameUnsaved		= "Marwan";

	public TempTableEB() {
		super();
	}

	public TempTableEB(String tempName, String tempEmail) {
		this.tempName = tempName;
		this.tempEmail = tempEmail;
	}

	public String getTempName() {
		return this.tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public String getTempEmail() {
		return this.tempEmail;
	}

	public void setTempEmail(String tempEmail) {
		this.tempEmail = tempEmail;
	}

	@Override
	public String toString() {
		return "[" + tempName + ":" + tempEmail + "]";
	}

	public String getTempRef() {
		return tempRef;
	}

	public void setTempRef(String tempRef) {
		this.tempRef = tempRef;
	}

	public String getTempNameUnsaved() {
		return tempNameUnsaved;
	}

	public void setTempNameUnsaved(String tempNameUnsaved) {
		this.tempNameUnsaved = tempNameUnsaved;
	}

}
