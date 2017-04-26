package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Funcionario;
import br.senac.tads3.pi03b.gruposete.models.Pessoa;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private Connection connection;

    public void inserir(Funcionario funcionario) throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO Funcionario (pessoa, cargo, departamento, ativo) VALUES (?, ?, ?, ?)";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setObject(1, funcionario.getPessoa());
            preparedStatement.setString(2, funcionario.getCargo());
            preparedStatement.setString(3, funcionario.getDepartamento());
            preparedStatement.setBoolean(4, funcionario.isAtivo());
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

    public void alterar(Funcionario funcionario) throws SQLException, Exception {
        connection = DbUtil.getConnection();
        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE Funcionario SET pessoa=?, cargo=?, departamento=?, ativo=? WHERE id_cliente=?";
        //Cria um statement para execução de instruções SQL
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try {
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setObject(1, funcionario.getPessoa());
            preparedStatement.setString(2, funcionario.getCargo());
            preparedStatement.setString(3, funcionario.getDepartamento());
            preparedStatement.setBoolean(4, funcionario.isAtivo());
            preparedStatement.setInt(5, funcionario.getId_func());

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
        String sql = "DELETE FROM Funcionario WHERE id_func=?";
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

    public List<Funcionario> getListaFuncionario() throws SQLException, ClassNotFoundException {
        List<Funcionario> ListaFuncionario = new ArrayList<>();
        connection = DbUtil.getConnection();
        String query = "SELECT * FROM Funcionario ORDER BY nome";

        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId_func(resultSet.getInt("id_func"));
                funcionario.setAtivo(resultSet.getBoolean("ativo"));
                funcionario.setPessoa((Pessoa) resultSet.getObject("pessoa"));
                funcionario.setCargo(resultSet.getString("cargo"));
                funcionario.setDepartamento(resultSet.getString("departamento"));
                ListaFuncionario.add(funcionario);
            }
        } catch (SQLException e) {
        }
        connection.close();
        return ListaFuncionario;
    }

    public Funcionario getFuncionarioById(int id) throws SQLException, ClassNotFoundException {
        Funcionario funcionario = new Funcionario();
        connection = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM Funcionario WHERE id_func=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        funcionario.setId_func(resultSet.getInt("id_func"));
                        funcionario.setAtivo(resultSet.getBoolean("ativo"));
                        funcionario.setPessoa((Pessoa) resultSet.getObject("pessoa"));
                        funcionario.setCargo(resultSet.getString("cargo"));
                        funcionario.setDepartamento(resultSet.getString("departamento"));
                    }
                }
            }
        } catch (SQLException e) {
        }
        connection.close();
        return funcionario;
    }
}
