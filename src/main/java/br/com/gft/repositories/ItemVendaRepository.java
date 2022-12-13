package br.com.gft.repositories;

import br.com.gft.entities.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository <ItemVenda, Long> {

}
