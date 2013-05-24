package org.lxp.springdata;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lxp.springdata.domain.DCustomer;
import org.lxp.springdata.domain.DFeature;
import org.lxp.springdata.injection.module.DBModule;
import org.lxp.springdata.repository.CustomerRepository;
import org.lxp.springdata.repository.FeatureRepository;
import org.lxp.springdata.repository.MyRepository;
import org.springframework.transaction.annotation.Transactional;

import com.google.inject.Stage;
import com.proquest.services.testutility.injection.runner.GuiceRunner;
import com.proquest.services.testutility.injection.runner.GuiceRunner.GuiceModules;
import com.proquest.services.testutility.injection.runner.GuiceRunner.GuiceStage;

@RunWith(GuiceRunner.class)
@GuiceStage(Stage.DEVELOPMENT)
@GuiceModules({DBModule.class})
public class DataTest {
	@Inject FeatureRepository featureRepo;
	@Inject CustomerRepository repo;
	@Inject MyRepository myRepo;
	
	@Test
	public void rollback() {
		Exception caught=null;
		
		try {
			createCustomer(false);
		} catch(Exception e) {
			caught=e;
		}
		
		Assert.assertNotNull(caught);
		
		DCustomer found=repo.findAccountById(1L);
		Assert.assertNull(found);
	}
	
	@Test
	public void commit() throws Exception {
		try {
			createCustomer(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(1, repo.count());
	
		DCustomer found=repo.findAccountById(1L);
		Assert.assertNotNull(found);
		
		DCustomer named=repo.findAccountByName("Ted");
		Assert.assertNotNull(named);

		try {
			DCustomer nm=myRepo.retrieveCustomerNamed("Ted");
			Assert.assertNotNull(nm);
			
			List<DFeature> features=nm.getFeatures();
			Assert.assertEquals(1, features.size());
		} catch(NoResultException e) {
			System.out.println("No Result Found");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void createCustomer(boolean commit) throws Exception {
		DCustomer customer=new DCustomer();
		customer.setId(1L);
		customer.setName("Ted");
		
		DFeature feature=new DFeature("key","value");
		customer.addFeature(feature);
		
		repo.save(customer);
		
		if(!commit)
			throw new Exception("Rollback!");
	}
}
