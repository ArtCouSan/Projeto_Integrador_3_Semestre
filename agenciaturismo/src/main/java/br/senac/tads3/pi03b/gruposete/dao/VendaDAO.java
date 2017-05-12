package br.senac.tads3.pi03b.gruposete.dao;

import br.senac.tads3.pi03b.gruposete.models.Carrinho;
import br.senac.tads3.pi03b.gruposete.models.Venda;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VendaDAO {

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet resultSet;

    public void inserir(Venda venda) throws SQLException, FileNotFoundException, ClassNotFoundException {

        connection = DbUtil.getConnection();

        // Comando SQL.
        String slq = "INSERT INTO venda "
                + "(id_cliente, id_produto, id_func, preco) "
                + "VALUES (?, ?, ?, ?)";

        preparedStatement = connection.prepareStatement(slq);

        // Insercoes.
        preparedStatement.setInt(1, venda.getId_cliente());
        preparedStatement.setInt(2, venda.getId_produto());
        preparedStatement.setInt(3, venda.getId_func());
        preparedStatement.setDouble(4, venda.getPreco());

        // Executa.
        preparedStatement.execute();

        // Fecha conexao.
        preparedStatement.close();

    }

    public void inserirLista(int id_produto, int quantidade, float preco, int id_venda) throws SQLException, FileNotFoundException, ClassNotFoundException {

        // Conecta.
        connection = DbUtil.getConnection();

        // Comando SQL.
        String slq = "INSERT INTO itens_venda "
                + "(Id_produto, quantidade, preco, id_venda) "
                + "VALUES (? , ?, ?, ?)";

        preparedStatement = connection.prepareStatement(slq);

        // Insercoes.
        preparedStatement.setInt(1, id_produto);
        preparedStatement.setInt(2, quantidade);
        preparedStatement.setFloat(3, preco);
        preparedStatement.setInt(4, id_venda);

        // Executa.
        preparedStatement.execute();

        // Fecha conexao.
        connection.close();

    }

    public int maiorIdVenda() throws SQLException, ClassNotFoundException {

        // Conecta.
        connection = DbUtil.getConnection();

        // Comando SQL.
        String slq = "SELECT MAX(id_venda) FROM venda";

        preparedStatement = connection.prepareStatement(slq);

        // Executa e recebe resultado.
        resultSet = preparedStatement.executeQuery();

        // Declara id.
        int maiorID = 0;

        // Loop de resultado.
        while (resultSet.next()) {

            // Pega maximo id.
            maiorID = resultSet.getInt("MAX(id_venda)");

        }

        // Fecha conexao.
        connection.close();

        // Retorna proximo id.
        return maiorID;

    }

    public ArrayList<Venda> procurarVendas(String Dinicio, String Afim) throws SQLException, ClassNotFoundException {

        // Conecta.
        connection = DbUtil.getConnection();

        // Lista que ira receber vendas.
        ArrayList<Venda> listaResultado = new ArrayList<>();

        // Variavel recebe dia inicial.
        CharSequence diaI = Dinicio.subSequence(0, 2);

        // Variavel recebe mes inicial.
        CharSequence mesI = Dinicio.subSequence(3, 5);

        // Variavel recebe ano inicial.
        CharSequence anoI = Dinicio.subSequence(6, 10);

        // Variavel concatena a data no formato desejado.
        String dataI = anoI + "-" + mesI + "-" + diaI;

        // Variavel recebe dia final.
        CharSequence diaF = Afim.subSequence(0, 2);

        // Variavel recebe mes final.
        CharSequence mesF = Afim.subSequence(3, 5);

        // Variavel recebe ano final.
        CharSequence anoF = Afim.subSequence(6, 10);

        // Variavel concatena a data no formato desejado.
        String dataF = anoF + "-" + mesF + "-" + diaF;

        // Comando SQL.
        String slq = "SELECT * FROM venda WHERE DATA BETWEEN ? AND ? AND ATIVO = ?";

        preparedStatement = connection.prepareStatement(slq);

        // Insercoes.
        preparedStatement.setString(1, dataI);
        preparedStatement.setString(2, dataF);
        preparedStatement.setBoolean(3, true);

        // Executa e recebe resultado.
        resultSet = preparedStatement.executeQuery();

        // Loop com resultados.
        while (resultSet.next()) {

            // Declara objeto.
            Venda venda = new Venda();

            // Prenche.
            venda.setId_venda(resultSet.getInt("id_venda"));
            venda.setId_cliente(resultSet.getInt("id_cliente"));
            venda.setPreco(resultSet.getFloat("total"));
            venda.setTotal_quantidade(resultSet.getInt("total_quantidade"));

            // Adiciona a lista.
            listaResultado.add(venda);

        }

        // Fecha conexao.
        connection.close();

        // Retorna lista.
        return listaResultado;

    }

    /**
     * Funcao que procura venda pelo id.
     *
     * @param id
     * @return venda.
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Venda procurarVenda(int id) throws SQLException, ClassNotFoundException {

        // Conecta.
        connection = DbUtil.getConnection();

        Venda venda = new Venda();

        // Comando SQL.
        String slq = "SELECT * FROM venda WHERE id_venda = ?";

        preparedStatement = connection.prepareStatement(slq);

        // Insercoes.
        preparedStatement.setInt(1, id);

        // Executa e recebe resultado.
        resultSet = preparedStatement.executeQuery();

        // Loop com resultados.
        while (resultSet.next()) {

            // Prenche.
            venda.setId_venda(resultSet.getInt("id_venda"));
            venda.setId_cliente(resultSet.getInt("id_cliente"));
            venda.setPreco(resultSet.getFloat("total"));
            venda.setTotal_quantidade(resultSet.getInt("total_quantidade"));

            // Fecha conexao.
            connection.close();

            return venda;

        }

        // Fecha conexao.
        connection.close();

        return null;

    }

    /**
     * Funcao que procura lista de itens.
     *
     * @param id
     * @return
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public ArrayList<Carrinho> procurarItens(int id) throws SQLException, ClassNotFoundException {

        // Conecta.
        connection = DbUtil.getConnection();

        ArrayList<Carrinho> listaResultado = new ArrayList<>();

        // Comando SQL.
        String slq = "SELECT * FROM itens_venda WHERE id_venda = ?";

        preparedStatement = connection.prepareStatement(slq);

        // Insercoes.
        preparedStatement.setInt(1, id);

        // Executa e recebe resultado.
        resultSet = preparedStatement.executeQuery();

        // Declara variaveis.
        int id_produto;
        int quantidade;
        float preco;

        // Loop com resultados.
        while (resultSet.next()) {

            // Prenche.
            id_produto = (resultSet.getInt("id_produto"));
            quantidade = (resultSet.getInt("quantidade"));
            preco = (resultSet.getFloat("preco"));

            Carrinho carrinho = new Carrinho(id_produto, preco, quantidade);

            listaResultado.add(carrinho);

        }

        // Fecha conexao.
        connection.close();

        // Retorna lista.
        return listaResultado;

    }

}
