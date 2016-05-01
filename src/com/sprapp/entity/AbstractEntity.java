package com.sprapp.entity;

import java.io.Serializable;

import com.sprapp.dto.AbstractDTO;

public abstract class AbstractEntity<PK extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public abstract PK getPK ();
	
	public abstract String getPKAsString ();
	
	public abstract Class<? extends AbstractDTO<PK>> getDTOClass ();

}
