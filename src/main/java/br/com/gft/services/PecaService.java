package br.com.gft.services;

import br.com.gft.entities.Peca;
import br.com.gft.enuns.TipoProduto;
import br.com.gft.exceptions.EntityNotFoundException;
import br.com.gft.repositories.PecaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
@AllArgsConstructor
public class PecaService {

    private final PecaRepository pecaRepository;

     public Peca salvarPeca(Peca peca){
       peca.getProduto().setTipoProduto(TipoProduto.PECAS);
       return pecaRepository.save(peca);
    }

    public Page<Peca> listarTodasPecas(Pageable pageable){
         return pecaRepository.findAll(pageable);
    }


    public Peca buscarPecaPorId(Long id){
        return pecaRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Peça não encontrada."));
    }

    public Peca atualizarPeca(Peca peca, Long id){
        Peca pecaOriginal = buscarPecaPorId(id);
        peca.setId(pecaOriginal.getId());

        peca.getProduto().setId(pecaOriginal.getProduto().getId());
        return salvarPeca(peca);
    }

    public void deletarPeca(Long id){
         pecaRepository.delete(buscarPecaPorId(id));
    }
}
