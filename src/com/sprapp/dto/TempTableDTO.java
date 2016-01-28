package com.sprapp.dto;

import java.io.Serializable;

public class TempTableDTO implements Serializable {

	private static final long	serialVersionUID	= 1L;
	private String				tempName;
	private String				tempEmail;
	private TempTableDTO		tempRef;
	private String				tempNameUnsaved;

	public TempTableDTO() {
	}

	public TempTableDTO(String tempName, String tempEmail) {
		super();
		this.tempName = tempName;
		this.tempEmail = tempEmail;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public String getTempEmail() {
		return tempEmail;
	}

	public void setTempEmail(String tempEmail) {
		this.tempEmail = tempEmail;
	}

	public TempTableDTO getTempRef() {
		return tempRef;
	}

	public void setTempRef(TempTableDTO tempRef) {
		this.tempRef = tempRef;
	}

	@Override
	public String toString() {
		return "[" + tempName + ":" + tempEmail + "]";
	}

	public String getTempNameUnsaved() {
		return tempNameUnsaved;
	}

	public void setTempNameUnsaved(String tempNameUnsaved) {
		this.tempNameUnsaved = tempNameUnsaved;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof TempTableDTO) {
			TempTableDTO temp = (TempTableDTO) obj;
			if (temp.tempName != null && temp.tempEmail != null && temp.tempEmail.equals(this.tempEmail) && temp.tempName.equals(this.tempName))
				return true;
		}
		return false;
	}

}
