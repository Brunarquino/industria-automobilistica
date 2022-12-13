package br.com.gft.controllers;

import br.com.gft.dto.veiculoDTO.ConsultaVeiculoDTO;
import br.com.gft.dto.veiculoDTO.RegistroVeiculoDTO;
import br.com.gft.dto.veiculoDTO.VeiculoMapper;
import br.com.gft.entities.Veiculo;
import br.com.gft.services.VeiculoService;
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
@RequestMapping("v1/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<ConsultaVeiculoDTO> salvarVeiculo(@RequestBody RegistroVeiculoDTO dto){
        Veiculo veiculo = veiculoService.salvarVeiculo(VeiculoMapper.fromDto(dto));
        return ResponseEntity.ok(VeiculoMapper.fromEntity(veiculo));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    public ResponseEntity<Page<ConsultaVeiculoDTO>> listarTodosVeiculos(@PageableDefault Pageable pageable){
        Page <Veiculo> veiculo = veiculoService.buscarTodosVeiculos(pageable);
        return ResponseEntity.ok(veiculo.map(VeiculoMapper::fromEntity));
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    public ResponseEntity<ConsultaVeiculoDTO> buscarVeciucloPorId(@PathVariable Long id){
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);
        return ResponseEntity.ok(VeiculoMapper.fromEntity(veiculo));
    }

    @PutMapping("{id}")
    public ResponseEntity<ConsultaVeiculoDTO> atualizarVeiculo(@RequestBody RegistroVeiculoDTO dto, @PathVariable Long id) {
        Veiculo veiculo = veiculoService.atualizarVeiculo(VeiculoMapper.fromDto(dto), id);
        return ResponseEntity.ok(VeiculoMapper.fromEntity(veiculo));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultaVeiculoDTO> deletarVeiculo(@PathVariable Long id){
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.ok().build();
    }
}
