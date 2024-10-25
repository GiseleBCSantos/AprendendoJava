package br.com.ifpi.catce.brewer.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Cerveja {

    @NotBlank(message = "SKU é obrigatório")
    private String sku;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @Size(min = 1, max = 50, message = "O tamanho da descrição deve estar entre 1 e 50")
    private String descricao;

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
}
