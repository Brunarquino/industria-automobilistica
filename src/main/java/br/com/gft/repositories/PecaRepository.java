package br.com.gft.repositories;

import br.com.gft.entities.Fornecedor;
import br.com.gft.entities.Peca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {


    Page<Peca> findAll(Pageable pageable);

}
