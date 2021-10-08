package br.backend.api_selecao.services;

import java.util.EmptyStackException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api_selecao.dto.SetorDto;
import br.backend.api_selecao.entities.Cargo;
import br.backend.api_selecao.entities.Setor;
import br.backend.api_selecao.mapperImpl.SetorMapperImpl;
import br.backend.api_selecao.repositories.CargoRepository;
import br.backend.api_selecao.repositories.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository setorRepository;

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private SetorMapperImpl setorMapperImpl;

	public SetorDto criar(SetorDto setorDto) {
		if ((setorDto.getNome().isEmpty())) {
			throw new EmptyStackException();
		} else {
			Setor setor = new Setor();
			setor.setNome(setorDto.getNome());
			Setor salvarSetor = setorRepository.save(setor);
			return setorMapperImpl.modelDto(salvarSetor);
		}

	}

	public List<SetorDto> findAll() {

		List<Setor> setores = setorRepository.findAll();

		return setores.stream().map(SetorDto::new).collect(Collectors.toList());

	}

	public SetorDto editar(String nome, Long idCargo) {

		Cargo cargo = cargoRepository.getById(idCargo);
		Setor setor = setorRepository.findByNome(nome);
		cargo.setSetor(setor);
		setor.getCargo().add(cargo);
		cargoRepository.save(cargo);
		setorRepository.save(setor);

		return new SetorDto(setor);

	}

	public SetorDto excluir(Long idSetor) {
		Setor setor = setorRepository.getById(idSetor);
		setorRepository.delete(setor);
		return setorMapperImpl.modelDto(setor);
	}

}
