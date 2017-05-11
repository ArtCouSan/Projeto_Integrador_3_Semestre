package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.models.Funcionario;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

    public void inserir(Funcionario funcionario) throws SQLException, Exception {

        String sql = "INSERT INTO Funcionario (nome, cpf, sexo, data_nasc, numero, cep, rua, bairro, cidade, logradouro, complemento, celular, telefone, email, cargo, filial, departamento, ativo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getCpf());
            preparedStatement.setString(3, funcionario.getSexo());
            preparedStatement.setString(4, funcionario.getData_nasc());
            preparedStatement.setInt(5, funcionario.getNumero());
            preparedStatement.setString(6, funcionario.getCep());
            preparedStatement.setString(7, funcionario.getRua());
            preparedStatement.setString(8, funcionario.getBairro());
            preparedStatement.setString(9, funcionario.getCidade());
            preparedStatement.setString(10, funcionario.getLogradouro());
            preparedStatement.setString(11, funcionario.getComplemento());
            preparedStatement.setString(12, funcionario.getCelular());
            preparedStatement.setString(13, funcionario.getTelefone());
            preparedStatement.setString(14, funcionario.getEmail());
            preparedStatement.setString(15, funcionario.getCargo());
            preparedStatement.setString(16, funcionario.getFilial());
            preparedStatement.setString(17, funcionario.getDepartamento());
            preparedStatement.setBoolean(18, true);

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

    public void alterar(Funcionario funcionario) throws SQLException, Exception {

        String sql = "UPDATE Funcionario "
                + "SET nome=?, cpf=?, sexo=?, data_nasc=?, numero=?, cep=?, rua=?, bairro=?, cidade=?, logradouro=?, complemento=?, celular=?, telefone=?, email=?, cargo=?, filial=?, departamento=?, ativo=? "
                + "WHERE id_func=?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getCpf());
            preparedStatement.setString(3, funcionario.getSexo());
            preparedStatement.setString(4, funcionario.getData_nasc());
            preparedStatement.setInt(5, funcionario.getNumero());
            preparedStatement.setString(6, funcionario.getCep());
            preparedStatement.setString(7, funcionario.getRua());
            preparedStatement.setString(8, funcionario.getBairro());
            preparedStatement.setString(9, funcionario.getCidade());
            preparedStatement.setString(10, funcionario.getLogradouro());
            preparedStatement.setString(11, funcionario.getComplemento());
            preparedStatement.setString(12, funcionario.getCelular());
            preparedStatement.setString(13, funcionario.getTelefone());
            preparedStatement.setString(14, funcionario.getEmail());
            preparedStatement.setString(15, funcionario.getCargo());
            preparedStatement.setString(16, funcionario.getFilial());
            preparedStatement.setString(17, funcionario.getDepartamento());
            preparedStatement.setBoolean(18, funcionario.isAtivo());
            preparedStatement.setInt(19, funcionario.getId_func());

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

    public List<Funcionario> ListaFuncionario() throws SQLException, ClassNotFoundException {
        List<Funcionario> listaFuncionario = new ArrayList<>();

        connection = DbUtil.getConnection();

        String query = "SELECT * FROM Cliente ORDER BY nome WHERE ativo=true";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Funcionario func = new Funcionario();

                func.setId_func(resultSet.getInt("id_func"));
                func.setNome(resultSet.getString("nome"));
                func.setCpf(resultSet.getString("cpf"));
                func.setSexo(resultSet.getString("sexo"));
                func.setData_nasc(resultSet.getString("data_nasc"));
                func.setNumero(resultSet.getInt("numero"));
                func.setCep(resultSet.getString("cep"));
                func.setRua(resultSet.getString("rua"));
                func.setBairro(resultSet.getString("bairro"));
                func.setCidade(resultSet.getString("cidade"));
                func.setLogradouro(resultSet.getString("logradouro"));
                func.setComplemento(resultSet.getString("complemento"));
                func.setCelular(resultSet.getString("celular"));
                func.setTelefone(resultSet.getString("telefone"));
                func.setEmail(resultSet.getString("email"));
                func.setCargo(resultSet.getString("cargo"));
                func.setFilial(resultSet.getString("filial"));
                func.setDepartamento(resultSet.getString("departamento"));

                listaFuncionario.add(func);
            }
        } catch (SQLException e) {
        }
        connection.close();
        return listaFuncionario;
    }

    public Funcionario getFuncionarioById(int id) throws SQLException, ClassNotFoundException {
        Funcionario func = new Funcionario();

        connection = DbUtil.getConnection();

        String query = "SELECT * FROM Funcionario WHERE id_func=?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                func.setId_func(resultSet.getInt("id_func"));
                func.setNome(resultSet.getString("nome"));
                func.setCpf(resultSet.getString("cpf"));
                func.setSexo(resultSet.getString("sexo"));
                func.setData_nasc(resultSet.getString("data_nasc"));
                func.setNumero(resultSet.getInt("numero"));
                func.setCep(resultSet.getString("cep"));
                func.setRua(resultSet.getString("rua"));
                func.setBairro(resultSet.getString("bairro"));
                func.setCidade(resultSet.getString("cidade"));
                func.setLogradouro(resultSet.getString("logradouro"));
                func.setComplemento(resultSet.getString("complemento"));
                func.setCelular(resultSet.getString("celular"));
                func.setTelefone(resultSet.getString("telefone"));
                func.setEmail(resultSet.getString("email"));
                func.setCargo(resultSet.getString("cargo"));
                func.setFilial(resultSet.getString("filial"));
                func.setDepartamento(resultSet.getString("departamento"));
            }

        } catch (SQLException e) {
        }

        preparedStatement.close();
        connection.close();
        return func;
    }

    public List<Funcionario> procurarFuncionario(Funcionario funcionario) throws SQLException, IOException, ClassNotFoundException {

        // Cria lista de clientes.
        List<Funcionario> listaResultado = new ArrayList<>();

        connection = DbUtil.getConnection();

        String sql = "SELECT * FROM funcionario WHERE"
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
                + " OR cidade = ?"
                + " OR cargo = ?"
                + " OR filial = ?"
                + " OR departamento = ?";

        preparedStatement = connection.prepareStatement(sql);

        // Insercoes.
        preparedStatement.setString(1, funcionario.getBairro());
        preparedStatement.setString(2, funcionario.getCelular());
        preparedStatement.setString(3, funcionario.getCep());
        preparedStatement.setString(4, funcionario.getComplemento());
        preparedStatement.setString(5, funcionario.getCpf());
        preparedStatement.setString(6, funcionario.getData_nasc());
        preparedStatement.setString(7, funcionario.getEmail());
        preparedStatement.setString(8, funcionario.getLogradouro());
        preparedStatement.setString(9, funcionario.getNome());
        preparedStatement.setInt(10, funcionario.getNumero());
        preparedStatement.setString(11, funcionario.getRua());
        preparedStatement.setString(12, funcionario.getSexo());
        preparedStatement.setString(13, funcionario.getTelefone());
        preparedStatement.setString(14, funcionario.getCidade());
        preparedStatement.setString(15, funcionario.getCargo());
        preparedStatement.setString(16, funcionario.getFilial());
        preparedStatement.setString(17, funcionario.getDepartamento());
        
        // Recebe e executa pergunta.
        try (ResultSet result = preparedStatement.executeQuery()) {

            // Loop com resultados.
            while (result.next()) {

                // Cria cliente.
                Funcionario funcionarios = new Funcionario();

                // Insere informacoes.
                funcionarios.setId_func(result.getInt("id_func"));
                funcionarios.setBairro(result.getString("bairro"));
                funcionarios.setCelular(result.getString("celular"));
                funcionarios.setCep(result.getString("cep"));
                funcionarios.setComplemento(result.getString("complemento"));
                funcionarios.setCpf(result.getString("cpf"));
                funcionarios.setData_nasc(result.getString("data_nasc"));
                funcionarios.setEmail(result.getString("email"));
                funcionarios.setLogradouro(result.getString("logradouro"));
                funcionarios.setNome(result.getString("nome"));
                funcionarios.setNumero(result.getInt("numero"));
                funcionarios.setRua(result.getString("rua"));
                funcionarios.setSexo(result.getString("sexo"));
                funcionarios.setTelefone(result.getString("telefone"));
                funcionarios.setCidade(result.getString("cidade"));
                funcionarios.setCargo(result.getString("cargo"));
                funcionarios.setFilial(result.getString("filial"));
                funcionarios.setDepartamento(result.getString("departamento"));
 
                // Insere na lista.
                listaResultado.add(funcionarios);

            }

            // Retorna lista.
            return listaResultado;

        }

    }

}
