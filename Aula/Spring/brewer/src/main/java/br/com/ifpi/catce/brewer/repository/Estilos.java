package br.com.ifpi.catce.brewer.repository;

import br.com.ifpi.catce.brewer.model.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long> {
}
