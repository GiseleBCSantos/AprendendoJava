package br.com.ifpi.catce.brewer.repository.helper.estilo;

import br.com.ifpi.catce.brewer.model.Estilo;
import br.com.ifpi.catce.brewer.repository.filter.CervejaFilter;
import br.com.ifpi.catce.brewer.repository.filter.EstiloFilter;
import br.com.ifpi.catce.brewer.repository.paginacao.PaginacaoUtil;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class EstilosImpl implements EstilosQueries {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PaginacaoUtil paginacaoUtil;



    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Estilo> criteria = builder.createQuery(Estilo.class);
        Root<Estilo> root = criteria.from(Estilo.class);
        List<Predicate> predicates = new ArrayList<>();

        adicionarFiltro(filtro, builder, predicates, root);

        criteria.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Estilo> query = paginacaoUtil.prepararPaginacao(pageable, criteria, predicates, builder, root, manager);

        return new PageImpl<>(query.getResultList(), pageable, total(filtro));
    }

    private Long total(EstiloFilter filtro) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Estilo> root = criteria.from(Estilo.class);
        List<Predicate> predicates = new ArrayList<>();

        adicionarFiltro(filtro, builder, predicates, root);
        criteria.where(predicates.toArray(new Predicate[0]));
        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }


    private void adicionarFiltro(EstiloFilter filtro, CriteriaBuilder builder, List<Predicate> predicates, Root<Estilo> root) {
        if (filtro != null) {
            if (!StringUtils.isBlank(filtro.getNome())) {
                predicates.add(
                        builder.like(builder.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%")
                );
            }
        }
    }


}
