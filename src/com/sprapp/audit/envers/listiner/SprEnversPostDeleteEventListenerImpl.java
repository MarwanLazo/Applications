package com.sprapp.audit.envers.listiner;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPostDeleteEventListenerImpl;
import org.hibernate.event.spi.PostDeleteEvent;

public class SprEnversPostDeleteEventListenerImpl extends EnversPostDeleteEventListenerImpl {
	private static final long serialVersionUID = 1L;

	public SprEnversPostDeleteEventListenerImpl(AuditConfiguration enversConfiguration) {
		super(enversConfiguration);
	}

	@Override
	public void onPostDelete(PostDeleteEvent event) {
		super.onPostDelete(event);
	}

}
