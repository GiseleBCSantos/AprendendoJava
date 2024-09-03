package equipamentos;


import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquipamentoDao {
    private Connection conn;
    Scanner sc = new Scanner(System.in);

    public EquipamentoDao() throws SQLException{
        this.conn = new ConnectionFactory().get_connection();
    }

    public void add(Equipamento equipamento){
        String sql = "insert into equipamentos (id, descricao, quantidade_total, quantidade_disponivel) values (?, ?, ?, ?)";

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, equipamento.getId());
            stmt.setString(2, equipamento.getDescricao());
            stmt.setInt(3, equipamento.getQuantidade_total());
            stmt.setInt(4, equipamento.getQuantidade_disponivel());

            stmt.execute();
            stmt.close();

            System.out.println("Equipamento adicionado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List get_list() throws SQLException{
        String sql = "select * from equipamentos";
        PreparedStatement stmt = conn.prepareStatement(sql);

        List<Equipamento> lista_equipamentos = new ArrayList<Equipamento>();

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Equipamento equipamento = new Equipamento(rs.getInt("id"), rs.getString("descricao"), rs.getInt("quantidade_total"), rs.getInt("quantidade_disponivel"));

            lista_equipamentos.add(equipamento);
        }

        rs.close();
        stmt.close();

        return lista_equipamentos;
    }

    public Equipamento get_item(String descricao) throws SQLException{
        String sql = "select * from equipamentos where descricao=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        Equipamento equipamento = null;

        stmt.setString(1, descricao);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            equipamento = new Equipamento(rs.getInt("id"), rs.getString("descricao"), rs.getInt("quantidade_total"), rs.getInt("quantidade_disponivel"));
        }
        
        rs.close();
        stmt.close();
        
        return equipamento;

//        return new Equipamento(rs.getString("descricao"), rs.getInt("quantidade_total"), rs.getInt("quantidade_disponivel"));
    }

    public void update(Equipamento equipamento) throws SQLException{
        String sql = "update equipamentos set descricao=?, quantidade_total=?, quantidade_disponivel=? where id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        Scanner sc = new Scanner(System.in);
        try{

            System.out.println("Descricao atual: " + equipamento.getDescricao() + ". Insira o novo valor: ");
            String nova_descricao = sc.next();

            System.out.println("Quantidade de itens total: "+ equipamento.getQuantidade_total() + ". Insira o novo valor: ");
            int nova_quantidade_total = sc.nextInt();

            System.out.println("Quantidade de itens disponiveis: "+ equipamento.getQuantidade_disponivel() + ". Insira o novo valor: ");
            int nova_quantidade_disponivel = sc.nextInt();

            stmt.setString(1, nova_descricao);
            stmt.setInt(2, nova_quantidade_total);
            stmt.setInt(3, nova_quantidade_disponivel);
            stmt.setInt(4, equipamento.getId());

            stmt.execute();
            stmt.close();

            System.out.println("Equipamento atualizado com sucesso!");
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public void delete(Equipamento equipamento) throws SQLException{
        String sql = "delete from  equipamentos where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        try {
            stmt.setInt(1, equipamento.getId());
            stmt.execute();
            stmt.close();

            System.out.println("Equipamento deletado com sucesso!");
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



}
