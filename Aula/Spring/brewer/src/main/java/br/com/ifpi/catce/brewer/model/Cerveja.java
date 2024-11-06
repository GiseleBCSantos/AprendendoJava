package br.com.ifpi.catce.brewer.model;

import br.com.ifpi.catce.brewer.validation.SKU;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@ToString
@Entity
@Table(name = "cerveja")
public class Cerveja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;


    @SKU
    @NotBlank(message = "SKU é obrigatório")
    private String sku;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 1, max = 50, message = "O tamanho da descrição deve estar entre 1 e 50")
    private String descricao;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor nao deve ser menor do que R$ 0,01")
    @DecimalMax(value = "9999999.99", message = "O valor não deve ser maior do que R$ 9999999.99")
    private BigDecimal valor;

    @NotNull(message = "O teor alcoólico é obrigatório")
    @DecimalMax(value = "100.0", message = "O teor alcoólico deve ser menor do que 100")
    @Column(name = "teor_alcoolico")
    private BigDecimal teorAlcoolico;

    @NotNull(message = "A comissão é obrigatória")
    @DecimalMax(value = "100.0", message = "A comissão deve ser menor do que 100")
    private BigDecimal comissao;

    @Max(value = 9999, message = "A quantidade em estoque deve ser menor do que 9.999")
    @NotNull(message = "A quantidade em estoque é obrigatória")
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @NotNull(message = "A origem é obrigatória")
    @Enumerated(EnumType.STRING)
    private Origem origem;

    @NotNull(message = "O sabor é obrigatório")
    @Enumerated(EnumType.STRING)
    private Sabor sabor;

    @NotNull(message = "O estilo é obrigatório")
    @ManyToOne
    @JoinColumn(name = "codigo_estilo")
    private Estilo estilo;

    @PrePersist @PreUpdate
    private void prePersistUpdate(){
        sku = sku.toUpperCase();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cerveja cerveja = (Cerveja) o;
        return Objects.equals(codigo, cerveja.codigo) && Objects.equals(sku, cerveja.sku) && Objects.equals(nome, cerveja.nome) && Objects.equals(descricao, cerveja.descricao) && Objects.equals(valor, cerveja.valor) && Objects.equals(teorAlcoolico, cerveja.teorAlcoolico) && Objects.equals(comissao, cerveja.comissao) && Objects.equals(quantidadeEstoque, cerveja.quantidadeEstoque) && origem == cerveja.origem && sabor == cerveja.sabor && Objects.equals(estilo, cerveja.estilo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, sku, nome, descricao, valor, teorAlcoolico, comissao, quantidadeEstoque, origem, sabor, estilo);
    }
}
