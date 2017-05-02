package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Voo;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VooDAO {

    private static Connection con;
    private static PreparedStatement stmn;

    public void inserir(Voo voo) throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO Voo (data_volta, data_ida, destino, origem, quantidade_passagens) "
                + "VALUES (?, ?, ?, ?, ?)";
        //Cria um statement para execução de instruções SQL
        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            stmn.setString(1, voo.getData_volta());
            stmn.setString(2, voo.getData_ida());
            stmn.setString(3, voo.getDestino());
            stmn.setString(4, voo.getOrigem());
            stmn.setInt(5, voo.getQuantidade_passagens());
            //Executa o comando no banco de dados
            stmn.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (stmn != null && !stmn.isClosed()) {
                stmn.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public void alterar(Voo voo) throws SQLException, Exception {

        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE Voo SET data_volta=?, data_ida=?, destino=?, origem=?, quantidade_passagens=? "
                + "WHERE id_voo=?";
        //Cria um statement para execução de instruções SQL
        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            stmn.setString(1, voo.getData_volta());
            stmn.setString(2, voo.getData_ida());
            stmn.setString(3, voo.getDestino());
            stmn.setString(4, voo.getOrigem());
            stmn.setInt(5, voo.getQuantidade_passagens());
            stmn.setInt(6, voo.getId_voo());
            //Executa o comando no banco de dados
            stmn.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (stmn != null && !stmn.isClosed()) {
                stmn.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public void excluir(int id) throws SQLException, Exception {

        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "DELETE FROM Voo WHERE id=?";
        //Cria um statement para execução de instruções SQL

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            stmn.setInt(1, id);
            //Executa o comando no banco de dados
            stmn.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (stmn != null && !stmn.isClosed()) {
                stmn.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public List<Voo> getListaVoo() throws SQLException, ClassNotFoundException {
        List<Voo> ListaVoo = new ArrayList<>();
        con = DbUtil.getConnection();
        String query = "SELECT * FROM Voo ORDER BY origem";

        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Voo voo = new Voo();
                voo.setId_voo(resultSet.getInt("id_voo"));
                voo.setData_ida(resultSet.getString("data_ida"));
                voo.setData_volta(resultSet.getString("data_volta"));
                voo.setDestino(resultSet.getString("destino"));
                voo.setOrigem(resultSet.getString("origem"));
                voo.setQuantidade_passagens(resultSet.getInt("quantidade_passagens"));
                ListaVoo.add(voo);
            }
        } catch (SQLException e) {
        }
        con.close();
        return ListaVoo;
    }
    public Voo getHotelById(int id) throws SQLException, ClassNotFoundException {
        Voo voo = new Voo();
        con = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM Voo WHERE id_voo=?";
            stmn = con.prepareStatement(query);
            stmn.setInt(1, id);
            try (ResultSet resultSet = stmn.executeQuery()) {
                while (resultSet.next()) {
                    voo.setData_ida(resultSet.getString("data_ida"));
                    voo.setData_volta(resultSet.getString("data_volta"));
                    voo.setDestino(resultSet.getString("destino"));
                    voo.setOrigem(resultSet.getString("origem"));
                    voo.setQuantidade_passagens(resultSet.getInt("quantidade_passagens"));
                }
            }
            stmn.close();
        } catch (SQLException e) {
        }
        con.close();
        return voo;
    }
    
}
