package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Voo;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VooDAO {

    private Connection connection;

    public void inserir(Voo voo) throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO Voo (data_volta, data_ida, destino, origem, quantidade_passagens) "
                + "VALUES (?, ?, ?, ?, ?)";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, voo.getData_volta());
            preparedStatement.setString(2, voo.getData_ida());
            preparedStatement.setString(3, voo.getDestino());
            preparedStatement.setString(4, voo.getOrigem());
            preparedStatement.setInt(5, voo.getQuantidade_passagens());
            //Executa o comando no banco de dados
            preparedStatement.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void alterar(Voo voo) throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE Voo SET data_volta=?, data_ida=?, destino=?, origem=?, quantidade_passagens=? "
                + "WHERE id_voo=?";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, voo.getData_volta());
            preparedStatement.setString(2, voo.getData_ida());
            preparedStatement.setString(3, voo.getDestino());
            preparedStatement.setString(4, voo.getOrigem());
            preparedStatement.setInt(5, voo.getQuantidade_passagens());
            preparedStatement.setInt(6, voo.getId_voo());
            //Executa o comando no banco de dados
            preparedStatement.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void excluir(int id) throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "DELETE FROM Voo WHERE id=?";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, id);
            //Executa o comando no banco de dados
            preparedStatement.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public List<Voo> getListaVoo() throws SQLException, ClassNotFoundException {
        List<Voo> ListaVoo = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM Voo ORDER BY origem";

        try {
            Statement st = connection.createStatement();
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
        connection.close();
        return ListaVoo;
    }

    public Voo getVooById(int id) throws SQLException, ClassNotFoundException {
        Voo voo = new Voo();
        connection = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM Voo WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        voo.setId_voo(resultSet.getInt("id_voo"));
                        voo.setData_ida(resultSet.getString("data_ida"));
                        voo.setData_volta(resultSet.getString("data_volta"));
                        voo.setDestino(resultSet.getString("destino"));
                        voo.setOrigem(resultSet.getString("origem"));
                        voo.setQuantidade_passagens(resultSet.getInt("quantidade_passagens"));
                    }
                }
            }
        } catch (SQLException e) {
        }
        connection.close();
        return voo;
    }
}
