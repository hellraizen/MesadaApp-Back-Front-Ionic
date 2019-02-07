package com.dleite.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dleite.domain.UserMaster;
import com.dleite.dto.UserMasterDTO;
import com.dleite.services.UserMasterService;


@RestController
@RequestMapping(value="/userMasters")
public class UserMasterResource {
	
	@Autowired
	private UserMasterService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserMaster> find(@PathVariable Integer id){
		
		UserMaster obj = service.findId(id);
		return ResponseEntity.ok().body(obj);
		  
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<UserMaster> insert(@Valid @RequestBody UserMasterDTO objDTO){
		UserMaster obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri(); 
		
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UserMasterDTO objDTO, @PathVariable Integer id){
		UserMaster obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserMasterDTO>> findAll(){
		 
		List<UserMaster> list = service.findAll();
		List<UserMasterDTO> listDto = list.stream()
				.map(obj -> new UserMasterDTO(obj))
				.collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<UserMasterDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="name") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction){
		 
		Page<UserMaster> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<UserMasterDTO> listDto = list.map(obj -> new UserMasterDTO(obj));
				
			return ResponseEntity.ok().body(listDto);
	}
	
	 

}
