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

    private static Connection con;
    private static PreparedStatement stmn;

    public void inserir(Hotel hotel) throws SQLException, Exception {

        String sql = "INSERT INTO Hotel (nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes, preco, ativo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);

            stmn.setString(1, hotel.getNome_hotel());
            stmn.setString(2, hotel.getData_entrada());
            stmn.setString(3, hotel.getData_saida());
            stmn.setString(4, hotel.getQuantidade_quartos());
            stmn.setString(5, hotel.getQuantidade_hospedes());
            stmn.setDouble(6, hotel.getPreco());
            stmn.setBoolean(7, true);

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

    public void alterar(Hotel hotel) throws SQLException, Exception {

        String sql = "UPDATE Hotel "
                + "SET nome_hotel=?, data_entrada=?, data_saida=?, quantidade_quartos=?, quantidade_hospedes=?, preco=?, ativo=? "
                + "WHERE id_hotel=?";

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);

            stmn.setString(1, hotel.getNome_hotel());
            stmn.setString(2, hotel.getData_entrada());
            stmn.setString(3, hotel.getData_saida());
            stmn.setString(4, hotel.getQuantidade_quartos());
            stmn.setString(5, hotel.getQuantidade_hospedes());
            stmn.setDouble(6, hotel.getPreco());
            stmn.setBoolean(7, hotel.isAtivo());
            stmn.setInt(8, hotel.getId_hotel());

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

    public List<Hotel> ListaHotel() throws SQLException, ClassNotFoundException {
        List<Hotel> ListaHotel = new ArrayList<>();
        con = DbUtil.getConnection();
        String query = "SELECT * FROM Hotel ORDER BY nome_hotel WHERE ativo=true";

        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                
                hotel.setId_hotel(resultSet.getInt("id_hotel"));
                hotel.setNome_hotel(resultSet.getString("nome_hotel"));
                hotel.setData_entrada(resultSet.getString("data_entrada"));
                hotel.setData_saida(resultSet.getString("data_saida"));
                hotel.setQuantidade_quartos(resultSet.getString("quantidade_quartos"));
                hotel.setQuantidade_hospedes(resultSet.getString("quantidade_hospedes"));
                hotel.setPreco(resultSet.getDouble("preco"));
                
                ListaHotel.add(hotel);
            }
        } catch (SQLException e) {
        }
        con.close();
        return ListaHotel;
    }
}
