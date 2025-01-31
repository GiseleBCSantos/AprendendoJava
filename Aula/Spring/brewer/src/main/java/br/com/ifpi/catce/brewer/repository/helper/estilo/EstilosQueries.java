package br.com.ifpi.catce.brewer.repository.helper.estilo;

import br.com.ifpi.catce.brewer.model.Estilo;
import br.com.ifpi.catce.brewer.repository.filter.CervejaFilter;
import br.com.ifpi.catce.brewer.repository.filter.EstiloFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstilosQueries {

    public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);
}
