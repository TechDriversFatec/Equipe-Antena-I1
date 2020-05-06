package com.fatec.antenas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fatec.antenas.model.DocumentProjeto;

public interface ProjetoRepository extends MongoRepository<DocumentProjeto, String>{

}
