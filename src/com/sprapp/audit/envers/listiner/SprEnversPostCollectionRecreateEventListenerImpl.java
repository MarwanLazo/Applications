package com.sprapp.audit.envers.listiner;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPostCollectionRecreateEventListenerImpl;
import org.hibernate.event.spi.PostCollectionRecreateEvent;

public class SprEnversPostCollectionRecreateEventListenerImpl extends EnversPostCollectionRecreateEventListenerImpl {

	private static final long serialVersionUID = 1L;

	public SprEnversPostCollectionRecreateEventListenerImpl(AuditConfiguration enversConfiguration) {
		super(enversConfiguration);
	}

	@Override
	public void onPostRecreateCollection(PostCollectionRecreateEvent event) {
		super.onPostRecreateCollection(event);
	}

}
