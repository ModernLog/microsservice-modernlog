package br.com.microsservicemodernlog.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.microsservicemodernlog.model.Carga;
import br.com.microsservicemodernlog.model.dto.CargaDto;
import br.com.microsservicemodernlog.repository.CargaRepository;

@RestController
@RequestMapping("/modernlog/cargas")
public class CargaController {

	@Autowired
	private CargaRepository cargaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/consultar")
	public ModelAndView consultar() {
		ModelAndView modelView = new ModelAndView("carga/consultar");
		
		java.util.List<Carga> listaCarga = cargaRepository.findAll();
		modelView.addObject("listarCargas", listaCarga);
		
		return modelView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(CargaDto cargaDto) {
		ModelAndView modelView = new ModelAndView("carga/cadastrar");

		return modelView;
	}
	
	@PostMapping
	public ModelAndView cadastrarCarga(@Valid CargaDto cargaDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("carga/cadastrar");
		}
		
		Carga consultaCarga = cargaRepository.findByNotaFiscal(cargaDto.getNotaFiscal());
		
		if(consultaCarga == null) {
			Carga carga = modelMapper.map(cargaDto, Carga.class);
			cargaRepository.save(carga);
		}

		return new ModelAndView("redirect:/modernlog");
	}
}
