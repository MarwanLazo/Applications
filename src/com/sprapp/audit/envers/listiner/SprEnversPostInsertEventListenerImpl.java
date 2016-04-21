package com.sprapp.audit.envers.listiner;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPostInsertEventListenerImpl;
import org.hibernate.event.spi.PostInsertEvent;

public class SprEnversPostInsertEventListenerImpl extends EnversPostInsertEventListenerImpl {

	private static final long serialVersionUID = 1L;

	public SprEnversPostInsertEventListenerImpl(AuditConfiguration enversConfiguration) {
		super(enversConfiguration);
	}

	@Override
	public void onPostInsert(PostInsertEvent event) {
		super.onPostInsert(event);
	}

}
