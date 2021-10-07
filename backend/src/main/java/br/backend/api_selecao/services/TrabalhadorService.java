package br.backend.api_selecao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.backend.api_selecao.dto.TrabalhadorDto;
import br.backend.api_selecao.entities.Cargo;
import br.backend.api_selecao.entities.Setor;
import br.backend.api_selecao.entities.Trabalhador;
import br.backend.api_selecao.mapperImpl.TrabalhadorMapperImpl;
import br.backend.api_selecao.repositories.CargoRepository;
import br.backend.api_selecao.repositories.SetorRepository;
import br.backend.api_selecao.repositories.TrabalhadorRepository;

@Service
public class TrabalhadorService {

	@Autowired
	private TrabalhadorRepository trabalhadorRepository;

	@Autowired
	private SetorRepository setorRepository;

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private TrabalhadorMapperImpl trabalhadorMapperImpl;

	public TrabalhadorDto adicionar(TrabalhadorDto trabalhadorDto, Long idSetor, Long idCargo) {

		Trabalhador trabalhador = new Trabalhador();

		Setor setor = setorRepository.findById(idCargo).get();

		Cargo cargo = cargoRepository.findById(idCargo).get();

		trabalhador.setNome(trabalhadorDto.getNome());
		trabalhador.setCpf(trabalhadorDto.getCpf());
		trabalhador.setSexo(trabalhadorDto.getSexo());
		trabalhador.setCargo(cargo);
		trabalhador.setSetorTrabalhador(setor);

		Trabalhador trabalhadorSave = trabalhadorRepository.save(trabalhador);

		return trabalhadorMapperImpl.modelDto(trabalhadorSave);
	}

	public TrabalhadorDto atualizar(TrabalhadorDto tDto, Long id) {

		Trabalhador t = trabalhadorRepository.findById(id).get();
		if (tDto.equals(" ")) {
			return null;
		} else {
			t.setNome(tDto.getNome());
			t.setCpf(tDto.getCpf());
			t.setSexo(tDto.getSexo());
			Trabalhador tAtualizado = trabalhadorRepository.save(t);
			return trabalhadorMapperImpl.modelDto(tAtualizado);
		}

	}

}
