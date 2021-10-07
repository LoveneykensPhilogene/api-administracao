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

import br.backend.api_selecao.dto.SetorDto;
import br.backend.api_selecao.services.SetorService;

@RestController
@RequestMapping("/")
public class SetorController {

	@Autowired
	private SetorService setorService;

	@PostMapping("/setor")
	@ResponseStatus(HttpStatus.CREATED)
	public SetorDto criarSetor(@Validated @RequestBody SetorDto setorDto) {

		return setorService.criar(setorDto);
	}

	@GetMapping("/setores")
	@ResponseStatus(HttpStatus.OK)
	public List<SetorDto> findAll() {
		return setorService.findAll();
	}

	@PutMapping("/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public SetorDto editar(@Validated @PathVariable String nome, @Validated @RequestParam Long idCargo) {

		return setorService.editar(nome, idCargo);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public SetorDto excluir(@Validated @RequestParam Long id) {
		return setorService.excluir(id);
	}

}
