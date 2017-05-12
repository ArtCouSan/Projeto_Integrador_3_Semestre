package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

    public void inserir(Cliente cliente) throws SQLException, Exception {

        String sql = "INSERT INTO Cliente (nome, cpf, sexo, data_nasc, numero, cep, rua, bairro, cidade, logradouro, complemento, celular, telefone, email, ativo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getSexo());
            preparedStatement.setString(4, cliente.getData_nasc());
            preparedStatement.setInt(5, cliente.getNumero());
            preparedStatement.setString(6, cliente.getCep());
            preparedStatement.setString(7, cliente.getRua());
            preparedStatement.setString(8, cliente.getBairro());
            preparedStatement.setString(9, cliente.getCidade());
            preparedStatement.setString(10, cliente.getLogradouro());
            preparedStatement.setString(11, cliente.getComplemento());
            preparedStatement.setString(12, cliente.getCelular());
            preparedStatement.setString(13, cliente.getTelefone());
            preparedStatement.setString(14, cliente.getEmail());
            preparedStatement.setBoolean(15, true);

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

    public void alterar(Cliente cliente) throws SQLException, Exception {

        String sql = "UPDATE Cliente "
                + "SET nome=?, cpf=?, sexo=?, data_nasc=?, numero=?, cep=?, rua=?, bairro=?, cidade=?, logradouro=?, complemento=?, celular=?, telefone=?, email=?, ativo=? "
                + "WHERE id_cliente=?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getSexo());
            preparedStatement.setString(4, cliente.getData_nasc());
            preparedStatement.setInt(5, cliente.getNumero());
            preparedStatement.setString(6, cliente.getCep());
            preparedStatement.setString(7, cliente.getRua());
            preparedStatement.setString(8, cliente.getBairro());
            preparedStatement.setString(9, cliente.getCidade());
            preparedStatement.setString(10, cliente.getLogradouro());
            preparedStatement.setString(11, cliente.getComplemento());
            preparedStatement.setString(12, cliente.getCelular());
            preparedStatement.setString(13, cliente.getTelefone());
            preparedStatement.setString(14, cliente.getEmail());
            preparedStatement.setBoolean(15, cliente.isAtivo());
            preparedStatement.setInt(16, cliente.getId_cliente());

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

    public List<Cliente> ListaCliente() throws SQLException, ClassNotFoundException {
        List<Cliente> listaClientes = new ArrayList<>();

        connection = DbUtil.getConnection();

        String query = "SELECT * FROM Cliente ORDER BY nome WHERE ativo=true";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
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
        connection.close();
        return listaClientes;
    }

    public Cliente getClienteById(int id) throws SQLException, ClassNotFoundException {
        Cliente cliente = new Cliente();

        connection = DbUtil.getConnection();

        String query = "SELECT * FROM Cliente WHERE id_cliente=?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

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

        } catch (SQLException e) {
        }

        preparedStatement.close();
        connection.close();
        return cliente;
    }

    public List<Cliente> procurarCliente(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {

        // Cria lista de clientes.
        List<Cliente> listaResultado = new ArrayList<>();

        connection = DbUtil.getConnection();

        String sql = "SELECT * FROM cliente WHERE"
                + " bairro = ?"
                + " OR celular = ?"
                + " OR cep = ?"
                + " OR complemento = ?"
                + " OR cpf = ?"
                + " OR data_nasc = ?"
                + " OR email = ?"
                + " OR logradouro = ?"
                + " OR nome = ?"
                + " OR numero = ?"
                + " OR rua = ?"
                + " OR sexo = ?"
                + " OR telefone = ?"
                + " OR cidade = ?";

        preparedStatement = connection.prepareStatement(sql);

        // Insercoes.
        preparedStatement.setString(1, cliente.getBairro());
        preparedStatement.setString(2, cliente.getCelular());
        preparedStatement.setString(3, cliente.getCep());
        preparedStatement.setString(4, cliente.getComplemento());
        preparedStatement.setString(5, cliente.getCpf());
        preparedStatement.setString(6, cliente.getData_nasc());
        preparedStatement.setString(7, cliente.getEmail());
        preparedStatement.setString(8, cliente.getLogradouro());
        preparedStatement.setString(9, cliente.getNome());
        preparedStatement.setInt(10, cliente.getNumero());
        preparedStatement.setString(11, cliente.getRua());
        preparedStatement.setString(12, cliente.getSexo());
        preparedStatement.setString(13, cliente.getTelefone());
        preparedStatement.setString(14, cliente.getCidade());

        // Recebe e executa pergunta.
        try (ResultSet result = preparedStatement.executeQuery()) {

            // Loop com resultados.
            while (result.next()) {

                // Cria cliente.
                Cliente clientes = new Cliente();

                // Insere informacoes.
                clientes.setId_cliente(result.getInt("id_cliente"));
                clientes.setBairro(result.getString("bairro"));
                clientes.setCelular(result.getString("celular"));
                clientes.setCep(result.getString("cep"));
                clientes.setComplemento(result.getString("complemento"));
                clientes.setCpf(result.getString("cpf"));
                clientes.setData_nasc(result.getString("data_nasc"));
                clientes.setEmail(result.getString("email"));
                clientes.setLogradouro(result.getString("logradouro"));
                clientes.setNome(result.getString("nome"));
                clientes.setNumero(result.getInt("numero"));
                clientes.setRua(result.getString("rua"));
                clientes.setSexo(result.getString("sexo"));
                clientes.setTelefone(result.getString("telefone"));
                clientes.setCidade(result.getString("cidade"));

                // Insere na lista.
                listaResultado.add(clientes);

            }

            // Retorna lista.
            return listaResultado;

        }

    }

}
