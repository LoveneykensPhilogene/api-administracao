package br.backend.api_selecao.mapperImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api_selecao.dto.CargoDto;
import br.backend.api_selecao.dto.SetorDto;
import br.backend.api_selecao.entities.Cargo;
import br.backend.api_selecao.entities.Setor;
import br.backend.api_selecao.entities.Trabalhador;
import br.backend.api_selecao.mapper.SetorMapper;

@Service
public class SetorMapperImpl implements SetorMapper {

	@Autowired
	private CargoMapperImpl cargoMapperImpl;

	@Autowired
	private TrabalhadorMapperImpl trabalhadorMapperImpl;

	@Override
	public Setor model(SetorDto setorDto) {
		Setor s = new Setor();
		if (setorDto.getCargoDto() == null && setorDto.getTrabalhadorDto() == null) {
			s.setNome(setorDto.getNome());

		} else if (setorDto.getTrabalhadorDto() == null || setorDto.getCargoDto() != null) {

			s.setId(setorDto.getId());
			s.setNome(setorDto.getNome());
			for (CargoDto c : setorDto.getCargoDto()) {

				s.getCargo().add(cargoMapperImpl.model(c));
			}

		} else {
			s.setNome(setorDto.getNome());
		}
		return s;
	}

	@Override
	public SetorDto modelDto(Setor setor) {

		SetorDto sDto = new SetorDto();
		if (setor.getCargo() == null && setor.getTrabalhador() == null) {
			sDto.setId(setor.getId());
			sDto.setNome(setor.getNome());

		} else if (setor.getTrabalhador() == null || setor.getCargo() != null) {
			sDto.setId(setor.getId());
			sDto.setNome(setor.getNome());
			for (Cargo c : setor.getCargo()) {

				sDto.getCargoDto().add(cargoMapperImpl.modelDto(c));
			}

		} else {
			sDto.setId(setor.getId());
			sDto.setNome(setor.getNome());

			for (Trabalhador t : setor.getTrabalhador()) {

				sDto.getTrabalhadorDto().add(trabalhadorMapperImpl.modelDto(t));
			}

		}
		return sDto;

	}

}
