package dao;

import connection.ConnectionFactory;
import funcionarios.Funcionario;

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
        String sql = "insert into funcionarios (id, nome, email) values (?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, funcionario.getId());
        stmt.setString(2, funcionario.getNome());
        stmt.setString(3, funcionario.getEmail());

        stmt.execute();
        stmt.close();
    }

//    public List list_funcionarios() throws SQLException{
//        List<Funcionario> lista_funcionarios = new ArrayList<Funcionario>();
//        String sql = "select * from funcionarios";
//
//        PreparedStatement stmt = conn.prepareStatement(sql);
//
//        ResultSet rs = stmt.executeQuery();
//
//        while (rs.next()){
//            lista_funcionarios.add(new Funcionario(rs.getString("nome"), rs.getString("email")));
//        }
//    }
}
