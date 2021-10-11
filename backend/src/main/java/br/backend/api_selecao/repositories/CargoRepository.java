package br.backend.api_selecao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.backend.api_selecao.dto.CargoDto;
import br.backend.api_selecao.entities.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo,Long> {
	CargoDto findByNome(String nome);

}
