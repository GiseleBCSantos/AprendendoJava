package br.com.ifpi.catce.brewer.repository;

import br.com.ifpi.catce.brewer.model.Cerveja;
import br.com.ifpi.catce.brewer.repository.helper.cerveja.CervejasQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>, CervejasQueries {

    public Optional<Cerveja> findBySkuIgnoreCase(String sku);

}
