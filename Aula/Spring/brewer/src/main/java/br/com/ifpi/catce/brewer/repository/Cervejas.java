package br.com.ifpi.catce.brewer.repository;

import br.com.ifpi.catce.brewer.model.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface Cervejas extends JpaRepository<Cerveja, Long> {

    public Optional<Cerveja> findBySkuIgnoreCase(String sku);

}
