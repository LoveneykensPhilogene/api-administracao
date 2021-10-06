package br.backend.api_selecao.dto;

import java.io.Serializable;
import java.util.List;

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
