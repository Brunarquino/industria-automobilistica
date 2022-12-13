package br.com.gft.dto.fornecedorDTO;


import br.com.gft.dto.enderecoDTO.EnderecoMapper;
import br.com.gft.entities.Fornecedor;

public class FornecedorMapper {

    public static Fornecedor fromDTO(RegistroFornecedorDTO fornecedor) {
        return new Fornecedor(null, fornecedor.getNome(), fornecedor.getCnpj(), fornecedor.getNacionalidade(),
                fornecedor.getPontuacao(), EnderecoMapper.fromDTO(fornecedor.getEndereco()));
    }

    public static ConsultaFornecedorDTO fromEntity(Fornecedor fornecedor){
        return new ConsultaFornecedorDTO(fornecedor.getId(), fornecedor.getNome(), fornecedor.getCnpj(),
                fornecedor.getNacionalidade(), fornecedor.getPontuacao(), EnderecoMapper.fromEntity(fornecedor.getEndereco()));
    }
}
