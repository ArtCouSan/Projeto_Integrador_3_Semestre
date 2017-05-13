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

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet = null;

    public void inserir(Voo voo) throws SQLException, Exception {

        String sql = "INSERT INTO Voo (data_volta, data_ida, destino, origem, quantidade_passagens, preco, ativo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, voo.getData_volta());
            preparedStatement.setString(2, voo.getData_ida());
            preparedStatement.setString(3, voo.getDestino());
            preparedStatement.setString(4, voo.getOrigem());
            preparedStatement.setInt(5, voo.getQuantidade_passagens());
            preparedStatement.setDouble(6, voo.getPreco());
            preparedStatement.setBoolean(7, true);

            preparedStatement.execute();

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void alterar(Voo voo) throws SQLException, Exception {

        String sql = "UPDATE Voo SET data_volta=?, data_ida=?, destino=?, origem=?, quantidade_passagens=?, preco=?, ativo=? "
                + "WHERE id_voo=?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, voo.getData_volta());
            preparedStatement.setString(2, voo.getData_ida());
            preparedStatement.setString(3, voo.getDestino());
            preparedStatement.setString(4, voo.getOrigem());
            preparedStatement.setInt(5, voo.getQuantidade_passagens());
            preparedStatement.setDouble(6, voo.getPreco());
            preparedStatement.setBoolean(7, voo.isAtivo());
            preparedStatement.setInt(8, voo.getId_voo());

            preparedStatement.executeUpdate();

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public List<Voo> ListaVoo() throws SQLException, ClassNotFoundException {
        List<Voo> ListaVoo = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM Voo ORDER BY origem WHERE ativo=true";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Voo voo = new Voo();

                voo.setId_voo(resultSet.getInt("id_voo"));
                voo.setData_ida(resultSet.getString("data_ida"));
                voo.setData_volta(resultSet.getString("data_volta"));
                voo.setDestino(resultSet.getString("destino"));
                voo.setOrigem(resultSet.getString("origem"));
                voo.setQuantidade_passagens(resultSet.getInt("quantidade_passagens"));
                voo.setPreco(resultSet.getFloat("preco"));

                ListaVoo.add(voo);
            }
        } catch (SQLException e) {
        }
        connection.close();
        return ListaVoo;
    }

    public Voo getVooById(int id) throws SQLException, ClassNotFoundException {
        Voo voo = new Voo();

        connection = DbUtil.getConnection();

        String query = "SELECT * FROM Voo WHERE id_voo=?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                voo.setId_voo(resultSet.getInt("id_hotel"));
                voo.setData_ida(resultSet.getString("data_ida"));
                voo.setData_volta(resultSet.getString("data_volta"));
                voo.setDestino(resultSet.getString("destino"));
                voo.setOrigem(resultSet.getString("origem"));
                voo.setQuantidade_passagens(resultSet.getInt("quantidade_passagens"));
                voo.setPreco(resultSet.getFloat("preco"));
            }

        } catch (SQLException e) {
        }

        preparedStatement.close();
        connection.close();
        return voo;
    }

    public List<Voo> procurarVoo(Voo voo) throws SQLException, ClassNotFoundException {

        List<Voo> listaResultado = new ArrayList<>();

        connection = DbUtil.getConnection();

        String sql = "SELECT * FROM voo WHERE"
                + " data_volta = ?"
                + " OR data_ida = ?"
                + " OR destino = ?"
                + " OR origem = ?"
                + " OR quantidade_passagens = ?"
                + " OR preco = ?";

        preparedStatement = connection.prepareStatement(sql);

        // Insercoes.
        preparedStatement.setString(1, voo.getData_volta());
        preparedStatement.setString(2, voo.getData_ida());
        preparedStatement.setString(3, voo.getDestino());
        preparedStatement.setString(4, voo.getOrigem());
        preparedStatement.setInt(5, voo.getQuantidade_passagens());
        preparedStatement.setFloat(6, voo.getPreco());

        // Recebe e executa pergunta.
        ResultSet result = preparedStatement.executeQuery();

        // Loop com resultados.
        while (result.next()) {

            Voo voos = new Voo();

            // Insere informacoes.
            voos.setId_voo(resultSet.getInt("id_voo"));
            voos.setData_ida(resultSet.getString("data_ida"));
            voos.setData_volta(resultSet.getString("data_volta"));
            voos.setDestino(resultSet.getString("destino"));
            voos.setOrigem(resultSet.getString("origem"));
            voos.setQuantidade_passagens(resultSet.getInt("quantidade_passagens"));
            voos.setPreco(resultSet.getFloat("preco"));

            // Insere na lista.
            listaResultado.add(voos);

        }

        // Retorna lista.
        return listaResultado;

    }

}
