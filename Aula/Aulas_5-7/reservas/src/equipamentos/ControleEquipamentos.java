package equipamentos;

import java.util.ArrayList;

public class ControleEquipamentos {
    ArrayList<Equipamento> lista_equipamentos = new ArrayList<Equipamento>();

    public ArrayList<Equipamento> getLista_equipamentos() {
        return this.lista_equipamentos;
    }

    public void registrar_equipamento(Equipamento equipamento){
        lista_equipamentos.add(equipamento);
    }
}
