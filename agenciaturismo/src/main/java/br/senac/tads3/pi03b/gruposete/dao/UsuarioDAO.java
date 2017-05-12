package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Usuario;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

    public void inserir(Usuario usuario) throws SQLException, Exception {

        String sql = "INSERT INTO Usuario (nome, login senha, acesso) "
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
                + "SET nome=?, login=?, senha=?, acesso=? "
                + "WHERE id_usuario=?";

        try {
            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getAcesso());
            preparedStatement.setInt(5, usuario.getId_usuario());

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
        }
        connection.close();
        return listaUsuario;
    }

}
