package org.generation.BlogPessoal.controller;

import org.generation.BlogPessoal.model.Postagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import generation.org.blogPessoal.repository.PostagemRepository;
@RestController /*informa ao spring que essa classe se trata de um controlador*/
@RequestMapping ("/postagens") /* informa por qual ri essa classe será acessada pelas postagens*/
@CrossOrigin("*")/* informa a origem, o sinal * informa que aceitará requisições de qualquer origem*/

public class PostagemController<repository> {

	@Autowired /* a responsabilidade de instanciação é dada toda ao Spring , autowired é a instanciação de injeção de dependencias*/
	private PostagemRepository repository;
	@GetMapping
	public ResponseEntity<List<Postagem> GetAll(){
		return ResponseEntity.ok(repository.findAll());
		/* no retorno do metodo receberemos um objeto passando a resposta http ok, então faremos a requisição de todas as postagens*/


		@GetMapping("{/id}")
		public ResponseEntity<Postagem> GetById(@PathVariable long id){
			return repository.findById(id)
					.map(resp -> REsponseEntity.ok(resp).orElse(ResponseEntity.notFound().build()));
		}

		@GetMapping("título/{título}")
		public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
			return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		}


		@PostMapping
		public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
		}


		{
			@PutMapping
			public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
				return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));

			}
			{
				@DeleteMapping ("/{id}")
			public void delete(@PathVariable long id){
				repository.deleteById(id);
			}
		}

