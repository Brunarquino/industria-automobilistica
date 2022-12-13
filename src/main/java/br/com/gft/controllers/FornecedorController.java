package br.com.gft.controllers;

import br.com.gft.dto.fornecedorDTO.ConsultaFornecedorDTO;
import br.com.gft.dto.fornecedorDTO.FornecedorMapper;
import br.com.gft.dto.fornecedorDTO.RegistroFornecedorDTO;
import br.com.gft.entities.Fornecedor;
import br.com.gft.services.FornecedorService;
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
@RequestMapping("v1/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<ConsultaFornecedorDTO> salvarFornecedor(@RequestBody RegistroFornecedorDTO dto){
        Fornecedor fornecedor = fornecedorService.salvarFornecedor(FornecedorMapper.fromDTO(dto));
        return ResponseEntity.ok(FornecedorMapper.fromEntity(fornecedor));
    }

    @GetMapping
    public ResponseEntity<Page<ConsultaFornecedorDTO>> buscarTodosOsFornecedores(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(fornecedorService.pegarTodosFornecedores(pageable).map(FornecedorMapper::fromEntity));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaFornecedorDTO> buscarFornecedor(@PathVariable Long id){
        Fornecedor fornecedor = fornecedorService.buscarFornecedorPorId(id);
        return ResponseEntity.ok(FornecedorMapper.fromEntity(fornecedor));
    }

    @PutMapping("{id}")
    public ResponseEntity<ConsultaFornecedorDTO> atualizarFornecedor(@RequestBody RegistroFornecedorDTO dto,
                                                                     @PathVariable Long id){
        Fornecedor fornecedor = fornecedorService.atualizarFornecedor(FornecedorMapper.fromDTO(dto), id);
        return ResponseEntity.ok(FornecedorMapper.fromEntity(fornecedor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultaFornecedorDTO> excluirFornecedor(@PathVariable Long id){
        fornecedorService.excluirFornecedor(id);
        return ResponseEntity.ok().build();
    }
}
