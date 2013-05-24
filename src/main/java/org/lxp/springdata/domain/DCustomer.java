package org.lxp.springdata.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity(name = "Customer")
@Table(name = "CUSTOMER")
public class DCustomer {
	
	@Id
	@Column(unique = true, nullable = false, name = "CUST_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_ID_SQ")
	@SequenceGenerator(name = "CUST_ID_SQ", sequenceName = "CUST_ID_SQ", allocationSize = 1)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<DFeature> features=new ArrayList<DFeature>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<DFeature> getFeatures() {
		return features;
	}

	public void setFeatures(List<DFeature> features) {
		this.features = features;
	}
	
	public void addFeature(DFeature feature) {
		feature.setCustomer(this);
		features.add(feature);
	}
	
	public void removeFeature(DFeature feature) {
		feature.setCustomer(null);
		features.remove(feature);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DCustomer other = (DCustomer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DCustomer [id=" + id + ", name=" + name + "]";
	}
	
	
}
