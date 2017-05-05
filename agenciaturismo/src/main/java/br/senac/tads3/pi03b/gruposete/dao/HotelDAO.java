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

        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO Hotel (nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes) "
                + "VALUES (?, ?, ?, ?, ?)";
        //Cria um statement para execução de instruções SQL

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            stmn.setString(1, hotel.getNome_hotel());
            stmn.setString(2, hotel.getData_entrada());
            stmn.setString(3, hotel.getData_saida());
            stmn.setString(4, hotel.getQuantidade_quartos());
            stmn.setString(5, hotel.getQuantidade_hospedes());
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

    public void alterar(Hotel hotel) throws SQLException, Exception {

        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE Hotel SET nome_hotel=?, data_entrada=?, data_saida=?, quantidade_quartos=?, quantidade_hospedes=? "
                + "WHERE id_hotel=?";
        //Cria um statement para execução de instruções SQL

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            stmn.setString(1, hotel.getNome_hotel());
            stmn.setString(2, hotel.getData_entrada());
            stmn.setString(3, hotel.getData_saida());
            stmn.setString(4, hotel.getQuantidade_quartos());
            stmn.setString(5, hotel.getQuantidade_hospedes());
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
        String sql = "DELETE FROM Hotel WHERE id_hotel=?";
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

    public List<Hotel> ListaHotel() throws SQLException, ClassNotFoundException {
        List<Hotel> ListaHotel = new ArrayList<>();
        con = DbUtil.getConnection();
        String query = "SELECT * FROM Hotel ORDER BY nome_hotel";

        try {
            Statement st = con.createStatement();
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
        con.close();
        return ListaHotel;
    }
    
    public Hotel getHotelById(int id) throws SQLException, ClassNotFoundException {
        Hotel hotel = new Hotel();
        con = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM Hotel WHERE id_hotel=?";
            stmn = con.prepareStatement(query);
            stmn.setInt(1, id);
            try (ResultSet resultSet = stmn.executeQuery()) {
                while (resultSet.next()) {
                    hotel.setNome_hotel(resultSet.getString("nome_hotel"));
                    hotel.setData_entrada(resultSet.getString("data_entrada"));
                    hotel.setData_saida(resultSet.getString("data_saida"));
                    hotel.setQuantidade_hospedes(resultSet.getString("quantidade_hospedes"));
                    hotel.setQuantidade_quartos(resultSet.getString("quantidade_quartos"));
                }
            }
            stmn.close();
        } catch (SQLException e) {
        }
        con.close();
        return hotel;
    }
}
