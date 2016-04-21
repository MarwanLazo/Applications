package com.sprapp.audit.envers.listiner;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPreCollectionRemoveEventListenerImpl;
import org.hibernate.event.spi.PreCollectionRemoveEvent;

public class SprEnversPreCollectionRemoveEventListenerImpl extends EnversPreCollectionRemoveEventListenerImpl {

	private static final long serialVersionUID = 1L;

	public SprEnversPreCollectionRemoveEventListenerImpl(AuditConfiguration enversConfiguration) {
		super(enversConfiguration);
	}

	@Override
	public void onPreRemoveCollection(PreCollectionRemoveEvent event) {
		super.onPreRemoveCollection(event);
	}

}
