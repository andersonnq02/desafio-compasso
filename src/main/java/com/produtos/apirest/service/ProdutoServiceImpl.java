package com.produtos.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto saveProduto(Produto produto) {

		return produtoRepository.save(produto);

	}

	@Override
	public Produto getProdutoById(long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		Produto produto = null;
		if (optional.isPresent()) {
			produto = optional.get();
		} else {
			throw new RuntimeException("Produto não encontrado para o id :: " + id);
		}
		return produto;
	}

	@Override
	public boolean deleteProdutoById(long id) {
		try {
			produtoRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Produto atualizarProdutoById(long id) {

		Optional<Produto> optional = produtoRepository.findById(id);
		Produto produto = null;
		if (optional.isPresent()) {
			produto = optional.get();
			produtoRepository.save(produto);
		}
		return produto;
	}

	@Override
	public List<Produto> searchProduto(String q, double min_price, double max_price) {
		return produtoRepository.seachProduct(q, min_price, max_price);
	}

}
