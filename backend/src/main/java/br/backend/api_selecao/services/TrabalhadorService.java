package br.backend.api_selecao.services;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.AccessException;
import org.springframework.stereotype.Service;

import br.backend.api_selecao.dto.TrabalhadorDto;
import br.backend.api_selecao.entities.Cargo;
import br.backend.api_selecao.entities.Setor;
import br.backend.api_selecao.entities.Trabalhador;
import br.backend.api_selecao.repositories.CargoRepository;
import br.backend.api_selecao.repositories.SetorRepository;
import br.backend.api_selecao.repositories.TrabalhadorRepository;
import javassist.NotFoundException;

@Service
public class TrabalhadorService {

	@Autowired
	private TrabalhadorRepository trabalhadorRepository;

	@Autowired
	private SetorRepository setorRepository;

	@Autowired
	private CargoRepository cargoRepository;

	public TrabalhadorDto adicionar(TrabalhadorDto trabalhadorDto, Long idSetor, Long idCargo) throws SQLException, NotFoundException  {

		Trabalhador trabalhador = new Trabalhador();
		String cpfExiste = trabalhadorRepository.findByCpf(trabalhadorDto.getCpf());
		if (cpfExiste!= null) {
			throw new SQLException("Cpf já existiu");
		} else {

			Optional<Setor> setorOptional = setorRepository.findById(idSetor);

			Optional<Cargo> cargoOptional = cargoRepository.findById(idCargo);

			if (setorOptional.isPresent() && cargoOptional.isPresent()) {

				trabalhador.setNome(trabalhadorDto.getNome());
				trabalhador.setCpf(trabalhadorDto.getCpf());
				trabalhador.setSexo(trabalhadorDto.getSexo());
				trabalhador.setSetorTrabalhador(setorOptional.get());
				trabalhador.setCargo(cargoOptional.get());
				Trabalhador trabalhadorSave = trabalhadorRepository.save(trabalhador);

				return new TrabalhadorDto(trabalhadorSave);

			} else {

				throw new NotFoundException("Setor e cargo não existem");

			}
		}

	}

	public TrabalhadorDto atualizar(TrabalhadorDto tDto, Long id) throws AccessException, NotFoundException {

		Optional<Trabalhador> trabalhadorOptional = trabalhadorRepository.findById(id);

		if (tDto.getNome().isEmpty() && tDto.getCpf().isEmpty()) {
			throw new AccessException("Não pode ser nullo");
		} else {
			if (trabalhadorOptional.isPresent()) {
				Trabalhador trabalhador = trabalhadorOptional.get();
				trabalhador.setNome(tDto.getNome());
				trabalhador.setCpf(tDto.getCpf());
				trabalhador.setSexo(tDto.getSexo());
				Trabalhador tAtualizado = trabalhadorRepository.save(trabalhador);
				return new TrabalhadorDto(tAtualizado);
			} else {
				throw new NotFoundException("Não existe!");
			}

		}

	}

}
