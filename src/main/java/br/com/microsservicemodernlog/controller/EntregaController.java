package br.com.microsservicemodernlog.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.microsservicemodernlog.model.Entrega;
import br.com.microsservicemodernlog.model.dto.EntregaDto;
import br.com.microsservicemodernlog.repository.EntregaRepository;

@RestController
@RequestMapping("/modernlog/entregas")
public class EntregaController {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/consultar")
	public ModelAndView consultar() {
		ModelAndView modelView = new ModelAndView("entrega/consultar");
		
		List<Entrega> listaEntregas = entregaRepository.findAll();
		modelView.addObject("listarEntregas", listaEntregas);
		
		return modelView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(EntregaDto entregaDto) {
		ModelAndView modelView = new ModelAndView("entrega/cadastrar");

		return modelView;
	}
	
	@PostMapping
	public ModelAndView cadastrarEntrega(@Valid EntregaDto entregaDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("entrega/cadastrar");
		}

		Entrega entrega = modelMapper.map(entregaDto, Entrega.class);
		entregaRepository.save(entrega);

		return new ModelAndView("redirect:/modernlog");
	}
}
