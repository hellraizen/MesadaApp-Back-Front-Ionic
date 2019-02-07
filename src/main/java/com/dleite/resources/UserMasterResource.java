package com.dleite.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dleite.domain.UserMaster;
import com.dleite.services.UserMasterService;


@RestController
@RequestMapping(value="/userMasters")
public class UserMasterResource {
	
	@Autowired
	private UserMasterService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		UserMaster obj = service.findId(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
