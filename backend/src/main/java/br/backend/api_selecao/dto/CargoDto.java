package br.backend.api_selecao.dto;

import java.io.Serializable;
import java.util.List;

public class CargoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private SetorDto setor;

	private List<TrabalhadorDto> cargoTrabalhadorDto;

	public CargoDto() {
	}

	public CargoDto(Long id, String nome, SetorDto setor) {
		this.id = id;
		this.nome = nome;
		this.setor = setor;
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

	public SetorDto getSetor() {
		return setor;
	}

	public void setSetor(SetorDto setor) {
		this.setor = setor;
	}

	public List<TrabalhadorDto> getCargoTrabalhadorDto() {
		return cargoTrabalhadorDto;
	}

}
