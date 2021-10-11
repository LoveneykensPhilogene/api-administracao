package br.backend.api_selecao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api_selecao.dto.CargoDto;
import br.backend.api_selecao.dto.SetorDto;
import br.backend.api_selecao.entities.Cargo;
import br.backend.api_selecao.entities.Setor;
import br.backend.api_selecao.entities.Trabalhador;
import br.backend.api_selecao.mapperImpl.SetorMapperImpl;
import br.backend.api_selecao.repositories.CargoRepository;
import br.backend.api_selecao.repositories.SetorRepository;
import br.backend.api_selecao.repositories.TrabalhadorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository setorRepository;

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private TrabalhadorRepository trabalhadorRepository;

	@Autowired
	private SetorMapperImpl setorMapperImpl;

	public SetorDto criar(SetorDto setorDto) throws NullPointerException {
		if ((setorDto.getNome().trim().isEmpty())) {
			throw new NullPointerException("Nome do setor está vazia");
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

	public SetorDto editar(String nome, CargoDto cargoDto) throws Exception {

		Setor setor = setorRepository.findByNome(nome);

		Cargo c = new Cargo();
		CargoDto cDto = existeCargo(cargoDto.getNome());

		if (cDto != null) {

			throw new Exception("Cargo já existe");
		} else {

			c.setNome(cargoDto.getNome());
			c.setSetor(setor);

			Cargo cargo = cargoRepository.save(c);

			setor.getCargo().add(cargo);
			Setor setorSave = setorRepository.save(setor);

			return new SetorDto(setorSave);
		}

	}

	public SetorDto excluir(Long idSetor) {
		Setor setor = setorRepository.getById(idSetor);
		for (Cargo cargo : setor.getCargo()) {
			for (Trabalhador trabalhadorCargo : cargo.getCargoTrabalhador()) {
				trabalhadorRepository.delete(trabalhadorCargo);
			}
			cargoRepository.delete(cargo);

		}

		for (Trabalhador trabalhadorSetor : setor.getTrabalhador()) {
			trabalhadorRepository.delete(trabalhadorSetor);

		}

		setorRepository.delete(setor);
		return new SetorDto(setor);

	}

	public CargoDto existeCargo(String nome) {
		return cargoRepository.findByNome(nome);
	}

}
