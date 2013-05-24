package org.lxp.springdata.injection.module;

import org.lxp.springdata.repository.CustomerRepository;
import org.lxp.springdata.repository.FeatureRepository;
import org.lxp.springdata.repository.MyRepository;
import org.lxp.springdata.repository.MyRepositoryImpl;

import com.google.code.guice.repository.configuration.JpaRepositoryModule;
import com.google.code.guice.repository.configuration.RepositoryBinder;
import com.google.inject.AbstractModule;

public class DBModule extends AbstractModule {
	public final static String MEMORY_STORE="MemoryStore";
	
	@Override
	protected void configure() {
		install(new JpaRepositoryModule(MEMORY_STORE) {
            @Override
            protected void bindRepositories(RepositoryBinder binder) {
            	binder.bind(FeatureRepository.class).to(MEMORY_STORE);
                binder.bind(CustomerRepository.class).to(MEMORY_STORE);
                binder.bind(MyRepository.class).withCustomImplementation(MyRepositoryImpl.class).to(MEMORY_STORE);
            }
        });
	}
}
