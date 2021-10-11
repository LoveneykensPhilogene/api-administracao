package br.backend.api_selecao.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.backend.api_selecao.entities.Cargo;
import br.backend.api_selecao.entities.Setor;
import br.backend.api_selecao.entities.Trabalhador;
import io.swagger.annotations.ApiModelProperty;

public class SetorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private List<CargoDto> cargoDto;

	private List<TrabalhadorDto> trabalhadorDto;

	public SetorDto() {
	}

	public SetorDto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public SetorDto(Setor setor) {

		this.cargoDto = new ArrayList<>();
		this.trabalhadorDto = new ArrayList<>();
		if (setor.getTrabalhador() == null && setor.getCargo() != null) {

			this.setId(setor.getId());
			this.setNome(setor.getNome());
			for (Cargo cargo : setor.getCargo()) {
				cargoDto.add(new CargoDto(cargo));

			}
		} else if (setor.getTrabalhador() == null && setor.getCargo() == null) {
			this.setId(setor.getId());
			this.setNome(setor.getNome());

		} else {
			this.setId(setor.getId());
			this.setNome(setor.getNome());
			this.cargoDto = new ArrayList<>();
			for (Cargo cargo : setor.getCargo()) {
				CargoDto cDto = new CargoDto();
				cDto.setId(cargo.getId());
				cDto.setNome(cargo.getNome());
				cDto.setSetor(new SetorDto(setor.getId(), setor.getNome()));
				cargoDto.add(cDto);
			}
			for (Trabalhador trabalhador : setor.getTrabalhador()) {

				trabalhadorDto.add(new TrabalhadorDto(trabalhador));
			}

		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CargoDto> getCargoDto() {
		return cargoDto;
	}

	public List<TrabalhadorDto> getTrabalhadorDto() {
		return trabalhadorDto;
	}

}
