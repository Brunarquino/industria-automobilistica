package br.com.gft.repositories;

import br.com.gft.entities.ItemCompra;
import br.com.gft.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, Long> {

    List<ItemCompra> findByProdutoAndQuantidadeDeItensDisponiveisParaVendaGreaterThan
            (Produto produto, int quantidadeDeItensDisponiveisParaVenda);



}
