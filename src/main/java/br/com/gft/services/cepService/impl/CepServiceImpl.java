package br.com.gft.services.cepService.impl;

import br.com.gft.entities.Endereco;
import br.com.gft.responses.CepResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@Transactional
public class CepServiceImpl implements CepService {

    @Override
    public CepResponse getCep(String cep){
        RestTemplate restTemplate = new RestTemplate();
        String URLAPI = "https://viacep.com.br/ws/" + cep + "/json/";
        return restTemplate.getForObject(URLAPI, CepResponse.class);
    }

    @Override
    public Endereco pegarEnderecoPeloCep(String cep, String numero, String complemento) {
        CepResponse cepResponse = getCep(cep);
        return new Endereco(cepResponse.getCep(), cepResponse.getUf(), "", cepResponse.getBairro(),
                cepResponse.getLogradouro(), numero,
                complemento);
    }

}
