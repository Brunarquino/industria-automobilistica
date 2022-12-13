package br.com.gft.dto.usuarioDTO;

import br.com.gft.entities.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioMapper {

    public static Usuario fromDTO(RegistroUsuarioDTO dto){
        String senhaEcriptografa = new BCryptPasswordEncoder().encode(dto.getSenha());
        return new Usuario(null, dto.getEmail(), senhaEcriptografa, null);
    }

    public static ConsultaUsuarioDTO fromEntity(Usuario usuario){
        return new ConsultaUsuarioDTO(usuario.getEmail(), usuario.getPerfil().getNome());
    }

}
