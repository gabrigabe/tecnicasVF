package br.edu.uni7.tecnicasvf.controller;

import br.edu.uni7.tecnicasvf.model.Produtos;
import br.edu.uni7.tecnicasvf.service.ProdutosService;
import com.sun.istack.NotNull;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProdutosController {
    private final ProdutosService service;

    @Autowired
    public ProdutosController(ProdutosService service){
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "produtos", method = RequestMethod.POST)
    public Produtos create(@RequestBody Produtos produtos){
        return  service.create(produtos);
    }


    @ResponseBody
    @RequestMapping(value = "produtos", method = RequestMethod.GET)
    public List<Produtos> list(){
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "produtos/{id}", method = RequestMethod.GET)
    public Produtos FindById(@PathVariable Integer id){
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "produtos/categoria/{categoria}", method = RequestMethod.GET)
    public List<Produtos> findBycodbarras(@PathVariable String categoria){
        return service.findAllByCategoria(categoria);
    }

    @ResponseBody
    @RequestMapping(value = "produtos/codbarras/{codbarras}", method = RequestMethod.GET)
    public Produtos findBycodbarras(@PathVariable Long codbarras){
        return service.getProdutosByCodbarras(codbarras);
    }

    @ResponseBody
    @RequestMapping(value = "produtos/{id}", method = RequestMethod.PUT)
    public Produtos update(@PathVariable Integer id, @RequestBody Produtos produtos) {
            produtos.setId(id);
            return service.update(produtos);

    }

    @ResponseBody
    @RequestMapping("produtos/{id}")
    public void remove(@PathVariable Integer id) {
        service.remove(id);
    }


}
