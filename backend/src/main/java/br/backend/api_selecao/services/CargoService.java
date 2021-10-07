package br.backend.api_selecao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api_selecao.dto.CargoDto;
import br.backend.api_selecao.entities.Cargo;
import br.backend.api_selecao.entities.Setor;
import br.backend.api_selecao.mapperImpl.CargoMapperImpl;
import br.backend.api_selecao.mapperImpl.SetorMapperImpl;
import br.backend.api_selecao.repositories.CargoRepository;
import br.backend.api_selecao.repositories.SetorRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private CargoMapperImpl cargoMapperImpl;

	@Autowired
	private SetorRepository setorRepository;

	@Autowired
	private SetorMapperImpl setorMapperImpl;

	public CargoDto criar(CargoDto cargoDto, Long idSetor) {

		Cargo cargo = new Cargo();

		if (cargoDto.getNome() == " ") {
			return null;
		} else {
			Setor setor = setorRepository.findById(idSetor).get();
			cargoDto.setSetor(setorMapperImpl.modelDto(setor));
			cargo.setNome(cargoDto.getNome());
			cargo.setSetor(setor);
			Cargo cargoSave = cargoRepository.save(cargo);

			return cargoMapperImpl.modelDto(cargoSave);
		}
	}

	public List<CargoDto> findAll() {

		List<Cargo> cargos = cargoRepository.findAll();

		return cargos.stream().map(cargoMapperImpl::modelDto).collect(Collectors.toList());
	}

}
