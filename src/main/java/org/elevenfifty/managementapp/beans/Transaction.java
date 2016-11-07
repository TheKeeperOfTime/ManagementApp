package org.elevenfifty.managementapp.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Size(max = 16)
	private String transactionDate;

	@OneToOne(optional = false)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToOne(optional = false)
	@JoinColumn(name = "product_id")
	private Products product;

	public String getTransactionDate() {
		return transactionDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Products getProduct() {
		return product;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Transaction other = (Transaction) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
}
