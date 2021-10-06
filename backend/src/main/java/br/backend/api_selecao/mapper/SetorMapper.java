package br.backend.api_selecao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.backend.api_selecao.dto.SetorDto;
import br.backend.api_selecao.entities.Setor;

@Mapper
public interface SetorMapper {
	
	SetorMapper INSTANCE = Mappers.getMapper(SetorMapper.class);

	Setor model(SetorDto setorDto);

	SetorDto modelDto(Setor setor);

}
