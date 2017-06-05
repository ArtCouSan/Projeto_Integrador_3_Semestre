package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.RelatorioMudancas;
import br.senac.tads3.pi03b.gruposete.models.RelatorioValores;
import br.senac.tads3.pi03b.gruposete.models.Venda;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RelatorioDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

    public ArrayList<RelatorioMudancas> procurarRelatorioMudanca() throws SQLException, ClassNotFoundException {

        // Conecta.
        connection = DbUtil.getConnection();

        // Lista que ira receber vendas.
        ArrayList<RelatorioMudancas> listaResultado = new ArrayList<>();

        // Comando SQL.
        String slq = "SELECT * FROM `relatoriomudancas` "
                + "INNER JOIN funcionario "
                + "ON relatoriomudancas.id_funcionario = funcionario.id_funcionario "
                + "ORDER BY data_m DESC LIMIT 50";

        preparedStatement = connection.prepareStatement(slq);

        // Executa e recebe resultado.
        resultSet = preparedStatement.executeQuery();

        // Loop com resultados.
        while (resultSet.next()) {

            // Declara objeto.
            RelatorioMudancas relatorio = new RelatorioMudancas();

            // Prenche.
            relatorio.setMudanca(resultSet.getString("mudanca"));
            relatorio.setData(resultSet.getString("data_m"));
            relatorio.setFuncionario(resultSet.getString("nome"));
            relatorio.setFilial(resultSet.getString("filial"));
            relatorio.setCargo(resultSet.getString("cargo"));

            // Adiciona a lista.
            listaResultado.add(relatorio);

        }

        // Fecha conexao.
        connection.close();

        // Retorna lista.
        return listaResultado;

    }

    public ArrayList<RelatorioValores> procurarRelatorioAno() throws SQLException, ClassNotFoundException {

        // Conecta.
        connection = DbUtil.getConnection();

        // Lista que ira receber vendas.
        ArrayList<RelatorioValores> listaResultado = new ArrayList<>();

        // Comando SQL.
        String slq = "SELECT (SELECT SUBSTRING(relatoriomudancas.data_m,1,4 )) as Ano , SUM(valor), filial "
                + "FROM relatoriomudancas "
                + "INNER JOIN funcionario "
                + "ON funcionario.id_funcionario = relatoriomudancas.id_funcionario "
                + "GROUP BY (SELECT SUBSTRING(relatoriomudancas.data_m,1,4 )) "
                + "ORDER BY (SELECT SUBSTRING(relatoriomudancas.data_m,1,4 )) "
                + "DESC LIMIT 25";

        preparedStatement = connection.prepareStatement(slq);

        // Executa e recebe resultado.
        resultSet = preparedStatement.executeQuery();

        // Loop com resultados.
        while (resultSet.next()) {

            // Declara objeto.
            RelatorioValores relatorio = new RelatorioValores();

            // Prenche.
            relatorio.setValor(resultSet.getFloat("SUM(valor)"));
            relatorio.setData(resultSet.getString("Ano"));
            relatorio.setFilial(resultSet.getString("filial"));

            // Adiciona a lista.
            listaResultado.add(relatorio);

        }

        // Fecha conexao.
        connection.close();

        // Retorna lista.
        return listaResultado;

    }

    public void inserir(RelatorioMudancas relatorios) throws SQLException, Exception {

        String sql = "INSERT INTO `relatoriomudancas`"
                + "(`mudanca`, `id_funcionario`, `data_m`) "
                + "VALUES (?, ?, ?)";

        try {

            connection = DbUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            Date data = new Date(System.currentTimeMillis());
            SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
            String formatado = formatarDate.format(data);

            preparedStatement.setString(1, relatorios.getMudanca());
            preparedStatement.setInt(2, relatorios.getId_funcionario());
            preparedStatement.setString(3, formatado);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        } finally {

            if (connection != null && !connection.isClosed()) {

                connection.close();

            }

        }

    }

}
