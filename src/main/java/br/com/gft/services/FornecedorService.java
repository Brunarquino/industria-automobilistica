package br.com.gft.services;

import br.com.gft.entities.Endereco;
import br.com.gft.exceptions.EntityNotFoundException;
import br.com.gft.services.cepService.impl.CepService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.gft.entities.Fornecedor;
import br.com.gft.repositories.FornecedorRepository;

@AllArgsConstructor
@Service
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;
    private final CepService cepService;

    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        try {
            Endereco endereco =
                    cepService.pegarEnderecoPeloCep(
                            fornecedor.getEndereco().getCep(),
                            fornecedor.getEndereco().getNumero(),
                            fornecedor.getEndereco().getComplemento());
            fornecedor.setEndereco(endereco);
        } catch (Exception ignored) {}
        return fornecedorRepository.save(fornecedor);
    }

    public Page<Fornecedor> pegarTodosFornecedores(Pageable pageable){
        return fornecedorRepository.findAll(pageable);
    }

    public Fornecedor buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Fornecedor não encontrado."));
    }

    public Fornecedor atualizarFornecedor(Fornecedor fornecedor, Long id){
        fornecedor.setId(buscarFornecedorPorId(id).getId());
        return salvarFornecedor(fornecedor);
    }

    public void excluirFornecedor(Long id) {
        fornecedorRepository.delete(buscarFornecedorPorId(id));
    }
}
