package br.com.gft.controllers;

import br.com.gft.dto.pecaDTO.ConsultaPecaDTO;
import br.com.gft.dto.pecaDTO.PecaMapper;
import br.com.gft.dto.pecaDTO.RegistroPecaDTO;
import br.com.gft.entities.Peca;
import br.com.gft.services.PecaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasAuthority('ADMIN')")
@AllArgsConstructor
@RestController
@RequestMapping("v1/pecas")
public class PecaController {

    private final PecaService pecaService;

    @PostMapping
    public ResponseEntity<ConsultaPecaDTO> salvarPeca(@RequestBody RegistroPecaDTO dto){
        Peca peca = pecaService.salvarPeca(PecaMapper.fromDTO(dto));
        return ResponseEntity.ok(PecaMapper.fromEntity(peca));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    public ResponseEntity <Page<ConsultaPecaDTO>> listarTodasPecas(@PageableDefault Pageable pageable){
        Page <Peca> pecas = pecaService.listarTodasPecas(pageable);
        return ResponseEntity.ok(pecas.map(PecaMapper::fromEntity));

    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    public ResponseEntity<ConsultaPecaDTO> buscarPecaPorId(@PathVariable Long id){
        Peca peca = pecaService.buscarPecaPorId(id);
        return ResponseEntity.ok(PecaMapper.fromEntity(peca));
    }

    @PutMapping("{id}")
    public ResponseEntity<ConsultaPecaDTO> atualizarPeca(@RequestBody RegistroPecaDTO dto, @PathVariable Long id) {

            Peca peca = pecaService.atualizarPeca(PecaMapper.fromDTO(dto), id);
            return ResponseEntity.ok(PecaMapper.fromEntity(peca));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultaPecaDTO> deletarPeca(@PathVariable Long id){

       pecaService.deletarPeca(id);
       return ResponseEntity.ok().build();


    }
}
