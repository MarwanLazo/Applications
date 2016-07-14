package com.sprapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import com.sprapp.dto.TempTableDTO;
import com.sprapp.general.Status;

@Entity
@Table(name = "temp_table")
@Indexed
@Audited
// @Cacheable
// @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class TempTableEB extends AbstractEntity<String> {
	private static final long	serialVersionUID	= 1L;
	private static final String	SATUS_USER_TYPE		= "com.sprapp.hibernateconverter.SatusUserType";

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

	@Column(name = "active")
	@Type(type = SATUS_USER_TYPE)
	private Status				status;

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

	@Override
	public String getPK() {
		return getTempName();
	}

	@Override
	public String getPKAsString() {
		return getTempName().toString();
	}

	@Override
	public Class<TempTableDTO> getDTOClass() {
		return TempTableDTO.class;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
