package br.backend.api_selecao.mapperImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api_selecao.dto.CargoDto;
import br.backend.api_selecao.dto.TrabalhadorDto;
import br.backend.api_selecao.entities.Cargo;
import br.backend.api_selecao.entities.Trabalhador;
import br.backend.api_selecao.mapper.CargoMapper;

@Service
public class CargoMapperImpl implements CargoMapper {

	@Autowired
	private TrabalhadorMapperImpl trabalhadorMapperImpl;

	@Autowired
	private SetorMapperImpl setorMapperImpl;

	@Override
	public Cargo model(CargoDto cargoDto) {

		Cargo cargo = new Cargo();
		if (cargoDto.getCargoTrabalhadorDto() == null) {
			cargo.setNome(cargo.getNome());
			cargo.setSetor(setorMapperImpl.model(cargoDto.getSetor()));
		} else {
			cargo.setNome(cargo.getNome());
			cargo.setSetor(setorMapperImpl.model(cargoDto.getSetor()));
			for (TrabalhadorDto tDto : cargoDto.getCargoTrabalhadorDto()) {
				cargo.getCargoTrabalhador().add(trabalhadorMapperImpl.model(tDto));
			}
		}
		return cargo;
	}

	@Override
	public CargoDto modelDto(Cargo cargo) {
		CargoDto cDto = new CargoDto();
		if (cargo.getCargoTrabalhador() == null) {
			cDto.setId(cargo.getId());
			cDto.setNome(cargo.getNome());
			cDto.setSetor(setorMapperImpl.modelDto(cargo.getSetor()));
		} else {
			cDto.setId(cargo.getId());
			cDto.setNome(cargo.getNome());
			cDto.setSetor(setorMapperImpl.modelDto(cargo.getSetor()));
			for (Trabalhador t : cargo.getCargoTrabalhador()) {
				cDto.getCargoTrabalhadorDto().add(trabalhadorMapperImpl.modelDto(t));
			}
		}

		return cDto;
	}

}
