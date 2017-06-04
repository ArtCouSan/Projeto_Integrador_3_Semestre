package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import br.senac.tads3.pi03b.gruposete.dao.VendaDAO;
import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.models.Funcionario;
import br.senac.tads3.pi03b.gruposete.models.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "BuscarRelatorio", urlPatterns = {"/BuscarRelatorio"})
public class BuscarRelatorio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VendaDAO venda = new VendaDAO();

        String inicio = request.getParameter("inicio");
        String fim = request.getParameter("fim");

        try {

            JSONArray jsonArray = new JSONArray();

            ArrayList<Venda> procurarVendas;

            if (inicio.length() != 0 && fim.length() != 0) {

                procurarVendas = venda.procurarVendas(inicio, fim);

            } else if (inicio.length() != 0) {

                procurarVendas = venda.procurarVendas2(inicio);

            } else if (fim.length() != 0) {

                procurarVendas = venda.procurarVendas2(fim);

            } else {

                procurarVendas = venda.procurarVendas3();

            }

            for (Venda procurarVenda : procurarVendas) {

                JSONObject json = new JSONObject();

                ClienteDAO clente = new ClienteDAO();
                FuncionarioDAO func = new FuncionarioDAO();
                Funcionario funcionarioById = func.getFuncionarioById(procurarVenda.getId_func());
                Cliente clienteById = clente.getClienteById(procurarVenda.getId_cliente());

                json.put("filial", funcionarioById.getFilial());
                json.put("funcionario", funcionarioById.getNome());
                json.put("cliente", clienteById.getNome());
                json.put("id_venda", procurarVenda.getId_venda());
                json.put("preco", procurarVenda.getPreco());
                json.put("data", procurarVenda.getData());
                jsonArray.add(json);

            }

            try (PrintWriter out = response.getWriter()) {

                out.println(jsonArray.toJSONString());

            }

        } catch (SQLException | ClassNotFoundException ex) {

            Logger.getLogger(BuscarRelatorio.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
