package com.sprapp.audit.envers.listiner;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPreCollectionUpdateEventListenerImpl;
import org.hibernate.event.spi.PreCollectionUpdateEvent;

public class SprEnversPreCollectionUpdateEventListenerImpl extends EnversPreCollectionUpdateEventListenerImpl {

	private static final long serialVersionUID = 1L;

	public SprEnversPreCollectionUpdateEventListenerImpl(AuditConfiguration enversConfiguration) {
		super(enversConfiguration);
	}

	@Override
	public void onPreUpdateCollection(PreCollectionUpdateEvent event) {
		super.onPreUpdateCollection(event);
	}

}
