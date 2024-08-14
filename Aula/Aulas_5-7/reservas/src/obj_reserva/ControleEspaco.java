package obj_reserva;

import java.util.ArrayList;

public class ControleEspaco {
    ArrayList<Espaco> lista_espacos = new ArrayList<Espaco>();

    public ArrayList<Espaco> getLista_espacos() {
        return this.lista_espacos;
    }

    public void registrar_espaco(Espaco espaco){
        lista_espacos.add(espaco);
    }
}
