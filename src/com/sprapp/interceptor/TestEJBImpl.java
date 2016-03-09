package com.sprapp.interceptor;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.sprapp.entity.TempTableEB;

@Logging
@Stateless(mappedName = "java/testEJB")
public class TestEJBImpl implements TestEJB {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<TempTableEB> getName(String name, EntityManager em) throws InterruptedException {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
		fullTextEntityManager.createIndexer().startAndWait();
		QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(TempTableEB.class).get();
		org.apache.lucene.search.Query query = qb.keyword().onFields("tempName").matching(name).createQuery();
		javax.persistence.Query persistenceQuery = fullTextEntityManager.createFullTextQuery(query, TempTableEB.class);
		return persistenceQuery.getResultList();
	}

	@Override
	public void consumeJMS(String message) {
		System.out.println(message);
	}

}
