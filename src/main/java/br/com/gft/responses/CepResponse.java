package br.com.gft.responses;

import lombok.*;

import java.io.Serializable;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CepResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    public String cep;
    public String logradouro;
    public String complemento;
    public String bairro;
    public String localidade;
    public String uf;
    public String ibge;
    public String gia;
    public String ddd;
    public String siafi;
}
