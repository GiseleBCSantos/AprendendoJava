package espacos;

public class Espaco {
    private static int id;
    private String descricao;
    private boolean status;

    public Espaco(String descricao, boolean status){
        Espaco.id++;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
