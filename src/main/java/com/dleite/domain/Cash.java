package com.dleite.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.dleite.domain.enumaration.StatusPay;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Cash extends Payment{
	
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date datePay;
	
	public Cash () {
	}
	

	public Cash(Integer id, StatusPay statusPay, RequestPay requestPay, Date dataPay) {
		super(id, statusPay, requestPay);
		this.datePay = dataPay;
	}


	public Date getDatePay() {
		return datePay;
	}


	public void setDatePay(Date datePay) {
		this.datePay = datePay;
	}



	
}
