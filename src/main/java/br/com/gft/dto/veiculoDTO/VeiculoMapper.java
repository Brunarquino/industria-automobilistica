package br.com.gft.dto.veiculoDTO;
import br.com.gft.dto.pecaDTO.ConsultaPecaDTO;
import br.com.gft.dto.pecaDTO.PecaMapper;
import br.com.gft.entities.*;

import java.util.List;

public class VeiculoMapper {

    public static Veiculo fromDto(RegistroVeiculoDTO registro){
        List<Peca> listaPecas = registro.getPecasId()
                .stream()
                .map(Peca::new).toList();

        return new Veiculo(null, new Produto(null, null, registro.getNome()),
                registro.getStatus(), registro.getValorInsumo(), listaPecas );
    }

    public static ConsultaVeiculoDTO fromEntity(Veiculo veiculo){
        List<ConsultaPecaDTO> listaPecas = veiculo.getPecas().
                stream().map(PecaMapper::fromEntity).toList();

        return new ConsultaVeiculoDTO(veiculo.getId(),veiculo.getProduto(),
                veiculo.getStatus(),veiculo.getValorInsumo(), listaPecas);
    }

}
