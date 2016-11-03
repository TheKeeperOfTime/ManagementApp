package org.elevenfifty.managementapp.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Products {
	
	@Size(max = 45)
	public String name;
	
	@Min(value = 0, message = "")
	public int price;
	
	
	public int ageRange;
	
	public String description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getAgeRange() {
		return ageRange;
	}
	public String getDescription() {
		return description;
	}
	public void setAgeRange(int ageRange) {
		this.ageRange = ageRange;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Products other = (Products) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	

}
