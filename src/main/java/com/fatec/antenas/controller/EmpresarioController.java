package com.fatec.antenas.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.antenas.error.ResourceAlreadyExistsException;
import com.fatec.antenas.error.ResourceNotFoundException;
import com.fatec.antenas.model.DocumentEmpresario;
import com.fatec.antenas.repository.EmpresarioRepository;

@RestController
@RequestMapping("/empresario")
public class EmpresarioController {
	
	@Autowired
    private EmpresarioRepository empresarioDAO;
	
	@PostMapping(path = "/save")
	public ResponseEntity<?> save(@Valid @RequestBody DocumentEmpresario empresario){
		verifyIfEmpresarioExistsEmail(empresario.getEmail());
		return new ResponseEntity<>(empresarioDAO.save(empresario), HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<?> update(@Valid @RequestBody DocumentEmpresario empresario){
		return new ResponseEntity<>(empresarioDAO.save(empresario), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> listAll(Pageable pageable){
		return new ResponseEntity<>(empresarioDAO.findAll(pageable), HttpStatus.OK);
	}
	
	@DeleteMapping(path="delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		verifyIfEmpresarioExistsID(id);
		empresarioDAO.deleteById(id.toString());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path = "byEmail/{email}")
	public ResponseEntity<?> getEmpresarioByEmail(@PathVariable String email){
		return new ResponseEntity<>(empresarioDAO.findByEmail(email), HttpStatus.OK);
	}
	
	private void verifyIfEmpresarioExistsID(String id) {
		if(!empresarioDAO.findById(id).isPresent() ) {
			throw new ResourceNotFoundException("Businessman not found dor ID: "+ id);
		}
	}
	
	private void verifyIfEmpresarioExistsEmail(String email) {
		if(empresarioDAO.findByEmail(email) != null) {
			throw new ResourceAlreadyExistsException("Businessman already exists : "+ email);
		}
	}
}
