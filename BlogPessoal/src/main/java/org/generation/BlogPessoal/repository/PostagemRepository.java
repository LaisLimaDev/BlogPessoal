package org.generation.BlogPessoal.repository;

import java.util.List;

import org.generation.BlogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository  extends JpaRepository<Postagem, Long >{
	
	public List<Postagem> findAllByNomeContainingIgnoreCase(String nome); 

}
