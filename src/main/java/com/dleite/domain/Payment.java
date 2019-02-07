package com.dleite.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.dleite.domain.enumaration.StatusPay;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer statusPay;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "requestPay_id")
	@MapsId
	private RequestPay requestPay;

	public Payment() {
	}

	public Payment(Integer id, StatusPay statusPay, RequestPay requestPay) {
		super();
		this.id = id;
		this.statusPay = statusPay.getCod();
		this.requestPay = requestPay;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusPay getStatusPay() {
		return StatusPay.toEnum(statusPay);
	}

	public void setStatusPay(StatusPay statusPay) {
		this.statusPay = statusPay.getCod();
	}

	public RequestPay getRequestPay() {
		return requestPay;
	}

	public void setRequestPay(RequestPay requestPay) {
		this.requestPay = requestPay;
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
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
