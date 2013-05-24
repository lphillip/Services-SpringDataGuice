package org.lxp.springdata.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.lxp.springdata.domain.DCustomer;

import com.google.code.guice.repository.SimpleBatchStoreJpaRepository;

public class MyRepositoryImpl extends SimpleBatchStoreJpaRepository<DCustomer,Long> implements MyRepository {

	public MyRepositoryImpl(Class<DCustomer> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}

	public DCustomer retrieveCustomerNamed(String name) {	
		final String JQL="select c from Customer c";
		EntityManager em=getEntityManager();
		TypedQuery<DCustomer> query=em.createQuery(JQL, DCustomer.class);
		query.setMaxResults(1);
		
		List<DCustomer> results=query.getResultList();
		return results.size()>0?results.get(0):null;
	}
}
