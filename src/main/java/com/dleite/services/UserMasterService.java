package com.dleite.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dleite.domain.UserMaster;
import com.dleite.repositories.UserMasterRepository;
import com.dleite.services.exception.ObjectNotFoundException;

@Service
public class UserMasterService {

	@Autowired
	private UserMasterRepository repository;
	
	public UserMaster findId(Integer id) {
		Optional<UserMaster> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + UserMaster.class.getName()));
	}
}
