package br.edu.uni7.tecnicasvf.repository;

import br.edu.uni7.tecnicasvf.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Integer> {

    Produtos getProdutosByCodbarras(Long codbarras);
    List<Produtos> findAllByCategoria(String categoria);
}
