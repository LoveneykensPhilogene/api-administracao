package br.backend.api_selecao.mapperImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api_selecao.dto.CargoDto;
import br.backend.api_selecao.dto.TrabalhadorDto;
import br.backend.api_selecao.entities.Cargo;
import br.backend.api_selecao.entities.Setor;
import br.backend.api_selecao.entities.Trabalhador;
import br.backend.api_selecao.mapper.TrabalhadorMapper;

@Service
public class TrabalhadorMapperImpl implements TrabalhadorMapper {

	@Autowired
	private CargoMapperImpl cargoMapperImpl;

	@Autowired
	private SetorMapperImpl setorMapperImpl;

	@Override
	public Trabalhador model(TrabalhadorDto trabalhadorDto) {
		Trabalhador t = new Trabalhador();
		t.setNome(trabalhadorDto.getNome());
		t.setCpf(trabalhadorDto.getCpf());
		t.setSexo(trabalhadorDto.getSexo());
		t.setCargo(cargoMapperImpl.model(trabalhadorDto.getCargoDto()));
		t.setSetorTrabalhador(setorMapperImpl.model(trabalhadorDto.getSetorTrabalhadorDto()));
		return t;

	}

	@Override
	public TrabalhadorDto modelDto(Trabalhador trabalhador) {
		TrabalhadorDto tDto = new TrabalhadorDto();
		tDto.setId(trabalhador.getId());
		tDto.setNome(trabalhador.getNome());
		tDto.setCpf(trabalhador.getCpf());
		tDto.setSexo(trabalhador.getSexo());
		tDto.setCargoDto(null);
		tDto.setSetorTrabalhadorDto(null);
		
		return tDto;
	}

	
}
