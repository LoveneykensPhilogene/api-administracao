package br.backend.api_selecao.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api_selecao.dto.CargoDto;
import br.backend.api_selecao.entities.Cargo;
import br.backend.api_selecao.entities.Setor;
import br.backend.api_selecao.repositories.CargoRepository;
import br.backend.api_selecao.repositories.SetorRepository;
import javassist.NotFoundException;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private SetorRepository setorRepository;

	public CargoDto criar(CargoDto cargoDto, Long idSetor) throws NotFoundException {

		Cargo cargo = new Cargo();

		if (cargoDto.getNome().isEmpty()) {
			return null;
		} else {

			Optional<Setor> setorOptional = setorRepository.findById(idSetor);
			if (setorOptional.isPresent()) {
				cargo.setNome(cargoDto.getNome());
				cargo.setSetor(setorOptional.get());

				Cargo cargoSave = cargoRepository.save(cargo);

				return new CargoDto(cargoSave);

			} else {

				throw new NotFoundException("Não existe um setor cadastrado");

			}

		}
	}

	public List<CargoDto> findAll() {

		List<Cargo> cargos = cargoRepository.findAll();

		return cargos.stream().map(CargoDto::new).collect(Collectors.toList());
	}

}
