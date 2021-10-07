package br.backend.api_selecao.mapper;

import org.mapstruct.Mapper;

import br.backend.api_selecao.dto.SetorDto;
import br.backend.api_selecao.entities.Setor;

@Mapper
public interface SetorMapper {
	
	
	Setor model(SetorDto setorDto);
	
	
	SetorDto modelDto(Setor setor);

}
