package com.sprapp.audit.envers.listiner;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPostUpdateEventListenerImpl;
import org.hibernate.event.spi.PostUpdateEvent;

public class SprEnversPostUpdateEventListenerImpl extends EnversPostUpdateEventListenerImpl {

	private static final long serialVersionUID = 1L;

	public SprEnversPostUpdateEventListenerImpl(AuditConfiguration enversConfiguration) {
		super(enversConfiguration);
	}

	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		super.onPostUpdate(event);
	}

}
