package com.produtos.apirest.resources;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.service.ProdutoService;

@RestController
@RequestMapping(value = "/")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/products")
	public List<Produto> listarProdutos() {
		return produtoService.getAllProdutos();
	}

	@GetMapping("products/{id}")
	public ResponseEntity buscarProdutoId(@PathVariable("id") long id) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			return new ResponseEntity(produtoService.getProdutoById(id), HttpStatus.OK);
		} catch (RuntimeException e) {
			map.put("status_code", HttpStatus.NOT_FOUND.value());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		}
	}

	@PostMapping("/products")
	public ResponseEntity salvarProduto(@RequestBody Produto produto) {
		HashMap<String, Object> map = new HashMap<>();
		try {
			return new ResponseEntity(produtoService.saveProduto(produto), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			map.put("status_code", HttpStatus.BAD_REQUEST);
			map.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		}

	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity deletaProduto(@PathVariable("id") long id) {
		HashMap<String, Object> map = new HashMap<>();
		if (produtoService.deleteProdutoById(id)) {
			map.put("status_code", HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}
		map.put("status_code", HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity atualizarProduto(@PathVariable("id") long id) {
		HashMap<String, Object> map = new HashMap<>();
		Produto produto = produtoService.atualizarProdutoById(id);
		if (produto != null) {
			return new ResponseEntity(produto, HttpStatus.OK);
		} else {
			map.put("status_code", HttpStatus.NOT_FOUND.value());
			map.put("message", "Registro não encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		}
	}

	@GetMapping("products/search")
	public List<Produto> seachProduto(@RequestParam("q") String q, @RequestParam("min_price") double min_price,
			@RequestParam("max_price") double max_price) {
		return (List<Produto>) new ResponseEntity(produtoService.searchProduto(q, min_price, max_price), HttpStatus.OK);
	}

}
