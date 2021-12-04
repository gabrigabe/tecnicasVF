package br.edu.uni7.tecnicasvf.service;

import br.edu.uni7.tecnicasvf.model.Produtos;
import br.edu.uni7.tecnicasvf.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProdutosService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutosService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produtos> list() {
        return produtoRepository.findAll();
    }

    public List<Produtos> findAllByCategoria(String categoria) {
        List<Produtos> listacategorias = produtoRepository.findAllByCategoria(categoria);
            if(listacategorias.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria inexistente");
            }
            return listacategorias;

    }
    public List<Produtos> findAllByQuantidadeIs(Integer quantidade){
        return produtoRepository.findAllByQuantidadeIs(0);
    }

    public Produtos findById(Integer id) {
        try{
            return produtoRepository.findById(id).get();
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id inexistente");
        }
    }

    public Produtos getProdutosByCodbarras(Long codbarras){
            Produtos codbarra = produtoRepository.getProdutosByCodbarras(codbarras);
            if(codbarra == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Codigo de barras inexistente");
            }
            return codbarra;
    }

    public Produtos create(Produtos produtos) {
        produtos.setCodbarras((long) (100000000000L + Math.random() * 899999999999L));
        produtoRepository.save(produtos);
        return produtos;
    }
    public Produtos update(Produtos produtos) {
            Optional<Produtos> idproduto = produtoRepository.findById(produtos.getId());
            if(idproduto.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id inexistente");
            }
            produtoRepository.save(produtos);
            return produtos;
    }

    public void remove(Integer id){
        try{
            produtoRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id inexistente");
        }
    }
}