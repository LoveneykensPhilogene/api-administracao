package br.backend.api_selecao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.backend.api_selecao.dto.CargoDto;
import br.backend.api_selecao.dto.SetorDto;
import br.backend.api_selecao.services.SetorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
public class SetorController {

	@Autowired
	private SetorService setorService;

	@ApiOperation(value = "Retorna um setor cadastrado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um setor cadastrado"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@PostMapping(value = "/setor", produces = "application/json", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public SetorDto criarSetor(@Validated @RequestBody SetorDto setorDto) throws NullPointerException {

		return setorService.criar(setorDto);
	}

	@ApiOperation(value = "Retorna uma lista de setores")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma lista de setores"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@GetMapping(value = "/setores", produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<SetorDto> findAll() {
		return setorService.findAll();
	}

	@ApiOperation(value = "Atualiza um setor / Retorna setor atualizado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um setor cadastrado"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@PutMapping(value = "/{nome}", produces = "application/json", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public SetorDto editar(@Validated @PathVariable String nome, @Validated @RequestBody CargoDto cargoDto)
			throws Exception {

		return setorService.editar(nome, cargoDto);
	}

	@ApiOperation(value = "Exlui um setor / Retorna setor excluido")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um setor excluido"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public SetorDto excluir(@Validated @RequestParam Long id) {
		return setorService.excluir(id);
	}

}
