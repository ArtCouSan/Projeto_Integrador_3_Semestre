package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Funcionario;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

    public void inserir(Funcionario funcionario) throws SQLException, Exception {
        String sql = "INSERT INTO Funcionario (nome, cpf, sexo, data_nasc, numero, "
                + "cep, rua, estado, cidade, complemento, celular, telefone, email, "
                + "cargo, filial, departamento, ativo, login, senha, acesso) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            preparedStatement.setString(8, funcionario.getEstado());
            preparedStatement.setString(9, funcionario.getCidade());
            preparedStatement.setString(10, funcionario.getComplemento());
            preparedStatement.setString(11, funcionario.getCelular());
            preparedStatement.setString(12, funcionario.getTelefone());
            preparedStatement.setString(13, funcionario.getEmail());
            preparedStatement.setString(14, funcionario.getCargo());
            preparedStatement.setString(15, funcionario.getFilial());
            preparedStatement.setString(16, funcionario.getDepartamento());
            preparedStatement.setBoolean(17, true);
            preparedStatement.setString(18, funcionario.getLogin());
            preparedStatement.setString(19, funcionario.getSenha());
            preparedStatement.setString(20, funcionario.getAcesso());

            preparedStatement.executeUpdate();

        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public void alterar(Funcionario func) throws SQLException, Exception {
        String sql = "UPDATE funcionario "
                + "SET nome = ?, "
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
                + "email = ?, "
                + "cargo = ?, "
                + "filial = ?, "
                + "departamento = ?, "
                + "senha = ?, "
                + "acesso = ? "
                + "WHERE cpf = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, func.getNome());

            preparedStatement.setString(2, func.getSexo());
            preparedStatement.setString(3, func.getData_nasc());
            preparedStatement.setInt(4, func.getNumero());
            preparedStatement.setString(5, func.getCep());
            preparedStatement.setString(6, func.getRua());
            preparedStatement.setString(7, func.getEstado());
            preparedStatement.setString(8, func.getCidade());
            preparedStatement.setString(9, func.getComplemento());
            preparedStatement.setString(10, func.getCelular());
            preparedStatement.setString(11, func.getTelefone());
            preparedStatement.setString(12, func.getEmail());
            preparedStatement.setString(13, func.getCargo());
            preparedStatement.setString(14, func.getFilial());
            preparedStatement.setString(15, func.getDepartamento());
            preparedStatement.setString(16, func.getSenha());
            preparedStatement.setString(17, func.getAcesso());
            preparedStatement.setString(18, func.getCpf());

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

    public Funcionario getFuncionarioById(int id) throws SQLException, ClassNotFoundException {

        Funcionario func = new Funcionario();

        String query = "SELECT * FROM funcionario WHERE id_funcionario = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                func.setCpf(resultSet.getString("cpf"));
                func.setNome(resultSet.getString("nome"));
                func.setSexo(resultSet.getString("sexo"));
                func.setData_nasc(resultSet.getString("data_nasc"));
                func.setNumero(resultSet.getInt("numero"));
                func.setCep(resultSet.getString("cep"));
                func.setRua(resultSet.getString("rua"));
                func.setEstado(resultSet.getString("estado"));
                func.setCidade(resultSet.getString("cidade"));
                func.setComplemento(resultSet.getString("complemento"));
                func.setCelular(resultSet.getString("celular"));
                func.setTelefone(resultSet.getString("telefone"));
                func.setEmail(resultSet.getString("email"));
                func.setCargo(resultSet.getString("cargo"));
                func.setFilial(resultSet.getString("filial"));
                func.setDepartamento(resultSet.getString("departamento"));
                func.setLogin(resultSet.getString("login"));

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

        return func;

    }

    public List<Funcionario> ListaFuncionario() throws SQLException, ClassNotFoundException {
        List<Funcionario> listaFuncionario = new ArrayList<>();

        connection = DbUtil.getConnection();

        String query = "SELECT * FROM Funcionario ORDER BY nome WHERE ativo = true";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                Funcionario func = new Funcionario();

                func.setCpf(resultSet.getString("cpf"));
                func.setNome(resultSet.getString("nome"));
                func.setSexo(resultSet.getString("sexo"));
                func.setData_nasc(resultSet.getString("data_nasc"));
                func.setNumero(resultSet.getInt("numero"));
                func.setCep(resultSet.getString("cep"));
                func.setRua(resultSet.getString("rua"));
                func.setEstado(resultSet.getString("estado"));
                func.setCidade(resultSet.getString("cidade"));
                func.setComplemento(resultSet.getString("complemento"));
                func.setCelular(resultSet.getString("celular"));
                func.setTelefone(resultSet.getString("telefone"));
                func.setEmail(resultSet.getString("email"));
                func.setCargo(resultSet.getString("cargo"));
                func.setFilial(resultSet.getString("filial"));
                func.setDepartamento(resultSet.getString("departamento"));
                func.setLogin(resultSet.getString("login"));

                listaFuncionario.add(func);
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
        return listaFuncionario;
    }

    public Funcionario getFuncionarioByCPF(String cpf) throws SQLException, ClassNotFoundException {
        Funcionario func = new Funcionario();

        String query = "SELECT * FROM Funcionario WHERE id_func = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                func.setNome(resultSet.getString("nome"));
                func.setCpf(resultSet.getString("cpf"));
                func.setSexo(resultSet.getString("sexo"));
                func.setData_nasc(resultSet.getString("data_nasc"));
                func.setNumero(resultSet.getInt("numero"));
                func.setCep(resultSet.getString("cep"));
                func.setRua(resultSet.getString("rua"));
                func.setEstado(resultSet.getString("estado"));
                func.setCidade(resultSet.getString("cidade"));
                func.setComplemento(resultSet.getString("complemento"));
                func.setCelular(resultSet.getString("celular"));
                func.setTelefone(resultSet.getString("telefone"));
                func.setEmail(resultSet.getString("email"));
                func.setCargo(resultSet.getString("cargo"));
                func.setFilial(resultSet.getString("filial"));
                func.setDepartamento(resultSet.getString("departamento"));
                func.setLogin(resultSet.getString("login"));
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

        return func;
    }

    public List<Funcionario> procurarFuncionario(String busca) throws SQLException, ClassNotFoundException {
        // Cria lista de clientes.
        List<Funcionario> listaResultado = new ArrayList<>();

        connection = DbUtil.getConnection();

        String sql;

        System.out.println(">>>>>>>>>" + busca.length());

        if (busca.length() != 0) {

            System.out.println("hsauiahsoahsashioa");
            System.out.println(busca);
            
            
            sql = "SELECT * FROM funcionario WHERE"
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
                    + " OR cidade = ?"
                    + " OR cargo = ?"
                    + " OR filial = ?"
                    + " OR departamento = ?"
                    + " OR login = ?"
                    + " OR acesso = ?)"
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
            preparedStatement.setString(9, busca);

            int n1 = 0;
            try {
                n1 = Integer.parseInt(busca);
            } catch (NumberFormatException e) {

            }
            preparedStatement.setInt(10, n1);
            preparedStatement.setString(11, busca);
            preparedStatement.setString(12, busca);
            preparedStatement.setString(13, busca);
            preparedStatement.setString(14, busca);
            preparedStatement.setString(15, busca);
            preparedStatement.setString(16, busca);
            preparedStatement.setString(17, busca);
            preparedStatement.setString(18, busca);

        } else {

            sql = "SELECT * FROM funcionario WHERE ativo = true";

            preparedStatement = connection.prepareStatement(sql);

        }

        // Recebe e executa pergunta.
        try (ResultSet result = preparedStatement.executeQuery()) {

            // Loop com resultados.
            while (result.next()) {

                // Cria cliente.
                Funcionario func = new Funcionario();

                // Insere informacoes.
                func.setEstado(result.getString("estado"));
                func.setCelular(result.getString("celular"));
                func.setCep(result.getString("cep"));
                func.setComplemento(result.getString("complemento"));
                func.setCpf(result.getString("cpf"));
                func.setData_nasc(result.getString("data_nasc"));
                func.setEmail(result.getString("email"));
                func.setNome(result.getString("nome"));
                func.setNumero(result.getInt("numero"));
                func.setRua(result.getString("rua"));
                func.setSexo(result.getString("sexo"));
                func.setTelefone(result.getString("telefone"));
                func.setCidade(result.getString("cidade"));
                func.setCargo(result.getString("cargo"));
                func.setFilial(result.getString("filial"));
                func.setDepartamento(result.getString("departamento"));
                func.setLogin(result.getString("login"));

                // Insere na lista.
                listaResultado.add(func);
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

    public void excluir(String cpf) throws SQLException, ClassNotFoundException {
        // Comando SQL.
        String slq = "UPDATE funcionario SET ativo = ? WHERE cpf = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(slq);
            // Insercoes.
            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, cpf);

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

        connection = DbUtil.getConnection();

        // Comando SQL.
        String slq = "SELECT COUNT(*) FROM funcionario WHERE cpf = ?";

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

        if (numeroDeCounts < 1) {
            return true;
        }
        return false;
    }

    public Funcionario obterFuncionario(String userLogin, String passwordLogin) throws SQLException {
        Funcionario func = new Funcionario();

        String query = "SELECT * FROM Funcionario WHERE login = ? AND senha = ? AND ativo = true";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userLogin);
            preparedStatement.setString(2, passwordLogin);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String nome = resultSet.getString("nome");
                String filial = resultSet.getString("filial");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String acesso = resultSet.getString("acesso");
                String cpf = resultSet.getString("cpf");
                int id_func = resultSet.getInt("id_funcionario");

                func.setId_func(id_func);
                func.setFilial(filial);
                func.setNome(nome);
                func.setLogin(login);
                func.setSenha(senha);
                func.setAcesso(acesso);
                func.setCpf(cpf);
                break;
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>ERRO NA HORA DE BUSCAR O USUARIO NO BANCO: " + e);
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return func;
    }
}
