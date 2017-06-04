package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public void inserir(Cliente cliente) throws SQLException, Exception {
        String sql = "INSERT INTO Cliente (nome, cpf, sexo, data_nasc, numero, cep, rua, estado, cidade, complemento, celular, telefone, email, ativo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            preparedStatement.setString(8, cliente.getEstado());
            preparedStatement.setString(9, cliente.getCidade());
            preparedStatement.setString(10, cliente.getComplemento());
            preparedStatement.setString(11, cliente.getCelular());
            preparedStatement.setString(12, cliente.getTelefone());
            preparedStatement.setString(13, cliente.getEmail());
            preparedStatement.setBoolean(14, true);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
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

        String sql = "UPDATE cliente "
                + "SET "
                + "nome = ?, "
                + "cpf = ?, "
                + "sexo = ?, "
                + "data_nasc = ?, "
                + "numero = ?, "
                + "cep = ?, "
                + "rua = ?, "
                + "estado = ?, "
                + "cidade = ?, "
                + "complemento = ?, "
                + "celular = ?, "
                + "telefone = ?, "
                + "email = ? "
                + "WHERE id_cliente = ?";

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
            preparedStatement.setString(8, cliente.getEstado());
            preparedStatement.setString(9, cliente.getCidade());
            preparedStatement.setString(10, cliente.getComplemento());
            preparedStatement.setString(11, cliente.getCelular());
            preparedStatement.setString(12, cliente.getTelefone());
            preparedStatement.setString(13, cliente.getEmail());
            preparedStatement.setInt(14, cliente.getId_cliente());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
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

        String query = "SELECT * FROM Cliente ORDER BY nome WHERE ativo = true";

        try {

            Statement statement = connection.createStatement();

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
                cliente.setEstado(resultSet.getString("estado"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setComplemento(resultSet.getString("complemento"));
                cliente.setCelular(resultSet.getString("celular"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEmail(resultSet.getString("email"));

                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        return listaClientes;
    }

    public Cliente getClienteById(int id) throws SQLException, ClassNotFoundException {
        Cliente cliente = new Cliente();

        String query = "SELECT * FROM cliente WHERE id_cliente = ?";

        try {
            connection = DbUtil.getConnection();
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
                cliente.setEstado(resultSet.getString("estado"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setComplemento(resultSet.getString("complemento"));
                cliente.setCelular(resultSet.getString("celular"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return cliente;
    }

    public Cliente getClienteByCPF(String cpf) throws SQLException, ClassNotFoundException {

        Cliente cliente = new Cliente();

        connection = DbUtil.getConnection();

        String query = "SELECT * FROM cliente WHERE cpf  = ?";

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cpf);
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
            cliente.setEstado(resultSet.getString("estado"));
            cliente.setCidade(resultSet.getString("cidade"));
            cliente.setComplemento(resultSet.getString("complemento"));
            cliente.setCelular(resultSet.getString("celular"));
            cliente.setTelefone(resultSet.getString("telefone"));
            cliente.setEmail(resultSet.getString("email"));
        }

        preparedStatement.close();
        connection.close();
        return cliente;
    }

    public List<Cliente> procurarCliente(String busca) throws SQLException, ClassNotFoundException {

        // Cria lista de clientes.
        List<Cliente> listaResultado = new ArrayList<>();

        connection = DbUtil.getConnection();

        String sql;

        if (busca.length() != 0) {

            sql = "SELECT * FROM cliente WHERE"
                    + " (estado = ?"
                    + " OR celular = ?"
                    + " OR cep = ?"
                    + " OR complemento = ?"
                    + " OR cpf = ?"
                    + " OR data_nasc = ?"
                    + " OR email = ?"
                    + " OR nome = ?"
                    + " OR numero = ?"
                    + " OR rua = ?"
                    + " OR sexo = ?"
                    + " OR telefone = ?"
                    + " OR cidade = ?)"
                    + " AND ativo = true";

            preparedStatement = connection.prepareStatement(sql);

            // Insercoes.
            preparedStatement.setString(1, busca);
            preparedStatement.setString(2, busca);
            preparedStatement.setString(3, busca);
            preparedStatement.setString(4, busca);
            preparedStatement.setString(5, busca);
            preparedStatement.setString(6, busca);
            preparedStatement.setString(7, busca);
            preparedStatement.setString(8, busca);
            preparedStatement.setString(10, busca);

            int buscaN = 0;
            try {
                buscaN = Integer.parseInt(busca);
            } catch (NumberFormatException w) {
                System.out.println("Erro");
            }
            preparedStatement.setInt(9, buscaN);
            preparedStatement.setString(11, busca);
            preparedStatement.setString(12, busca);
            preparedStatement.setString(13, busca);

        } else {

            sql = "SELECT * FROM cliente WHERE ativo = true";

            preparedStatement = connection.prepareStatement(sql);

        }

        // Recebe e executa pergunta.
        try (ResultSet result = preparedStatement.executeQuery()) {

            // Loop com resultados.
            while (result.next()) {

                // Cria cliente.
                Cliente clientes = new Cliente();

                // Insere informacoes.
                clientes.setId_cliente(result.getInt("id_cliente"));
                clientes.setEstado(result.getString("estado"));
                clientes.setCelular(result.getString("celular"));
                clientes.setCep(result.getString("cep"));
                clientes.setComplemento(result.getString("complemento"));
                clientes.setCpf(result.getString("cpf"));
                clientes.setData_nasc(result.getString("data_nasc"));
                clientes.setEmail(result.getString("email"));
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
        // Comando SQL.
        String slq = "UPDATE cliente SET ativo = ? WHERE id_cliente = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(slq);
            // Insercoes.
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);
            // Executa.
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

    public boolean verificarCPF(String cpf) throws SQLException, ClassNotFoundException {

        // Comando SQL.
        String slq = "SELECT COUNT(*) FROM cliente WHERE cpf = ? AND ativo = true";

        connection = DbUtil.getConnection();
        preparedStatement = connection.prepareStatement(slq);

        // Insercoes.
        preparedStatement.setString(1, cpf);

        // Executa.
        resultSet = preparedStatement.executeQuery();

        int numeroDeCounts = 0;

        while (resultSet.next()) {

            numeroDeCounts = resultSet.getInt("COUNT(*)");

        }

        connection.close();

        System.out.println(numeroDeCounts);

        if (numeroDeCounts == 1) {
            return true;
        }
        return false;
    }
}
