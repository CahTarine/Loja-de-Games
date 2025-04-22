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

import com.lojagames.lojagames.model.Categorias;
import com.lojagames.lojagames.repository.CategoriasRepository;

import jakarta.validation.Valid;

@RestController //pesquisar
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*") //pesquisar
public class CategoriasController {
	
	@Autowired //pesquisar
	private CategoriasRepository categoriasRepository;
	
	@PostMapping
	public ResponseEntity<Categorias> post(@Valid @RequestBody Categorias categoria){ //pesquisae
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriasRepository.save(categoria));
	}
	
	@GetMapping
	public ResponseEntity<List<Categorias>> getAll() {
		return ResponseEntity.ok(categoriasRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> getById(@PathVariable Long id) {
		return categoriasRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta)) //pesquisar
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categorias>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(categoriasRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categorias> put(@Valid @RequestBody Categorias categoria) {
		return categoriasRepository.findById(categoria.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
				.body(categoriasRepository.save(categoria)))
				.orElse(ResponseEntity.status (HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        Optional<Categorias> postagem = categoriasRepository.findById(id);
        if(postagem.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        categoriasRepository.deleteById(id);
	}
}
