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

import br.com.microsservicemodernlog.model.Cliente;
import br.com.microsservicemodernlog.model.dto.ClienteDto;
import br.com.microsservicemodernlog.repository.ClienteRepository;

@RestController
@RequestMapping("/modernlog/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/consultar")
	public ModelAndView consultar() {
		ModelAndView modelView = new ModelAndView("cliente/consultar");
		
		List<Cliente> listaClientes = clienteRepository.findAll();
		modelView.addObject("listarClientes", listaClientes);
		
		return modelView;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(ClienteDto clienteDto) {
		ModelAndView modelView = new ModelAndView("cliente/cadastrar");

		return modelView;
	}
	
	@PostMapping
	public ModelAndView cadastrarCliente(@Valid ClienteDto clienteDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
//			return new ModelAndView("carga/cadastrar");
		}
		
		Cliente consultaCliente = clienteRepository.findByCnpj(clienteDto.getCnpj());
		
		if(consultaCliente == null) {
			Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
			clienteRepository.save(cliente);
		}

		return new ModelAndView("redirect:/modernlog");
	}
}
