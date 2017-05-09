package br.senac.tads3.pi03b.gruposete.dao;

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

    /**
     * Funcao que insere venda.
     *
     * @param venda
     * @throws SQLException
     * @throws FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public void inserir(Venda venda) throws SQLException, FileNotFoundException, ClassNotFoundException {

        connection = DbUtil.getConnection();

        // Comando SQL.
        String slq = "INSERT INTO venda "
                + "(id_cliente, id_produto, id_func, preco) "
                + "VALUES (? , ?, ?, ?)";

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

    /**
     * Funcao que insere itens de venda.
     *
     * @param idProduto
     * @param quantidade
     * @param preco
     * @param id_venda
     * @throws SQLException
     * @throws FileNotFoundException
     */
    public void inserirLista(int idProduto, int quantidade, float preco, int id_venda) throws SQLException, FileNotFoundException, ClassNotFoundException {

        // Conecta.
        connection = DbUtil.getConnection();

        // Comando SQL.
        String slq = "INSERT INTO itens_venda "
                + "(Id_produto, quantidade, preco, id_venda) "
                + "VALUES (? , ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(slq);

        // Insercoes.
        stmt.setInt(1, idProduto);
        stmt.setInt(2, quantidade);
        stmt.setFloat(3, preco);
        stmt.setInt(4, id_venda);

        // Executa.
        stmt.execute();

        // Fecha conexao.
        con.close();

    }

    /**
     * Funcao que retorna o id de venda.
     *
     * @return id de intes de venda.
     * @throws SQLException
     */
    public int maiorIdVenda() throws SQLException, ClassNotFoundException {

        // Conecta.
        connection = DbUtil.getConnection();

        // Comando SQL.
        String slq = "SELECT MAX(id_venda) FROM venda";

        PreparedStatement stmt = con.prepareStatement(slq);

        // Executa e recebe resultado.
        ResultSet result = stmt.executeQuery();

        // Declara id.
        int maiorID = 0;

        // Loop de resultado.
        while (result.next()) {

            // Pega maximo id.
            maiorID = result.getInt("MAX(id_venda)");

        }

        // Fecha conexao.
        con.close();

        // Retorna proximo id.
        return maiorID;

    }

    /**
     * Funcao que retorna lista de vendas.
     *
     * @param Dinicio inicio.
     * @param Afim fim.
     * @return lista de vendas.
     * @throws SQLException
     */
    public ArrayList<Venda> procurarVendas(String Dinicio, String Afim) throws SQLException {

        // Conecta.
        Conectar();

        // Declara variavel para receber resultado.
        ResultSet result = null;

        // Declara variavel para receber starter.
        PreparedStatement stmt = null;

        // Verifica campos de relatorio.
        VerificacoesCamposRelatorio verifica = new VerificacoesCamposRelatorio();

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

        // Verifica se fim foi preenchido.
        if (!verifica.verificarInicio(Afim)) {

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

            stmt = con.prepareStatement(slq);

            // Insercoes.
            stmt.setString(1, dataI);
            stmt.setString(2, dataF);
            stmt.setBoolean(3, true);

            // Verifica se fim nao foi preenchido.    
        } else {

            // Comando SQL.
            String slq = "SELECT * FROM venda WHERE DATA >= ? AND ATIVO = ?";

            // Executa.
            stmt = con.prepareStatement(slq);

            // Insercoes.
            stmt.setString(1, dataI);
            stmt.setBoolean(2, true);

        }

        // Executa e recebe resultado.
        result = stmt.executeQuery();

        // Loop com resultados.
        while (result.next()) {

            // Declara objeto.
            Venda venda = new Venda();

            // Prenche.
            venda.setID_venda(result.getInt("id_venda"));
            venda.setID_cliente(result.getInt("id_cliente"));
            venda.setData(result.getDate("data"));
            venda.setValor(result.getFloat("total"));
            venda.setTotalQuantidade(result.getInt("total_quantidade"));

            // Adiciona a lista.
            listaResultado.add(venda);

        }

        // Fecha conexao.
        con.close();

        // Retorna lista.
        return listaResultado;

    }

    /**
     * Funcao que procura venda pelo id.
     *
     * @param id
     * @return venda.
     * @throws SQLException
     */
    public Venda procurarVenda(int id) throws SQLException {

        // Conecta.
        Conectar();

        Venda venda = new Venda();

        // Comando SQL.
        String slq = "SELECT * FROM venda WHERE id_venda = ?";

        PreparedStatement stmt = con.prepareStatement(slq);

        // Insercoes.
        stmt.setInt(1, id);

        // Executa e recebe resultado.
        ResultSet result = stmt.executeQuery();

        // Loop com resultados.
        while (result.next()) {

            // Prenche.
            venda.setID_venda(result.getInt("id_venda"));
            venda.setID_cliente(result.getInt("id_cliente"));
            venda.setData(result.getDate("data"));
            venda.setValor(result.getFloat("total"));
            venda.setTotalQuantidade(result.getInt("total_quantidade"));

            // Fecha conexao.
            con.close();

            return venda;

        }

        // Fecha conexao.
        con.close();

        return null;

    }

    /**
     * Funcao que procura lista de itens.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public ArrayList<Carrinho> procurarItens(int id) throws SQLException {

        // Conecta.
        Conectar();

        ArrayList<Carrinho> listaResultado = new ArrayList<>();

        // Comando SQL.
        String slq = "SELECT * FROM itens_venda WHERE id_venda = ?";

        PreparedStatement stmt = con.prepareStatement(slq);

        // Insercoes.
        stmt.setInt(1, id);

        // Executa e recebe resultado.
        ResultSet result = stmt.executeQuery();

        // Declara variaveis.
        int id_produto;
        int quantidade;
        float preco;

        // Loop com resultados.
        while (result.next()) {

            // Prenche.
            id_produto = (result.getInt("id_produto"));
            quantidade = (result.getInt("quantidade"));
            preco = (result.getFloat("preco"));

            Carrinho carrinho = new Carrinho(id_produto, preco, quantidade);

            listaResultado.add(carrinho);

        }

        // Fecha conexao.
        con.close();

        // Retorna lista.
        return listaResultado;

    }

    /**
     * Funcao que pega desconto.
     *
     * @param id
     * @return quantia de lucro pelo cliente.
     * @throws java.sql.SQLException
     */
    public int getDesc(int id) throws SQLException {

        // Conecta.
        Conectar();

        // Comando SQL.
        String slq = "SELECT SUM(total) FROM venda WHERE id_cliente = ?";

        PreparedStatement stmt = con.prepareStatement(slq);

        stmt.setInt(1, id);

        // Executa e recebe resultado.
        ResultSet result = stmt.executeQuery();

        // Declara id.
        int soma = 0;

        // Loop de resultado.
        while (result.next()) {

            // Pega maximo id.
            soma = result.getInt("SUM(total)");

        }

        return soma;

    }

}
