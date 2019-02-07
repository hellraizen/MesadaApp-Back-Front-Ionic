package com.dleite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dleite.domain.UserMaster;
import com.dleite.repositories.UserMasterRepository;
import com.dleite.services.exception.DataIntegrityException;
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
	
	public UserMaster insert(UserMaster obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public UserMaster update(UserMaster obj) {
		findId(obj.getId());
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		findId(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir um usuario que tem filhos cadastrados.");
		}
		
	}
	
	public List<UserMaster> findAll(){
		return repository.findAll();
	}
	
	
}
