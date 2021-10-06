package br.backend.api_selecao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.backend.api_selecao.dto.CargoDto;
import br.backend.api_selecao.entities.Cargo;

@Mapper
public interface CargoMapper {

	CargoMapper INSTANCE = Mappers.getMapper(CargoMapper.class);

	Cargo model(CargoDto cargoDto);

	CargoDto modelDto(Cargo cargo);

}
