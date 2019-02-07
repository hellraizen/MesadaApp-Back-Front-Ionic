package com.dleite.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RequestPay implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date requestDate;
	
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="requestPay")
	private Payment payment;
	
	
	@ManyToOne
	@JoinColumn(name="kid_id")
	private Kid kid;
	
	@OneToMany(mappedBy="id.requestePay")
	private Set<OrderItem> itens = new HashSet<>();
	
	public RequestPay() {
	}


	public RequestPay(Integer id, Date requestDate, Kid kid) {
		super();
		this.id = id;
		this.requestDate = requestDate;
		this.kid = kid;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getRequestDate() {
		return requestDate;
	}


	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Kid getKid() {
		return kid;
	}


	public void setKid(Kid kid) {
		this.kid = kid;
	}
	
	public Set<OrderItem> getItens() {
		return itens;
	}


	public void setItens(Set<OrderItem> itens) {
		this.itens = itens;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		RequestPay other = (RequestPay) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}







	

	
}
