package obj_reserva;

public class Espaco {
    private int id;
    private String descricao;
    private boolean status;

    public Espaco(int id, String descricao, boolean status){
        this.id = id;
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

    public boolean solicitar_reserva(){
        if (isStatus()){
            setStatus(false);
            return true;
        }
        else{
            return false;
        }
    }
}
