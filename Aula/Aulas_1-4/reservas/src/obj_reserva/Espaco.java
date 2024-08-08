package obj_reserva;

public class Espaco {
    int id;
    String descricao;
    boolean status;

    public Espaco(int id, String descricao, boolean status){
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public void reservar_espaco(){
        if (this.status == true){
            System.out.println("Espaço reservado com sucesso !!!");
            this.status = false;
        }
        else{
            System.out.println("Espaço já está reservado por outra pessoa.");
        }
    }
}
