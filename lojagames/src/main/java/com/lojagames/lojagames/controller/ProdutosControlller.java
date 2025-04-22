package com.lojagames.lojagames.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lojagames.lojagames.model.Produtos;
import com.lojagames.lojagames.repository.CategoriasRepository;
import com.lojagames.lojagames.repository.ProdutosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosControlller {
	
	@Autowired //pesquisar
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> getAll() {
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> getById(@PathVariable Long id) {
		Optional<Produtos> produto = produtosRepository.findById(id);
		return produto.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produtos>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtosRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Produtos> post(@Valid @RequestBody Produtos produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produtos> put(@PathVariable Long id, @Valid @RequestBody Produtos produto) {
	    if (produtosRepository.existsById(produto.getId())) {

	        if (categoriasRepository.existsById(produto.getCategoria().getId())) {
	            return ResponseEntity.status(HttpStatus.OK)
	                                 .body(produtosRepository.save(produto));
	        }

	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não existe!", null);
	    }

	    return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
	    }
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		Optional<Produtos> produto = produtosRepository.findById(id);
		
		if (produto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		produtosRepository.deleteById(id);
	}
	
}
