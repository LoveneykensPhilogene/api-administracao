package br.backend.api_selecao.mapperImpl;
import org.springframework.stereotype.Service;

import br.backend.api_selecao.dto.SetorDto;
import br.backend.api_selecao.entities.Setor;
import br.backend.api_selecao.mapper.SetorMapper;

@Service
public class SetorMapperImpl implements SetorMapper {

	@Override
	public Setor model(SetorDto setorDto) {
		Setor s = new Setor();
		s.setNome(setorDto.getNome());
		return s;
	}

	@Override
	public SetorDto modelDto(Setor setor) {
		SetorDto sDto = new SetorDto();
		sDto.setId(setor.getId());
		sDto.setNome(setor.getNome());
		return sDto;

	}

}
