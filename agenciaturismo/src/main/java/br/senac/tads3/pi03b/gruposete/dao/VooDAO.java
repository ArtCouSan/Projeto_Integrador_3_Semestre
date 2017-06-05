package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Voo;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VooDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

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
        String sql = "UPDATE Voo "
                + "SET data_volta = ?, data_ida = ?, destino = ?, origem = ?, quantidade_passagens = ?, preco = ?, ativo = ? "
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
            preparedStatement.setInt(8, voo.getId());

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
    
    public void excluir(int id) throws SQLException, ClassNotFoundException {
        String slq = "UPDATE Voo SET ativo = ? WHERE id_voo = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(slq);
            
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);

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

    public List<Voo> ListaVoo() throws SQLException, ClassNotFoundException {
        List<Voo> ListaVoo = new ArrayList<>();
        String query = "SELECT * FROM Voo ORDER BY origem WHERE ativo=true";

        try {
            connection = DbUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                Voo voo = new Voo();

                voo.setId(resultSet.getInt("id_voo"));
                voo.setData_ida(resultSet.getString("data_ida"));
                voo.setData_volta(resultSet.getString("data_volta"));
                voo.setDestino(resultSet.getString("destino"));
                voo.setOrigem(resultSet.getString("origem"));
                voo.setQuantidade_passagens(resultSet.getInt("quantidade_passagens"));
                voo.setPreco(resultSet.getFloat("preco"));

                ListaVoo.add(voo);
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return ListaVoo;
    }

    public Voo getVooById(int id) throws SQLException, ClassNotFoundException {
        Voo voo = new Voo();
        String query = "SELECT * FROM Voo WHERE id_voo = ? ";

        try {
            connection = DbUtil.getConnection();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                voo.setId(resultSet.getInt("id_voo"));
                voo.setData_ida(resultSet.getString("data_ida"));
                voo.setData_volta(resultSet.getString("data_volta"));
                voo.setDestino(resultSet.getString("destino"));
                voo.setOrigem(resultSet.getString("origem"));
                voo.setQuantidade_passagens(resultSet.getInt("quantidade_passagens"));
                voo.setPreco(resultSet.getFloat("preco"));
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return voo;
    }

    public List<Voo> procurarVoo(String busca) throws SQLException, IOException, ClassNotFoundException {
        List<Voo> listaResultado = new ArrayList<>();

        String sql;

        if (busca.length() != 0) {

            sql = "SELECT * FROM voo WHERE"
                    + " (data_volta = ?"
                    + " OR data_ida = ?"
                    + " OR destino = ?"
                    + " OR origem = ?"
                    + " OR quantidade_passagens = ?"
                    + " OR preco = ?)"
                    + " AND ativo = true";

            preparedStatement = connection.prepareStatement(sql);

            // Insercoes.
            preparedStatement.setString(1, busca);
            preparedStatement.setString(2, busca);
            preparedStatement.setString(3, busca);
            preparedStatement.setString(4, busca);
            int n1 = 0;
            try {
                n1 = Integer.parseInt(busca);
            } catch (NumberFormatException e) {
                System.out.println("Erro");
            }
            float n2 = 0;
            try {
                n2 = Float.parseFloat(busca);
            } catch (NumberFormatException e) {
                System.out.println("Erro");
            }
            preparedStatement.setInt(5, n1);
            preparedStatement.setFloat(6, n2);

        } else {
            sql = "SELECT * FROM voo WHERE ativo = true ";
            preparedStatement = connection.prepareStatement(sql);
        }

        try (ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {

                Voo voos = new Voo();

                voos.setId(result.getInt("id_voo"));
                voos.setData_ida(result.getString("data_ida"));
                voos.setData_volta(result.getString("data_volta"));
                voos.setDestino(result.getString("destino"));
                voos.setOrigem(result.getString("origem"));
                voos.setQuantidade_passagens(result.getInt("quantidade_passagens"));
                voos.setPreco(result.getFloat("preco"));

                listaResultado.add(voos);
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaResultado;
    }
}
