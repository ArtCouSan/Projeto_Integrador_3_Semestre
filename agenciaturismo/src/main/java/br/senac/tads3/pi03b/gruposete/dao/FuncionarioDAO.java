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

        System.out.println("ENTROU DAOFUNC");

        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO funcionario (pessoa, cargo, departamento, ativo) VALUES (?, ?, ?, ?)";
        //Cria um statement para execução de instruções SQL

        try {
            con = DbUtil.getConnection();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>1");
            stmn = con.prepareStatement(sql);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>2");
            //Configura os parâmetros do "PreparedStatement"
            //stmn.setObject(1, funcionario.getPessoa());//DEU ERRO AQUI>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            System.out.println(">>>>>>>>>>>>>>>>>>>>>3");
            stmn.setString(2, funcionario.getCargo());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>4");
            stmn.setString(3, funcionario.getDepartamento());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>5");
            stmn.setBoolean(4, funcionario.isAtivo());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>6");
            //Executa o comando no banco de dados
            stmn.executeUpdate();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>7");
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (stmn != null && !stmn.isClosed()) {
                stmn.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public void alterar(Funcionario funcionario) throws SQLException, Exception {

        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE Funcionario SET pessoa=?, cargo=?, departamento=?, ativo=? WHERE id_cliente=?";
        //Cria um statement para execução de instruções SQL

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            //stmn.setObject(1, funcionario.getPessoa());
            stmn.setString(2, funcionario.getCargo());
            stmn.setString(3, funcionario.getDepartamento());
            stmn.setBoolean(4, funcionario.isAtivo());
            stmn.setInt(5, funcionario.getId_func());

            //Executa o comando no banco de dados
            stmn.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (stmn != null && !stmn.isClosed()) {
                stmn.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public void excluir(int id) throws SQLException, Exception {

        //Monta a string de inserção de um cliente no BD, utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE Funcionario SET ativo=? WHERE id_func=?";
        //Cria um statement para execução de instruções SQL

        try {
            con = DbUtil.getConnection();
            stmn = con.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            stmn.setBoolean(1, false);
            stmn.setInt(2, id);
            //Executa o comando no banco de dados
            stmn.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (stmn != null && !stmn.isClosed()) {
                stmn.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public List<Funcionario> ListaFuncionario() throws SQLException, ClassNotFoundException {
        List<Funcionario> ListaFuncionario = new ArrayList<>();
        con = DbUtil.getConnection();
        String query = "SELECT * FROM Funcionario ORDER BY nome";

        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId_func(resultSet.getInt("id_func"));
                funcionario.setAtivo(resultSet.getBoolean("ativo"));
                //funcionario.setPessoa((Pessoa) resultSet.getObject("pessoa"));
                funcionario.setCargo(resultSet.getString("cargo"));
                funcionario.setDepartamento(resultSet.getString("departamento"));
                ListaFuncionario.add(funcionario);
            }
        } catch (SQLException e) {
        }
        con.close();
        return ListaFuncionario;
    }

    public Funcionario getFuncionarioById(int id) throws SQLException, ClassNotFoundException {
        Funcionario funcionario = new Funcionario();
        con = DbUtil.getConnection();
        try {
            String query = "SELECT * FROM Funcionario WHERE id_func=?";
            stmn = con.prepareStatement(query);
            stmn.setInt(1, id);
            try (ResultSet resultSet = stmn.executeQuery()) {
                while (resultSet.next()) {
                    //funcionario.setPessoa((Pessoa)resultSet.getObject("pessoa"));
                    funcionario.setAtivo(resultSet.getBoolean("ativo"));
                    funcionario.setFilial(resultSet.getString("filial"));
                    funcionario.setCargo(resultSet.getString("cargo"));
                    funcionario.setDepartamento(resultSet.getString("departamento"));
                }
            }
            stmn.close();
        } catch (SQLException e) {
        }
        con.close();
        return funcionario;
    }
}
