package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Usuario;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private static Connection con;
    private static PreparedStatement stmn;

    public void inserir(Usuario usuario) throws SQLException, Exception {

        String sql = "INSERT INTO Usuario (nome, login, senha, acesso) "
                + "VALUES (?, ?, ?, ?)";

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);

            stmn.setString(1, usuario.getNome());
            stmn.setString(2, usuario.getLogin());
            stmn.setString(3, usuario.getSenha());
            stmn.setString(4, usuario.getAcesso());

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

    public void alterar(Usuario usuario) throws SQLException, Exception {

        String sql = "UPDATE Usuario "
                + "SET nome=?, login=?, senha=?, acesso=? "
                + "WHERE id_usuario=?";

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);

            stmn.setString(1, usuario.getNome());
            stmn.setString(2, usuario.getLogin());
            stmn.setString(3, usuario.getSenha());
            stmn.setString(4, usuario.getAcesso());
            stmn.setInt(5, usuario.getId_usuario());

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

    public void excluir(int id) throws SQLException, Exception {

        String sql = "DELETE FROM Usuario WHERE id_usuario=?";

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);

            stmn.setInt(1, id);

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

    public List<Usuario> ListaUsuario() throws SQLException, ClassNotFoundException {
        List<Usuario> listaUsuario = new ArrayList<>();

        con = DbUtil.getConnection();

        String query = "SELECT * FROM Usuario ORDER BY nome";

        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);
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
        con.close();
        return listaUsuario;
    }

}
