package br.com.gft.services;

import br.com.gft.entities.Peca;
import br.com.gft.entities.Veiculo;
import br.com.gft.enuns.TipoProduto;
import br.com.gft.exceptions.EntityNotFoundException;
import br.com.gft.repositories.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final PecaService pecaService;

    public Veiculo salvarVeiculo(Veiculo veiculo){

        List<Peca> listaPecas = veiculo.getPecas().stream()
                .map(p -> pecaService.buscarPecaPorId(p.getId())).toList();

        veiculo.setPecas(listaPecas);
        veiculo.getProduto().setTipoProduto(TipoProduto.VEICULOS);

        return veiculoRepository.save(veiculo);
    }

    public Page<Veiculo> buscarTodosVeiculos(Pageable pageable){
        return  veiculoRepository.findAll(pageable);
    }

    public Veiculo buscarVeiculoPorId(Long id){
        return veiculoRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Veiculo não encontrado!"));
    }

    public Veiculo atualizarVeiculo(Veiculo veiculo, Long id){
        Veiculo veiculoOriginal = buscarVeiculoPorId(id);

        veiculo.setId(veiculoOriginal.getId());
        veiculo.getProduto().setId(veiculoOriginal.getProduto().getId());

        return salvarVeiculo(veiculo);
    }

    public void deletarVeiculo(Long id){
        veiculoRepository.delete(buscarVeiculoPorId(id));
    }
}
