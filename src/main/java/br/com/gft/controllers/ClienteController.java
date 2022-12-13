package br.com.gft.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import br.com.gft.dto.clienteDTO.ClienteMapper;
import br.com.gft.dto.clienteDTO.ConsultaClienteDTO;
import br.com.gft.dto.clienteDTO.RegistroClienteDTO;
import br.com.gft.entities.Cliente;
import br.com.gft.services.ClienteService;

@PreAuthorize("hasAuthority('ADMIN')")
@AllArgsConstructor
@RestController
@RequestMapping("v1/clientes")
public class ClienteController {
	
	private final ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ConsultaClienteDTO> salvarCliente(@RequestBody RegistroClienteDTO dto) throws Exception {
			Cliente cliente = clienteService.salvarCliente(ClienteMapper.fromDTO(dto));
			return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
	public ResponseEntity<Page<ConsultaClienteDTO>> buscarTodosOsClientes(@PageableDefault Pageable pageable){
		return ResponseEntity.ok(clienteService.listarTodosClientes(pageable).map(ClienteMapper::fromEntity));
	}
	
	@GetMapping("{id}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
	public ResponseEntity<ConsultaClienteDTO> buscarCliente(@PathVariable Long id){
		Cliente cliente = clienteService.buscarClientePorId(id);
		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ConsultaClienteDTO> alterarCliente(@RequestBody RegistroClienteDTO dto,
			@PathVariable Long id){
		Cliente cliente = clienteService.atualizarCliente(ClienteMapper.fromDTO(dto), id);
		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaClienteDTO> excluirCliente(@PathVariable Long id){
		clienteService.deletarCliente(id);
		return ResponseEntity.ok().build();
	}

}
