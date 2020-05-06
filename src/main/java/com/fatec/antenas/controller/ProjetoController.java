package com.fatec.antenas.controller;

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

import com.fatec.antenas.error.ResourceNotFoundException;
import com.fatec.antenas.model.DocumentProjeto;
import com.fatec.antenas.model.Reuniao;
import com.fatec.antenas.repository.ProjetoRepository;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository projetoDAO;
	
	@PostMapping(path = "/save")
	public ResponseEntity<?> save(@RequestBody DocumentProjeto projeto){
		return new ResponseEntity<>(projetoDAO.save(projeto), HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<?> update(@RequestBody DocumentProjeto projeto){
		return new ResponseEntity<>(projetoDAO.save(projeto), HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/save/reuniao/{id}")
	public ResponseEntity<?> insertReuniao(@RequestBody Reuniao reuniao, @PathVariable String id){
		DocumentProjeto find = projetoDAO.findById(id).get();
		find.setReuniao(reuniao);
		return new ResponseEntity<>(projetoDAO.save(find), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> listAll(Pageable pageable){
		return new ResponseEntity<>(projetoDAO.findAll(pageable), HttpStatus.OK);
	}
	
	@DeleteMapping(path="delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		verifyIfProjetcExistsID(id);
		projetoDAO.deleteById(id.toString());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path = "byID/{id}")
	public ResponseEntity<?> getProjectByID(@PathVariable String id){
		return new ResponseEntity<>(projetoDAO.findById(id), HttpStatus.OK);
	}
	
	
	private void verifyIfProjetcExistsID(String id) {
		if(!projetoDAO.findById(id).isPresent() ) {
			throw new ResourceNotFoundException("Project not found dor ID: "+ id);
		}
	}
	
}
