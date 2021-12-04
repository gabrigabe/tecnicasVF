package br.edu.uni7.tecnicasvf.service;


import br.edu.uni7.tecnicasvf.model.Clientes;
import br.edu.uni7.tecnicasvf.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClientesService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Clientes> list(){
        return clienteRepository.findAll();
    }
}
