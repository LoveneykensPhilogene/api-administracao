package br.backend.api_selecao.mapperImpl;

import org.springframework.stereotype.Service;

import br.backend.api_selecao.dto.CargoDto;
import br.backend.api_selecao.dto.SetorDto;
import br.backend.api_selecao.dto.TrabalhadorDto;
import br.backend.api_selecao.entities.Cargo;
import br.backend.api_selecao.entities.Setor;
import br.backend.api_selecao.entities.Trabalhador;
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
		if (setor.getCargo() == null && setor.getTrabalhador() == null) {
			sDto.setId(setor.getId());
			sDto.setNome(setor.getNome());
		} else if (setor.getCargo() != null && setor.getTrabalhador() == null) {
			sDto.setId(setor.getId());
			sDto.setNome(setor.getNome());
			for (Cargo cargo : setor.getCargo()) {
				sDto.getCargoDto().add(new CargoDto(cargo));
			}
		} else {

			sDto.setId(setor.getId());
			sDto.setNome(setor.getNome());

			for (Cargo cargo : setor.getCargo()) {
				if (cargo.getCargoTrabalhador() == null) {

				} else {
					sDto.getCargoDto().add(new CargoDto(cargo));
				}
			}

			for (Trabalhador trabalhador : setor.getTrabalhador()) {
				sDto.getTrabalhadorDto().add(new TrabalhadorDto(trabalhador));
			}
		}

		return sDto;

	}

}
