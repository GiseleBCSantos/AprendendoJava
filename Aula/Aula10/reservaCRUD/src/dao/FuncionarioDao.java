package dao;

import connection.ConnectionFactory;
import classes.funcionario.Chefia;
import classes.funcionario.Funcionario;
import classes.funcionario.Vigia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    Connection conn;

    public FuncionarioDao() throws SQLException{
        this.conn = new ConnectionFactory().get_connection();
    }

    public void add(Funcionario funcionario) throws SQLException {
        String sql = "insert into funcionarios (nome, email) values (?, ?)";

        if (funcionario instanceof Chefia){
            sql = "insert into funcionarios (nome, email, cargo, setor, senha) values (?, ?, ?, ?, ?)";
        }

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, funcionario.getNome());
        stmt.setString(2, funcionario.getEmail());
        if (funcionario instanceof Chefia){
            stmt.setString(3, ((Chefia) funcionario).getCargo());
            stmt.setString(4, ((Chefia) funcionario).getSetor());
            stmt.setInt(5, ((Chefia) funcionario).getSenha());
        }


        stmt.execute();
        stmt.close();
    }

    public List get_list() throws SQLException{
        List<Funcionario> lista_funcionarios = new ArrayList<Funcionario>();
        String sql = "select * from funcionarios";

        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        Funcionario funcionario_atual = null;

        while (rs.next()){
            if (rs.getString("senha") != null){
                funcionario_atual = new Chefia(rs.getString("nome"), rs.getString("email"), rs.getString("cargo"), rs.getString("setor"), rs.getInt("senha"));
                funcionario_atual.setId(rs.getInt("id"));
                lista_funcionarios.add(funcionario_atual);
            }
            else{
                funcionario_atual = new Vigia(rs.getString("nome"), rs.getString("email"));
                funcionario_atual.setId(rs.getInt("id"));
                lista_funcionarios.add(funcionario_atual);
            }
        }

        stmt.execute();
        stmt.close();

        return lista_funcionarios;
    }

    public Funcionario get_item_byNome(String nome) throws SQLException{
        String sql = "select * from funcionarios where nome=?";
        Funcionario funcionario = null;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            if (rs.getString("senha") != null){
                funcionario = new Chefia(rs.getString("nome"), rs.getString("email"), rs.getString("cargo"), rs.getString("setor"), rs.getInt("senha"));
            }
            else{
                funcionario = new Vigia(rs.getString("nome"), rs.getString("email"));
            }
        }

        stmt.close();

        return funcionario;

    }

    public Funcionario get_item_byId(int id) throws SQLException{
        String sql = "select * from funcionarios where id=?";
        Funcionario funcionario = null;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            if (rs.getString("senha") != null){
                funcionario = new Chefia(rs.getString("nome"), rs.getString("email"), rs.getString("cargo"), rs.getString("setor"), rs.getInt("senha"));
            }
            else{
                funcionario = new Vigia(rs.getString("nome"), rs.getString("email"));
            }
        }

        stmt.close();

        return funcionario;

    }

    public void update(int id, Funcionario funcionario) throws SQLException{
        String sql = "update funcionarios set nome=?, email=? where id=?";

        if (funcionario instanceof Chefia){
            sql = "update funcionarios nome=?, email=?, cargo=?, setor=?, senha=? where id=?";
        }
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, funcionario.getNome());
        stmt.setString(2, funcionario.getEmail());
        stmt.setInt(3, id);
        if (funcionario instanceof Chefia){
            stmt.setString(3, ((Chefia) funcionario).getCargo());
            stmt.setString(4, ((Chefia) funcionario).getSetor());
            stmt.setInt(5, ((Chefia) funcionario).getSenha());
            stmt.setInt(6, id);
        }

        stmt.execute();
        stmt.close();
    }

    public void remove(int id) throws SQLException{
        String sql = "delete from funcionarios where id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();
    }


}
