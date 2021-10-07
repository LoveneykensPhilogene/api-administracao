package br.backend.api_selecao.mapper;

import org.mapstruct.Mapper;

import br.backend.api_selecao.dto.TrabalhadorDto;
import br.backend.api_selecao.entities.Trabalhador;

@Mapper
public interface TrabalhadorMapper {

	Trabalhador model(TrabalhadorDto trabalhadorDto);

	TrabalhadorDto modelDto(Trabalhador trabalhador);

}
