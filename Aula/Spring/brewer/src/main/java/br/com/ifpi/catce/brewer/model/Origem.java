package br.com.ifpi.catce.brewer.model;

public enum Origem {

    NACIONAL("Nacional"),
    INTERNACIONAL("Internacional");

    private String descricao;

    Origem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
