package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Funcionario;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private static Connection con;
    private static PreparedStatement stmn;

    public void inserir(Funcionario funcionario) throws SQLException, Exception {

        String sql = "INSERT INTO Funcionario (nome, cpf, sexo, data_nasc, numero, cep, rua, bairro, cidade, logradouro, complemento, celular, telefone, email, cargo, filial, departamento ativo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);

            stmn.setString(1, funcionario.getNome());
            stmn.setString(2, funcionario.getCpf());
            stmn.setString(3, funcionario.getSexo());
            stmn.setString(4, funcionario.getData_nasc());
            stmn.setInt(5, funcionario.getNumero());
            stmn.setString(6, funcionario.getCep());
            stmn.setString(7, funcionario.getRua());
            stmn.setString(8, funcionario.getBairro());
            stmn.setString(9, funcionario.getCidade());
            stmn.setString(10, funcionario.getLogradouro());
            stmn.setString(11, funcionario.getComplemento());
            stmn.setString(12, funcionario.getCelular());
            stmn.setString(13, funcionario.getTelefone());
            stmn.setString(14, funcionario.getEmail());
            stmn.setString(15, funcionario.getCargo());
            stmn.setString(16, funcionario.getFilial());
            stmn.setString(17, funcionario.getDepartamento());
            stmn.setBoolean(18, true);

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

    public void alterar(Funcionario funcionario) throws SQLException, Exception {

        String sql = "UPDATE Funcionario "
                + "SET nome=?, cpf=?, sexo=?, data_nasc=?, numero=?, cep=?, rua=?, bairro=?, cidade=?, logradouro=?, complemento=?, celular=?, telefone=?, email=?, cargo=?, filial=?, departamento=?, ativo=? "
                + "WHERE id_func=?";

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);

            stmn.setString(1, funcionario.getNome());
            stmn.setString(2, funcionario.getCpf());
            stmn.setString(3, funcionario.getSexo());
            stmn.setString(4, funcionario.getData_nasc());
            stmn.setInt(5, funcionario.getNumero());
            stmn.setString(6, funcionario.getCep());
            stmn.setString(7, funcionario.getRua());
            stmn.setString(8, funcionario.getBairro());
            stmn.setString(9, funcionario.getCidade());
            stmn.setString(10, funcionario.getLogradouro());
            stmn.setString(11, funcionario.getComplemento());
            stmn.setString(12, funcionario.getCelular());
            stmn.setString(13, funcionario.getTelefone());
            stmn.setString(14, funcionario.getEmail());
            stmn.setString(15, funcionario.getCargo());
            stmn.setString(16, funcionario.getFilial());
            stmn.setString(17, funcionario.getDepartamento());
            stmn.setBoolean(18, funcionario.isAtivo());
            stmn.setInt(19, funcionario.getId_func());

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

    public List<Funcionario> ListaFuncionario() throws SQLException, ClassNotFoundException {
        List<Funcionario> listaFuncionario = new ArrayList<>();

        con = DbUtil.getConnection();

        String query = "SELECT * FROM Cliente ORDER BY nome WHERE ativo=true";

        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);
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
        con.close();
        return listaFuncionario;
    }

    public Funcionario funcionarioPorNome(String nome) throws SQLException, ClassNotFoundException {
        Funcionario func = new Funcionario();
        con = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM Funcionario WHERE nome=?";
            stmn = con.prepareStatement(query);
            stmn.setString(1, nome);
            try (ResultSet resultSet = stmn.executeQuery()) {
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
            }
            stmn.close();
        } catch (SQLException e) {
        }
        con.close();
        return func;
    }
}
