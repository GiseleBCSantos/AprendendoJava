import obj_reserva.Equipamento;

public abstract class Funcionario {
    static int id;
    String nome;
    String email;
    private int senha;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Funcionario.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Funcionario(String nome, String email, int senha){
        Funcionario.id++;
        this.nome = nome;
        this.email = email;
        this.senha = senha;

    }

    public void reservar_equipamento(String data, Equipamento equipamento){
        Reserva reserva = new Reserva(data, this.nome, equipamento);
        boolean reserva_ok = reserva.reservar_equipamento();
        if (reserva_ok) {
            this.enviar_email();
        }
    }

    public void enviar_email(){
        System.out.println("Email enviado para " + this.email);
    }


}
