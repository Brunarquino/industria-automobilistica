package br.com.gft.services;

import br.com.gft.entities.NotaFiscal;
import br.com.gft.repositories.NotaFiscalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotaFiscalService {

    private final NotaFiscalRepository notaFiscalRepository;
    public NotaFiscal salvarNotaFiscal(NotaFiscal notaFiscal) {
        return notaFiscalRepository.save(notaFiscal);
    }

}
