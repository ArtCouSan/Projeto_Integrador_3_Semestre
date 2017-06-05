package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.RelatorioDAO;
import br.senac.tads3.pi03b.gruposete.models.RelatorioMudancas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "BuscarRelatorioMudanca", urlPatterns = {"/BuscarRelatorioMudanca"})
public class BuscarRelatorioMudanca extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RelatorioDAO relatorio = new RelatorioDAO();

        try {

            JSONArray jsonArray = new JSONArray();

            ArrayList<RelatorioMudancas> procurar = relatorio.procurarRelatorioMudanca();

            for (RelatorioMudancas procurarVenda : procurar) {

                JSONObject json = new JSONObject();

                json.put("mudanca", procurarVenda.getMudanca());
                json.put("data_m", procurarVenda.getData());
                json.put("nome", procurarVenda.getFuncionario());
                json.put("cargo", procurarVenda.getCargo());
                json.put("filial", procurarVenda.getFilial());
                
                jsonArray.add(json);

            }

            try (PrintWriter out = response.getWriter()) {

                out.println(jsonArray.toJSONString());

            }

        } catch (SQLException | ClassNotFoundException ex) {

            Logger.getLogger(BuscarRelatorioMudanca.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
