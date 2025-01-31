package br.com.ifpi.catce.brewer.repository;

import br.com.ifpi.catce.brewer.model.Estilo;
import br.com.ifpi.catce.brewer.repository.helper.estilo.EstilosQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories(basePackages = "br.com.ifpi.catce.brewer.repository")
public interface Estilos extends JpaRepository<Estilo, Long>, EstilosQueries {

    public Optional<Estilo> findByNomeIgnoreCase(String nome);
}
