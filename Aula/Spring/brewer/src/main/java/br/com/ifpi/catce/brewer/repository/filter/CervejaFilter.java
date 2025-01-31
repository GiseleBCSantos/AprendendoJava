package br.com.ifpi.catce.brewer.repository.filter;

import br.com.ifpi.catce.brewer.model.Estilo;
import br.com.ifpi.catce.brewer.model.Origem;
import br.com.ifpi.catce.brewer.model.Sabor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CervejaFilter {

    private String sku;
    private String nome;
    private Estilo estilo;
    private Sabor sabor;
    private Origem origem;
    private BigDecimal valorDe;
    private BigDecimal valorAte;
}
