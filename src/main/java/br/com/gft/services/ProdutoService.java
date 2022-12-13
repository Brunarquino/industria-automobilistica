package br.com.gft.services;

import br.com.gft.entities.Produto;
import br.com.gft.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.gft.exceptions.EntityNotFoundException;

@AllArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto){
      return produtoRepository.save(produto);
    }

    public Produto buscarProdutoPorId(Long id){
        return produtoRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Produto não encontrada."));
    }

    public void deletarProduto(Long id){
        produtoRepository.delete(buscarProdutoPorId(id));
    }


}
