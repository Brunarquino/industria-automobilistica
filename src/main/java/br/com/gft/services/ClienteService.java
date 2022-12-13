package br.com.gft.services;

import br.com.gft.entities.Cliente;
import br.com.gft.entities.Endereco;
import br.com.gft.exceptions.EntityNotFoundException;
import br.com.gft.repositories.ClienteRepository;
import br.com.gft.services.cepService.impl.CepService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	private final CepService cepService;
	
	public Cliente salvarCliente(Cliente cliente) {
		try {
			Endereco endereco =
					cepService.pegarEnderecoPeloCep(
							cliente.getEndereco().getCep(),
							cliente.getEndereco().getNumero(),
							cliente.getEndereco().getComplemento());
			cliente.setEndereco(endereco);
		} catch (Exception ignored) {}

		return clienteRepository.save(cliente);
	}

	public Page<Cliente> listarTodosClientes(Pageable pageable){
		return clienteRepository.findAll(pageable);		
	}
	
	public Cliente buscarClientePorId(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() ->
						new EntityNotFoundException("Cliente não encontrado!"));
	}
	
	public Cliente atualizarCliente(Cliente cliente, Long id) {
		cliente.setId(this.buscarClientePorId(id).getId());
		return clienteRepository.save(cliente);		
	}
	
	public void deletarCliente(Long id) {
		clienteRepository.delete(this.buscarClientePorId(id));
	}
}
