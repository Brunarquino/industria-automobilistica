package br.com.gft.services.cepService.impl;

import br.com.gft.entities.Endereco;
import br.com.gft.responses.CepResponse;
import org.springframework.stereotype.Service;

@Service
public interface CepService {

    CepResponse getCep(String Cep) throws Exception;
    Endereco pegarEnderecoPeloCep(String cep, String numero, String complemento) throws Exception;

}

