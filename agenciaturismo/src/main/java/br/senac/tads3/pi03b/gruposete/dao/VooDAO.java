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

        String sql = "INSERT INTO Voo (data_volta, data_ida, destino, origem, quantidade_passagens, preco, ativo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);

            stmn.setString(1, voo.getData_volta());
            stmn.setString(2, voo.getData_ida());
            stmn.setString(3, voo.getDestino());
            stmn.setString(4, voo.getOrigem());
            stmn.setInt(5, voo.getQuantidade_passagens());
            stmn.setDouble(6, voo.getPreco());
            stmn.setBoolean(7, true);

            stmn.execute();

        } finally {
            if (stmn != null && !stmn.isClosed()) {
                stmn.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public void alterar(Voo voo) throws SQLException, Exception {

        String sql = "UPDATE Voo SET data_volta=?, data_ida=?, destino=?, origem=?, quantidade_passagens=?, preco=?, ativo=? "
                + "WHERE id_voo=?";

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);

            stmn.setString(1, voo.getData_volta());
            stmn.setString(2, voo.getData_ida());
            stmn.setString(3, voo.getDestino());
            stmn.setString(4, voo.getOrigem());
            stmn.setInt(5, voo.getQuantidade_passagens());
            stmn.setDouble(6, voo.getPreco());
            stmn.setBoolean(7, voo.isAtivo());
            stmn.setInt(8, voo.getId_voo());

            stmn.executeUpdate();

        } finally {
            if (stmn != null && !stmn.isClosed()) {
                stmn.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public List<Voo> ListaVoo() throws SQLException, ClassNotFoundException {
        List<Voo> ListaVoo = new ArrayList<>();
        con = DbUtil.getConnection();
        String query = "SELECT * FROM Voo ORDER BY origem WHERE ativo=true";

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
                voo.setPreco(resultSet.getDouble("preco"));

                ListaVoo.add(voo);
            }
        } catch (SQLException e) {
        }
        con.close();
        return ListaVoo;
    }
}
