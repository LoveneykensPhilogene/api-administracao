package br.backend.api_selecao.controllers;

import java.rmi.AlreadyBoundException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.AccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.backend.api_selecao.dto.TrabalhadorDto;
import br.backend.api_selecao.services.TrabalhadorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;

@RestController
@RequestMapping("/")
public class TrabalhadorController {

	@Autowired
	private TrabalhadorService trabalhadorService;

	@ApiOperation(value = "Retorna um trabalhador cadastrado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um trabalhador cadastrado"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@PostMapping(value="trabalhador",produces="application/json",consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public TrabalhadorDto criarTrabalhador(@Validated @RequestBody TrabalhadorDto trabalhadorDto,
			@Validated @RequestParam("idSetor") Long id, @Validated @RequestParam("idCargo") Long idCargo) throws SQLException, NotFoundException  {
		return trabalhadorService.adicionar(trabalhadorDto, id, idCargo);
	}

	@ApiOperation(value = "Atualiza um trabalhador / e Retorna um trabalhador atualizado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um trabalhador cadastrado"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@PutMapping(value="/trabalhador",produces="application/json",consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public TrabalhadorDto atualizar(@Validated @RequestBody TrabalhadorDto trabalhodorDto,
			@Validated @RequestParam("idTrabalhador") Long id) throws AccessException, NotFoundException  {
		return trabalhadorService.atualizar(trabalhodorDto, id);
	}

}
