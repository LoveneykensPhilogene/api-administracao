package br.backend.api_selecao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.backend.api_selecao.dto.TrabalhadorDto;
import br.backend.api_selecao.entities.Trabalhador;

@Mapper
public interface TrabalhadorMapper {

	TrabalhadorMapper INSTANCE = Mappers.getMapper(TrabalhadorMapper.class);

	Trabalhador model(TrabalhadorDto trabalhadorDto);

	TrabalhadorDto modelDto(Trabalhador trabalhador);

}
