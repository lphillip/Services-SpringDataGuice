package org.lxp.springdata.repository;

import org.lxp.springdata.domain.DFeature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<DFeature, Long> {
	DFeature findFeatureById(Long id);
}
