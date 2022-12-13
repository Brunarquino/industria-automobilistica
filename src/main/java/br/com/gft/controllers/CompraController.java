package br.com.gft.controllers;

import br.com.gft.dto.compraDTO.CompraMapper;
import br.com.gft.dto.compraDTO.ConsultaCompraDTO;
import br.com.gft.dto.compraDTO.RegistroCompraDTO;
import br.com.gft.entities.Compra;
import br.com.gft.services.CompraService;
import br.com.gft.services.EstoqueService;

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
@RequestMapping("v1/compras")
public class CompraController {

    private final CompraService compraService;
    private final EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<ConsultaCompraDTO> salvarCompra(@RequestBody RegistroCompraDTO dto){
        Compra compra = compraService.salvarCompra(CompraMapper.fromDTO(dto));
        estoqueService.atualizarEstoqueCompra(compra.getItens());
        return ResponseEntity.ok(CompraMapper.fromEntity(compra));
    }

    @GetMapping
    public ResponseEntity<Page<ConsultaCompraDTO>>listarTodasAsCompras(@PageableDefault Pageable pageable){
        Page<Compra> compras = compraService.listarTodosAsCompras(pageable);
        return ResponseEntity.ok(compras.map(CompraMapper::fromEntity));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaCompraDTO> buscarCompraPorId(@PathVariable Long id){
        Compra compra = compraService.buscarCompraPorId(id);
        return ResponseEntity.ok((CompraMapper.fromEntity(compra)));
    }


}
