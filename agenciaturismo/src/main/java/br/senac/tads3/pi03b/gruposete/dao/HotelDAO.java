package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Hotel;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;

import java.sql.*;
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

            preparedStatement.setString(1, hotel.getNome());
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
                + "SET nome_hotel = ?, data_entrada = ?, data_saida = ?, quantidade_quartos = ?, quantidade_hospedes = ?, preco = ?, ativo = ? "
                + "WHERE id_hotel = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, hotel.getNome());
            preparedStatement.setString(2, hotel.getData_entrada());
            preparedStatement.setString(3, hotel.getData_saida());
            preparedStatement.setInt(4, hotel.getQuantidade_quartos());
            preparedStatement.setInt(5, hotel.getQuantidade_hospedes());
            preparedStatement.setDouble(6, hotel.getPreco());
            preparedStatement.setBoolean(7, hotel.isAtivo());
            preparedStatement.setInt(8, hotel.getId());

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
        String slq = "UPDATE Hotel SET ativo = ? WHERE id_hotel = ?";

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

    public List<Hotel> ListaHotel() throws SQLException, ClassNotFoundException {
        List<Hotel> ListaHotel = new ArrayList<>();
        String query = "SELECT * FROM Hotel ORDER BY nome_hotel WHERE ativo=true";

        try {
            connection = DbUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Hotel hotel = new Hotel();

                hotel.setId(resultSet.getInt("id_hotel"));
                hotel.setNome(resultSet.getString("nome_hotel"));
                hotel.setData_entrada(resultSet.getString("data_entrada"));
                hotel.setData_saida(resultSet.getString("data_saida"));
                hotel.setQuantidade_quartos(resultSet.getInt("quantidade_quartos"));
                hotel.setQuantidade_hospedes(resultSet.getInt("quantidade_hospedes"));
                hotel.setPreco(resultSet.getFloat("preco"));

                ListaHotel.add(hotel);
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return ListaHotel;
    }

    public Hotel getHotelById(int id) throws SQLException, ClassNotFoundException {
        Hotel hotel = new Hotel();
        String query = "SELECT * FROM Hotel WHERE id_hotel = ?";

        try {
            connection = DbUtil.getConnection();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                hotel.setId(resultSet.getInt("id_hotel"));
                hotel.setNome(resultSet.getString("nome_hotel"));
                hotel.setData_entrada(resultSet.getString("data_entrada"));
                hotel.setData_saida(resultSet.getString("data_saida"));
                hotel.setQuantidade_quartos(resultSet.getInt("quantidade_quartos"));
                hotel.setQuantidade_hospedes(resultSet.getInt("quantidade_hospedes"));
                hotel.setPreco(resultSet.getFloat("preco"));
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return hotel;
    }

    public List<Hotel> procurarHotel(String busca) throws ClassNotFoundException, SQLException {
        List<Hotel> listaResultado = new ArrayList<>();

        String sql = "SELECT * FROM hotel WHERE"
                + " (nome_hotel = ?"
                + " OR data_entrada = ?"
                + " OR data_saida = ?"
                + " OR preco = ?"
                + " OR quantidade_quartos = ?"
                + " OR quantidade_hospedes = ?)"
                + " AND ativo = true";

        connection = DbUtil.getConnection();

        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, busca);
        preparedStatement.setString(2, busca);
        preparedStatement.setString(3, busca);
        double n1 = 0;
        try {
            Double.parseDouble(busca);
        } catch (NumberFormatException e) {
            System.out.println("Erro");
        }
        int n2 = 0;
        try {
            n2 = Integer.parseInt(busca);
        } catch (NumberFormatException e) {
            System.out.println("Erro");
        }
        int n3 = 0;
        try {
            n3 = Integer.parseInt(busca);
        } catch (NumberFormatException e) {
            System.out.println("Erro");
        }
        preparedStatement.setDouble(4, n1);
        preparedStatement.setInt(5, n2);
        preparedStatement.setInt(6, n3);

        try (ResultSet result = preparedStatement.executeQuery()) {

            while (result.next()) {

                Hotel hoteis = new Hotel();

                hoteis.setId(result.getInt("id_hotel"));
                hoteis.setData_entrada(result.getString("data_entrada"));
                hoteis.setData_saida(result.getString("data_saida"));
                hoteis.setQuantidade_hospedes(result.getInt("quantidade_hospedes"));
                hoteis.setQuantidade_quartos(result.getInt("quantidade_quartos"));
                hoteis.setPreco(result.getFloat("preco"));
                hoteis.setNome(result.getString("nome_hotel"));

                listaResultado.add(hoteis);
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
