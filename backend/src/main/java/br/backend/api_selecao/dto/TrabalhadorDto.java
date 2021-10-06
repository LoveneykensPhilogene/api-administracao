package br.backend.api_selecao.dto;

import java.io.Serializable;

public class TrabalhadorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String cpf;

	private String sexo;

	private SetorDto setorTrabalhadorDto;

	private CargoDto cargoDto;

	public TrabalhadorDto() {
	}

	public TrabalhadorDto(Long id, String nome, String cpf, String sexo, SetorDto setorTrabalhadorDto,
			CargoDto cargoDto) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.setorTrabalhadorDto = setorTrabalhadorDto;
		this.cargoDto = cargoDto;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public SetorDto getSetorTrabalhadorDto() {
		return setorTrabalhadorDto;
	}

	public void setSetorTrabalhadorDto(SetorDto setorTrabalhadorDto) {
		this.setorTrabalhadorDto = setorTrabalhadorDto;
	}

	public CargoDto getCargoDto() {
		return cargoDto;
	}

	public void setCargoDto(CargoDto cargoDto) {
		this.cargoDto = cargoDto;
	}

}
