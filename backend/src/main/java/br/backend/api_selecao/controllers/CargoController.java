package br.backend.api_selecao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.backend.api_selecao.dto.CargoDto;
import br.backend.api_selecao.services.CargoService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/")
public class CargoController {

	@Autowired
	private CargoService cargoService;

	@PostMapping("/cargo/{idSetor}")
	@ResponseStatus(HttpStatus.CREATED)
	public CargoDto criarCargo(@Validated @RequestBody CargoDto cargo, @Validated @PathVariable Long idSetor) throws NotFoundException {

		return cargoService.criar(cargo, idSetor);
	}

	@GetMapping("/cargos")
	@ResponseStatus(HttpStatus.OK)
	public List<CargoDto> findAll() {
		return cargoService.findAll();
	}

}
