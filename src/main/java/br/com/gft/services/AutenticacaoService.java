package br.com.gft.services;

import br.com.gft.dto.autenticacaoDTO.AutenticacaoDTO;
import br.com.gft.dto.autenticacaoDTO.TokenDTO;
import br.com.gft.entities.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AutenticacaoService {

    private final AuthenticationManager authManager;

    public AutenticacaoService(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @Value("${industriaAutomobilistica.jwt.secret}")
    private String secret;
    @Value("${industriaAutomobilistica.jwt.expiration}")
    private String expiration;
    @Value("${industriaAutomobilistica.jwt.issuer}")
    private String issuer;

    public TokenDTO autenticar(AutenticacaoDTO authForm) throws AuthenticationException {
        Authentication authenticate =
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authForm.getEmail(), authForm.getSenha()));
        String token = gerarToken(authenticate);
        return new TokenDTO(token);
    }

    private Algorithm criarAlgoritimo() {
        return Algorithm.HMAC256(secret);
    }
    private String gerarToken(Authentication authenticate) {
        Usuario principal = (Usuario) authenticate.getPrincipal();

        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return JWT.create()
                .withIssuer(issuer)
                .withExpiresAt(dataExpiracao)
                .withSubject(principal.getId().toString())
                .sign(this.criarAlgoritimo());

    }

    public boolean verificaToken(String token) {
        try{
            if(token==null){
                return false;
            } else {
                JWT.require(this.criarAlgoritimo()).withIssuer(issuer).build().verify(token);
                return true;
            }
        } catch(JWTVerificationException jwtve) {
            return false;
        }
    }

    public Long retornarIdUsuario(String token) {
        String subject = JWT.require(this.criarAlgoritimo()).withIssuer(issuer).build().verify(token).getSubject();
        return Long.parseLong(subject);
    }


}

