package br.com.gft.dto.usuarioDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RegistroUsuarioDTO {

    private String email;
    private String senha;

}
