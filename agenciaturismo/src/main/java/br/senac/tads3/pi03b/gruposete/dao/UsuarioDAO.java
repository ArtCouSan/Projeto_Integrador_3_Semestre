package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Usuario;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

    public void inserir(Usuario usuario) throws SQLException, Exception {
        String sql = "INSERT INTO Usuario (nome, login, senha, acesso) "
                + "VALUES (?, ?, ?, ?)";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getAcesso());

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
    
    public void alterar(Usuario usuario) throws SQLException, Exception {

        String sql = "UPDATE Usuario "
                + "SET senha=? "
                + "WHERE id_usuario=?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getSenha());
            preparedStatement.setInt(2, usuario.getId_usuario());

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

    public void excluir(int id) throws SQLException, Exception {
        String sql = "DELETE FROM Usuario WHERE id_usuario=?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

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
    
    public Usuario getUsuarioById(int id) throws SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario();

        String query = "SELECT * FROM usuario WHERE id_usuario = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                usuario.setId_usuario(resultSet.getInt("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setAcesso(resultSet.getString("acesso"));
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
        return usuario;
    }

    public List<Usuario> ListaUsuario() throws SQLException, ClassNotFoundException {
        List<Usuario> listaUsuario = new ArrayList<>();

        connection = DbUtil.getConnection();

        String query = "SELECT * FROM Usuario ORDER BY nome";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Usuario usuario = new Usuario();

                usuario.setId_usuario(resultSet.getInt("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setLogin(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setAcesso(resultSet.getString("acesso"));

                listaUsuario.add(usuario);
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
        return listaUsuario;
    }

    public List<Usuario> procurarUsuario(String busca) throws SQLException, ClassNotFoundException {
        // Cria lista de usuarios.
        List<Usuario> listaResultado = new ArrayList<>();

        String sql = "SELECT * FROM usuario WHERE bairro = ?";

        connection = DbUtil.getConnection();
        preparedStatement = connection.prepareStatement(sql);

        // Insercoes.
        preparedStatement.setString(1, busca);

        // Recebe e executa pergunta.
        try (ResultSet result = preparedStatement.executeQuery()) {

            // Loop com resultados.
            while (result.next()) {

                // Cria cliente.
                Usuario usuarios = new Usuario();

                // Insere informacoes.
                usuarios.setId_usuario(result.getInt("id_usuario"));
                usuarios.setNome(result.getString("nome"));
                usuarios.setLogin(result.getString("login"));
                usuarios.setAcesso(result.getString("acesso"));

                // Insere na lista.
                listaResultado.add(usuarios);
            }

            connection.close();
            preparedStatement.close();
            return listaResultado;
        }
    }

    public Usuario obterUsuario(String userLogin, String passwordLogin) throws SQLException {
        Usuario usuario = null;

        String query = "SELECT * FROM usuario WHERE login = ? AND senha = ?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userLogin);
            preparedStatement.setString(2, passwordLogin);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String acesso = resultSet.getString("acesso");

                usuario = new Usuario(nome, login, senha, acesso);
                break;
            }

        } catch (Exception e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>ERRO NA HORA DE BUSCAR O USUARIO NO BANCO: " + e);
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return usuario;
    }
}
