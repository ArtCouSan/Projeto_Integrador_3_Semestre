package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Hotel;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    private Connection connection;

    public void inserir(Hotel hotel) throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO Hotel (nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes) "
                + "VALUES (?, ?, ?, ?, ?)";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, hotel.getNome_hotel());
            preparedStatement.setString(2, hotel.getData_entrada());
            preparedStatement.setString(3, hotel.getData_saida());
            preparedStatement.setString(4, hotel.getQuantidade_quartos());
            preparedStatement.setString(5, hotel.getQuantidade_hospedes());
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

    public void alterar(Hotel hotel) throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE Hotel SET nome_hotel=?, data_entrada=?, data_saida=?, quantidade_quartos=?, quantidade_hospedes=? "
                + "WHERE id_hotel=?";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, hotel.getNome_hotel());
            preparedStatement.setString(2, hotel.getData_entrada());
            preparedStatement.setString(3, hotel.getData_saida());
            preparedStatement.setString(4, hotel.getQuantidade_quartos());
            preparedStatement.setString(5, hotel.getQuantidade_hospedes());
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
        String sql = "DELETE FROM Hotel WHERE id_hotel=?";
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

    public List<Hotel> getListaHotel() throws SQLException, ClassNotFoundException {
        List<Hotel> ListaHotel = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM Hotel ORDER BY nome_hotel";

        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setNome_hotel(resultSet.getString("nome_hotel"));
                hotel.setData_entrada(resultSet.getString("data_entrada"));
                hotel.setData_saida(resultSet.getString("data_saida"));
                hotel.setQuantidade_quartos(resultSet.getString("quantidade_quartos"));
                hotel.setQuantidade_hospedes(resultSet.getString("quantidade_hospedes"));
                ListaHotel.add(hotel);
            }
        } catch (SQLException e) {
        }
        connection.close();
        return ListaHotel;
    }

    public Hotel getClienteById(int id) throws SQLException, ClassNotFoundException {
        Hotel hotel = new Hotel();
        connection = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM Hotel WHERE id_hotel=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        hotel.setId_hotel(resultSet.getInt("id_hotel"));
                        hotel.setNome_hotel(resultSet.getString("nome_hotel"));
                        hotel.setData_entrada(resultSet.getString("data_entrada"));
                        hotel.setData_saida(resultSet.getString("data_saida"));
                        hotel.setQuantidade_quartos(resultSet.getString("quantidade_quartos"));
                        hotel.setQuantidade_hospedes(resultSet.getString("quantidade_hospedes"));
                    }
                }
            }
        } catch (SQLException e) {
        }
        connection.close();
        return hotel;
    }
}
