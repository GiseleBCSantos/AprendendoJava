package br.com.ifpi.catce.brewer.repository.helper.cerveja;

import br.com.ifpi.catce.brewer.model.Cerveja;
import br.com.ifpi.catce.brewer.repository.filter.CervejaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CervejasQueries {

    public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);
}
