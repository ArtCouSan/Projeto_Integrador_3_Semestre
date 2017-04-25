package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection connection;

    public void inserir(Cliente cliente) throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO clientes (nome, cpf, sexo, data_dasc, numero, cep, rua, bairro, "
                + "logradouro, complemento, celular, telefone, email, dd_telefone, dd_celular, ativo)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, Character.toString(cliente.getSexo()));
            preparedStatement.setDate(4, (Date) cliente.getData_nasc());
            preparedStatement.setInt(5, cliente.getNumero());
            preparedStatement.setString(6, cliente.getCep());
            preparedStatement.setString(7, cliente.getRua());
            preparedStatement.setString(8, cliente.getBairro());
            preparedStatement.setString(9, cliente.getLogradouro());
            preparedStatement.setString(10, cliente.getComplemento());
            preparedStatement.setString(11, cliente.getCelular());
            preparedStatement.setString(12, cliente.getTelefone());
            preparedStatement.setString(13, cliente.getEmail());
            preparedStatement.setString(14, cliente.getDd_telefone());
            preparedStatement.setString(15, cliente.getDd_celular());
            preparedStatement.setBoolean(16, cliente.isAtivo());
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

    public void alterar(Cliente cliente) throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE clientes SET nome=?, cpf=?, sexo=?, data_nasc=?, numero=?, cep=?, rua=?"
                + "WHERE id=?";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, Character.toString(cliente.getSexo()));
            preparedStatement.setDate(4, (Date) cliente.getData_nasc());
            preparedStatement.setInt(5, cliente.getNumero());
            preparedStatement.setString(6, cliente.getCep());
            preparedStatement.setString(7, cliente.getRua());
            preparedStatement.setString(8, cliente.getBairro());
            preparedStatement.setString(9, cliente.getLogradouro());
            preparedStatement.setString(10, cliente.getComplemento());
            preparedStatement.setString(11, cliente.getCelular());
            preparedStatement.setString(12, cliente.getTelefone());
            preparedStatement.setString(13, cliente.getEmail());
            preparedStatement.setString(14, cliente.getDd_telefone());
            preparedStatement.setString(15, cliente.getDd_celular());
            preparedStatement.setBoolean(16, cliente.isAtivo());
            preparedStatement.setInt(17, cliente.getId_cliente());
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
        String sql = "DELETE FROM clientes WHERE id=?";
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

    public List<Cliente> getListaClientes() throws SQLException, ClassNotFoundException {
        List<Cliente> listaClientes = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM clientes ORDER BY nome";

        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setTipo(resultSet.getString("tipo"));
                cliente.setCadastroNacional(resultSet.getString("cadastronacional"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelefone(resultSet.getString("telefone"));
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
        try {
            String query = "SELECT * FROM clientes WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        cliente.setId(resultSet.getInt("id"));
                        cliente.setNome(resultSet.getString("nome"));
                        cliente.setTipo(resultSet.getString("tipo"));
                        cliente.setCadastroNacional(resultSet.getString("cadastronacional"));
                        cliente.setEndereco(resultSet.getString("endereco"));
                        cliente.setEmail(resultSet.getString("email"));
                        cliente.setTelefone(resultSet.getString("telefone"));
                    }
                }
            }
        } catch (SQLException e) {
        }
        connection.close();
        return cliente;
    }
}
