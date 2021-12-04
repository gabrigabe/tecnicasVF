package br.edu.uni7.tecnicasvf.repository;

import br.edu.uni7.tecnicasvf.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
}
