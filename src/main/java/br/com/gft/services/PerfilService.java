package br.com.gft.services;

import br.com.gft.entities.Perfil;
import br.com.gft.repositories.PerfilRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@AllArgsConstructor
@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public Perfil buscarPerfilPorId(Long id){
        return perfilRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Perfil não encontrado"));
    }

}
