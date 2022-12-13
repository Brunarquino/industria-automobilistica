package br.com.gft.controllers;

import br.com.gft.dto.vendaDTO.ConsultaVendaDTO;
import br.com.gft.dto.vendaDTO.RegistroVendaDTO;
import br.com.gft.dto.vendaDTO.VendaMapper;
import br.com.gft.dto.vendaDTO.notaFiscalDTO.ConsultaNotaFiscalDTO;
import br.com.gft.dto.vendaDTO.notaFiscalDTO.NotaFiscalMapper;
import br.com.gft.entities.NotaFiscal;
import br.com.gft.entities.Venda;
import br.com.gft.services.VendaService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
@PreAuthorize("hasAuthority('ADMIN')")
@AllArgsConstructor
@RestController
@RequestMapping("v1/vendas")
public class VendaController {

    private final VendaService vendaService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    public ResponseEntity<ConsultaNotaFiscalDTO> salvarVenda(@RequestBody RegistroVendaDTO dto) {
        NotaFiscal notaFiscal = vendaService.salvarVenda(VendaMapper.fromDTO(dto));
        return ResponseEntity.ok(NotaFiscalMapper.fromEntity(notaFiscal));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    public ResponseEntity<Page<ConsultaVendaDTO>> listarTodasAsVendas(@PageableDefault Pageable pageable) {
        Page<Venda> vendas = vendaService.listarTodosAsVendas(pageable);
        return ResponseEntity.ok(vendas.map(VendaMapper::fromEntity));
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('VENDEDOR')")
    public ResponseEntity<ConsultaVendaDTO> buscarVendaPorId(@PathVariable Long id) {
        Venda venda = vendaService.buscarVendaPorId(id);
        return ResponseEntity.ok((VendaMapper.fromEntity(venda)));
    }

    @GetMapping("/lucros")
    public ResponseEntity<BigDecimal> visualizarLucroLoja() {
        return ResponseEntity.ok(vendaService.calcularValorLucroPorVendas());
    }


}
