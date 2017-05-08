package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static Connection con;
    private static PreparedStatement stmn;

    public void inserir(Cliente cliente) throws SQLException, Exception {

        String sql = "INSERT INTO Cliente (nome, cpf, sexo, data_nasc, numero, cep, rua, bairro, cidade, logradouro, complemento, celular, telefone, email, ativo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);

            stmn.setString(1, cliente.getNome());
            stmn.setString(2, cliente.getCpf());
            stmn.setString(3, cliente.getSexo());
            stmn.setString(4, cliente.getData_nasc());
            stmn.setInt(5, cliente.getNumero());
            stmn.setString(6, cliente.getCep());
            stmn.setString(7, cliente.getRua());
            stmn.setString(8, cliente.getBairro());
            stmn.setString(9, cliente.getCidade());
            stmn.setString(10, cliente.getLogradouro());
            stmn.setString(11, cliente.getComplemento());
            stmn.setString(12, cliente.getCelular());
            stmn.setString(13, cliente.getTelefone());
            stmn.setString(14, cliente.getEmail());
            stmn.setBoolean(15, true);

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

    public void alterar(Cliente cliente) throws SQLException, Exception {

        String sql = "UPDATE Cliente "
                + "SET nome=?, cpf=?, sexo=?, data_nasc=?, numero=?, cep=?, rua=?, bairro=?, cidade=?, logradouro=?, complemento=?, celular=?, telefone=?, email=?, ativo=? "
                + "WHERE id_cliente=?";

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);

            stmn.setString(1, cliente.getNome());
            stmn.setString(2, cliente.getCpf());
            stmn.setString(3, cliente.getSexo());
            stmn.setString(4, cliente.getData_nasc());
            stmn.setInt(5, cliente.getNumero());
            stmn.setString(6, cliente.getCep());
            stmn.setString(7, cliente.getRua());
            stmn.setString(8, cliente.getBairro());
            stmn.setString(9, cliente.getCidade());
            stmn.setString(10, cliente.getLogradouro());
            stmn.setString(11, cliente.getComplemento());
            stmn.setString(12, cliente.getCelular());
            stmn.setString(13, cliente.getTelefone());
            stmn.setString(14, cliente.getEmail());
            stmn.setBoolean(15, cliente.isAtivo());
            stmn.setInt(16, cliente.getId_cliente());

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

    public List<Cliente> ListaCliente() throws SQLException, ClassNotFoundException {
        List<Cliente> listaClientes = new ArrayList<>();

        con = DbUtil.getConnection();

        String query = "SELECT * FROM Cliente ORDER BY nome WHERE ativo=true";

        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Cliente cliente = new Cliente();

                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setSexo(resultSet.getString("sexo"));
                cliente.setData_nasc(resultSet.getString("data_nasc"));
                cliente.setNumero(resultSet.getInt("numero"));
                cliente.setCep(resultSet.getString("cep"));
                cliente.setRua(resultSet.getString("rua"));
                cliente.setBairro(resultSet.getString("bairro"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setLogradouro(resultSet.getString("logradouro"));
                cliente.setComplemento(resultSet.getString("complemento"));
                cliente.setCelular(resultSet.getString("celular"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEmail(resultSet.getString("email"));

                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
        }
        con.close();
        return listaClientes;
    }

    public Cliente clientePorNome(String nome) throws SQLException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        con = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM Cliente WHERE nome=?";
            stmn = con.prepareStatement(query);
            stmn.setString(1, nome);
            try (ResultSet resultSet = stmn.executeQuery()) {
                while (resultSet.next()) {
                    cliente.setId_cliente(resultSet.getInt("id_cliente"));
                    cliente.setNome(resultSet.getString("nome"));
                    cliente.setCpf(resultSet.getString("cpf"));
                    cliente.setSexo(resultSet.getString("sexo"));
                    cliente.setData_nasc(resultSet.getString("data_nasc"));
                    cliente.setNumero(resultSet.getInt("numero"));
                    cliente.setCep(resultSet.getString("cep"));
                    cliente.setRua(resultSet.getString("rua"));
                    cliente.setBairro(resultSet.getString("bairro"));
                    cliente.setCidade(resultSet.getString("cidade"));
                    cliente.setLogradouro(resultSet.getString("logradouro"));
                    cliente.setComplemento(resultSet.getString("complemento"));
                    cliente.setCelular(resultSet.getString("celular"));
                    cliente.setTelefone(resultSet.getString("telefone"));
                    cliente.setEmail(resultSet.getString("email"));
                }
            }
            stmn.close();
        } catch (SQLException e) {
        }
        con.close();
        return cliente;
    }
}
