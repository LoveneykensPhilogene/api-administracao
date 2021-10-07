package br.backend.api_selecao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.backend.api_selecao.entities.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor,Long> {
	public Setor findByNome(String nome);

}
