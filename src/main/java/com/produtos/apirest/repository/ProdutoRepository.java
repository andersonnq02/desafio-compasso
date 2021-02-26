package com.produtos.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.produtos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM "
			+ "    Produto p where price >= :min_price and price <= :max_price and name like '%:q%' and description like '%:q%'")
	List<Produto> seachProduct(@Param("q") String q, @Param("min_price") Double min_price,
			@Param("max_price") Double max_price);

}
