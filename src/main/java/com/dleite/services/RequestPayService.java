package com.dleite.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dleite.domain.RequestPay;
import com.dleite.repositories.RequestPayRepository;
import com.dleite.services.exception.ObjectNotFoundException;

@Service
public class RequestPayService {

	@Autowired
	private RequestPayRepository repository;
	
	public RequestPay findId(Integer id) {
		Optional<RequestPay> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + RequestPay.class.getName()));
	}
}
