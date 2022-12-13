package br.com.gft.dto.pecaDTO;

import br.com.gft.entities.Peca;
import br.com.gft.entities.Produto;


public class PecaMapper {

    public static Peca fromDTO(RegistroPecaDTO dto){
        return new Peca(null, new Produto(null,null, dto.getNome()));

    }
    public static ConsultaPecaDTO fromEntity(Peca peca){
        return new ConsultaPecaDTO(peca.getProduto().getId(), peca.getProduto().getNome());
    }
}
