package org.lxp.springdata.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Feature")
@Table(name = "FEATURE")
public class DFeature {
	
	@Id
	@Column(unique = true, nullable = false, name = "FEATURE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FEATURE_ID_SQ")
	@SequenceGenerator(name = "FEATURE_ID_SQ", sequenceName = "FEATURE_ID_SQ", allocationSize = 1)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="value")
	private String value;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable = false, name = "CUST_ID")
	private DCustomer customer;
	
	public DFeature() {
	}
	
	public DFeature(String name, String value) {
		this.name=name;
		this.value=value;
	}

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public DCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(DCustomer customer) {
		this.customer = customer;
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
		DFeature other = (DFeature) obj;
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
		return "DFeature [id=" + id + ", name=" + name + ", value=" + value + "]";
	}

}
