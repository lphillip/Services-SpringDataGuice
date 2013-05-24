package org.lxp.springdata.repository;

import org.lxp.springdata.domain.DCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<DCustomer,Long> {
	DCustomer retrieveCustomerNamed(String name);
}
