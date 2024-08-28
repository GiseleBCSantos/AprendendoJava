package espacos;

public class Espaco {
    private static int id;
    private int id_espaco;
    private String descricao;
    private boolean status;

    public Espaco(String descricao, boolean status){
        this.id_espaco = Espaco.id;
        this.descricao = descricao;
        this.status = status;
        Espaco.id++;
    }

    public int getId() {
        return this.id_espaco;
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


    @Override
    public String toString() {
        return
"\nid_espaco= " + id_espaco +
"\ndescricao= " + descricao +
"\nstatus= " + status  + "\n";
    }
}
