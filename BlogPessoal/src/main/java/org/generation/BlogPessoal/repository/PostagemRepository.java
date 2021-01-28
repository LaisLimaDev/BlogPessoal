package org.generation.BlogPessoal.repository;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface extends JpaRepository<Postagem Long> {
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);

}
