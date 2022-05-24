package br.com.microsservicemodernlog.controller;

import javax.validation.Valid;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.microsservicemodernlog.model.Caminhao;
import br.com.microsservicemodernlog.model.dto.CaminhaoDto;
import br.com.microsservicemodernlog.repository.CaminhaoRepository;

@RestController
@RequestMapping("/modernlog/caminhoes")
public class CaminhaoController {

	@Autowired
	private CaminhaoRepository caminhaoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/consultar")
	public ModelAndView consultar() {
		ModelAndView modelView = new ModelAndView("caminhao/consultar");
		
		List<Caminhao> listaCaminhao = caminhaoRepository.findAll();
		modelView.addObject("listarCaminhoes", listaCaminhao);
		
		return modelView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(CaminhaoDto caminhaoDto) {
		ModelAndView modelView = new ModelAndView("caminhao/cadastrar");

		return modelView;
	}
	
	@PostMapping
	public ModelAndView cadastrarCaminhao(@Valid CaminhaoDto caminhaoDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("caminhao/cadastrar");
		}
		
		Caminhao consultaCaminhao = caminhaoRepository.findByModeloAndAno(caminhaoDto.getModelo(), caminhaoDto.getAno());
		
		if(consultaCaminhao == null) {
			Caminhao caminhao = modelMapper.map(caminhaoDto, Caminhao.class);
			caminhaoRepository.save(caminhao);
		}

		return new ModelAndView("redirect:/modernlog");
	}
}
