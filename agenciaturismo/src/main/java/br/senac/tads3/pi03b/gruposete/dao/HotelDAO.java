package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Hotel;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

    public void inserir(Hotel hotel) throws SQLException, Exception {

        String sql = "INSERT INTO Hotel (nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes, preco, ativo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, hotel.getNome_hotel());
            preparedStatement.setString(2, hotel.getData_entrada());
            preparedStatement.setString(3, hotel.getData_saida());
            preparedStatement.setInt(4, hotel.getQuantidade_quartos());
            preparedStatement.setInt(5, hotel.getQuantidade_hospedes());
            preparedStatement.setDouble(6, hotel.getPreco());
            preparedStatement.setBoolean(7, true);

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

    public void alterar(Hotel hotel) throws SQLException, Exception {

        String sql = "UPDATE Hotel "
                + "SET nome_hotel=?, data_entrada=?, data_saida=?, quantidade_quartos=?, quantidade_hospedes=?, preco=?, ativo=? "
                + "WHERE id_hotel=?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, hotel.getNome_hotel());
            preparedStatement.setString(2, hotel.getData_entrada());
            preparedStatement.setString(3, hotel.getData_saida());
            preparedStatement.setInt(4, hotel.getQuantidade_quartos());
            preparedStatement.setInt(5, hotel.getQuantidade_hospedes());
            preparedStatement.setDouble(6, hotel.getPreco());
            preparedStatement.setBoolean(7, hotel.isAtivo());
            preparedStatement.setInt(8, hotel.getId_hotel());

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

    public List<Hotel> ListaHotel() throws SQLException, ClassNotFoundException {
        List<Hotel> ListaHotel = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM Hotel ORDER BY nome_hotel WHERE ativo=true";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Hotel hotel = new Hotel();

                hotel.setId_hotel(resultSet.getInt("id_hotel"));
                hotel.setNome_hotel(resultSet.getString("nome_hotel"));
                hotel.setData_entrada(resultSet.getString("data_entrada"));
                hotel.setData_saida(resultSet.getString("data_saida"));
                hotel.setQuantidade_quartos(resultSet.getInt("quantidade_quartos"));
                hotel.setQuantidade_hospedes(resultSet.getInt("quantidade_hospedes"));
                hotel.setPreco(resultSet.getDouble("preco"));

                ListaHotel.add(hotel);
            }
        } catch (SQLException e) {
        }
        connection.close();
        return ListaHotel;
    }
    
    public Hotel getHotelById(int id) throws SQLException, ClassNotFoundException {
        Hotel hotel = new Hotel();
        
        connection = DbUtil.getConnection();
        
        String query = "SELECT * FROM Hotel WHERE id_hotel=?";
        
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                hotel.setId_hotel(resultSet.getInt("id_hotel"));
                hotel.setNome_hotel(resultSet.getString("nome_hotel"));
                hotel.setData_entrada(resultSet.getString("data_entrada"));
                hotel.setData_saida(resultSet.getString("data_saida"));
                hotel.setQuantidade_quartos(resultSet.getInt("quantidade_quartos"));
                hotel.setQuantidade_hospedes(resultSet.getInt("quantidade_hospedes"));
                hotel.setPreco(resultSet.getDouble("preco"));
            }
            
        } catch (SQLException e) {
        }
        
        preparedStatement.close();
        connection.close();
        return hotel;
    }
}
