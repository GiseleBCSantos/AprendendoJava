package classes.espaco;

public class Espaco {
    private  int id;
    private String descricao;
    private boolean status;

    public Espaco(String descricao, boolean status){
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
"\nid_espaco= " + id +
"\ndescricao= " + descricao +
"\nstatus= " + status  + "\n";
    }
}
