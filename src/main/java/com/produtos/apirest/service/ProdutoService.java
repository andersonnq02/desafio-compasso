package com.produtos.apirest.service;

import java.util.List;

import com.produtos.apirest.models.Produto;

public interface ProdutoService {

	List<Produto> getAllProdutos();

	Produto saveProduto(Produto produto);

	Produto getProdutoById(long id);

	boolean deleteProdutoById(long id);

	Produto atualizarProdutoById(long id);

	List<Produto> searchProduto(String q, double min_price, double max_price);
}
