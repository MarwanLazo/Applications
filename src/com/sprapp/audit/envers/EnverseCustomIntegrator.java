package com.sprapp.audit.envers;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversIntegrator;
import org.hibernate.envers.event.spi.EnversListenerDuplicationStrategy;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import com.sprapp.audit.envers.listiner.SprEnversPostCollectionRecreateEventListenerImpl;
import com.sprapp.audit.envers.listiner.SprEnversPostDeleteEventListenerImpl;
import com.sprapp.audit.envers.listiner.SprEnversPostInsertEventListenerImpl;
import com.sprapp.audit.envers.listiner.SprEnversPostUpdateEventListenerImpl;
import com.sprapp.audit.envers.listiner.SprEnversPreCollectionRemoveEventListenerImpl;
import com.sprapp.audit.envers.listiner.SprEnversPreCollectionUpdateEventListenerImpl;

public class EnverseCustomIntegrator extends EnversIntegrator {

	public static final String	AUTO_REGISTER	= "hibernate.listeners.envers.autoRegister";
	private AuditConfiguration	enversConfiguration;

	@Override
	public void integrate(org.hibernate.cfg.Configuration configuration, SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {

		

		final EventListenerRegistry listenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);
		listenerRegistry.addDuplicationStrategy(EnversListenerDuplicationStrategy.INSTANCE);

		enversConfiguration = AuditConfiguration.getFor(configuration, serviceRegistry.getService(ClassLoaderService.class));

		if (enversConfiguration.getEntCfg().hasAuditedEntities()) {
			listenerRegistry.appendListeners(EventType.POST_DELETE, new SprEnversPostDeleteEventListenerImpl(enversConfiguration));
			listenerRegistry.appendListeners(EventType.POST_INSERT, new SprEnversPostInsertEventListenerImpl(enversConfiguration));
			listenerRegistry.appendListeners(EventType.POST_UPDATE, new SprEnversPostUpdateEventListenerImpl(enversConfiguration));
			listenerRegistry.appendListeners(EventType.POST_COLLECTION_RECREATE, new SprEnversPostCollectionRecreateEventListenerImpl(enversConfiguration));
			listenerRegistry.appendListeners(EventType.PRE_COLLECTION_REMOVE, new SprEnversPreCollectionRemoveEventListenerImpl(enversConfiguration));
			listenerRegistry.appendListeners(EventType.PRE_COLLECTION_UPDATE, new SprEnversPreCollectionUpdateEventListenerImpl(enversConfiguration));
		}

	}

}