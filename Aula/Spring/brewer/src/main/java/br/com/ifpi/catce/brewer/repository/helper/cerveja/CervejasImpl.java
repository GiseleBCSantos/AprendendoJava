package br.com.ifpi.catce.brewer.repository.helper.cerveja;

import br.com.ifpi.catce.brewer.model.Cerveja;
import br.com.ifpi.catce.brewer.model.Estilo;
import br.com.ifpi.catce.brewer.repository.filter.CervejaFilter;
import br.com.ifpi.catce.brewer.repository.paginacao.PaginacaoUtil;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.criteria.*;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

public class CervejasImpl implements CervejasQueries {

    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PaginacaoUtil paginacaoUtil;


    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Cerveja> criteria = builder.createQuery(Cerveja.class);
        Root<Cerveja> root = criteria.from(Cerveja.class);
        List<Predicate> predicates = new ArrayList<>();



        adicionarFiltro(filtro, builder, predicates, root);

        criteria.where(predicates.toArray(new Predicate[0]));


        TypedQuery<Cerveja> query = paginacaoUtil.prepararPaginacao(pageable, criteria, predicates, builder, root, manager);

        return new PageImpl<>(query.getResultList(), pageable, total(filtro));
    }

    private Long total(CervejaFilter filtro) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Cerveja> root = criteria.from(Cerveja.class);
        List<Predicate> predicates = new ArrayList<>();

        adicionarFiltro(filtro, builder, predicates, root);
        criteria.where(predicates.toArray(new Predicate[0]));
        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private boolean isEstiloPresente(CervejaFilter filtro) {
        return filtro.getEstilo() != null && filtro.getEstilo().getCodigo() != null;
    }

    private void adicionarFiltro(CervejaFilter filtro, CriteriaBuilder builder, List<Predicate> predicates, Root<Cerveja> root) {
        if (filtro != null) {
            if (!StringUtils.isBlank(filtro.getSku())) {
                predicates.add(
                        builder.like(builder.lower(root.get("sku")), "%" + filtro.getSku().toLowerCase() + "%")
                );            }
            if (!StringUtils.isBlank(filtro.getNome())) {
                predicates.add(
                        builder.like(builder.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%")
                );
            }
            if (isEstiloPresente(filtro)){
                predicates.add(builder.equal(root.get("estilo"), filtro.getEstilo()));
            }
            if (filtro.getSabor() != null) {
                predicates.add(builder.equal(root.get("sabor"), filtro.getSabor()));
            }
            if (filtro.getOrigem() != null) {
                predicates.add(builder.equal(root.get("origem"), filtro.getOrigem()));
            }
            if (filtro.getValorDe() != null) {
                predicates.add(builder.ge(root.get("valor"), filtro.getValorDe()));
            }
            if (filtro.getValorAte() != null) {
                predicates.add(builder.le(root.get("valor"), filtro.getValorAte()));
            }
        }
    }
}
