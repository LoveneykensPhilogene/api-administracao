package br.backend.api_selecao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import javassist.NotFoundException;

@RestController
@RequestMapping("/")
public class TrabalhadorController {

	@Autowired
	private TrabalhadorService trabalhadorService;

	@PostMapping("trabalhador")
	@ResponseStatus(HttpStatus.CREATED)
	public TrabalhadorDto criarTrabalhador(@Validated @RequestBody TrabalhadorDto trabalhadorDto,
			@Validated @RequestParam("idSetor") Long id, @Validated @RequestParam("idCargo") Long idCargo) throws NotFoundException {
		return trabalhadorService.adicionar(trabalhadorDto, id, idCargo);
	}

	@PutMapping("/trabalhador")
	@ResponseStatus(HttpStatus.OK)
	public TrabalhadorDto atualizar(@Validated @RequestBody TrabalhadorDto t,
			@Validated @RequestParam("idTrabalhador") Long id) throws Exception {
		return trabalhadorService.atualizar(t, id);
	}

}
