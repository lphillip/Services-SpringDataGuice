package org.lxp.springdata.repository;

import org.lxp.springdata.domain.DCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<DCustomer, Long> {
	DCustomer findAccountById(Long id);
	
	@Query("select a from Customer a where a.name = :name")
    DCustomer findAccountByName(@Param("name") String name);
}
