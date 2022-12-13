package br.com.gft.controllers;


import br.com.gft.dto.autenticacaoDTO.AutenticacaoDTO;
import br.com.gft.dto.autenticacaoDTO.TokenDTO;
import br.com.gft.dto.usuarioDTO.ConsultaUsuarioDTO;
import br.com.gft.dto.usuarioDTO.RegistroUsuarioDTO;
import br.com.gft.dto.usuarioDTO.UsuarioMapper;
import br.com.gft.entities.Usuario;
import br.com.gft.services.AutenticacaoService;
import br.com.gft.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.AuthenticationException;

@AllArgsConstructor
@RestController
@RequestMapping("v1/auth")
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;
    private final UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoDTO authForm){
        try {
            return ResponseEntity.ok(autenticacaoService.autenticar(authForm));
        } catch(AuthenticationException ae) {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/administradores")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaUsuarioDTO> salvarUsuarioAdmin(@RequestBody RegistroUsuarioDTO dto) {
        Usuario usuario = usuarioService.salvarUsuario(UsuarioMapper.fromDTO(dto), 1L);
        return ResponseEntity.ok(UsuarioMapper.fromEntity(usuario));
    }

    @PostMapping("/vendedores")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaUsuarioDTO> salvarUsuarioVendedor(@RequestBody RegistroUsuarioDTO dto) {
        Usuario usuario = usuarioService.salvarUsuario(UsuarioMapper.fromDTO(dto), 2L);
        return ResponseEntity.ok(UsuarioMapper.fromEntity(usuario));
    }

}