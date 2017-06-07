package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.RelatorioDAO;
import br.senac.tads3.pi03b.gruposete.models.RelatorioValores;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "BuscarRelatorioVendas", urlPatterns = {"/BuscarRelatorioVendas"})
public class BuscarRelatorioVendas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RelatorioDAO relatorio = new RelatorioDAO();

        try {

            JSONArray jsonArray = new JSONArray();

            ArrayList<RelatorioValores> procurar = relatorio.procurarRelatorioAno();

            ArrayList<RelatorioValores> procurar2 = relatorio.procurarRelatorioMes();

            for (RelatorioValores procurarR : procurar) {

                JSONObject json = new JSONObject();

                json.put("data_vendaANO", procurarR.getData());
                json.put("filialANO", procurarR.getFilial());
                json.put("valorANO", procurarR.getValor());

                jsonArray.add(json);

            }

            for (RelatorioValores procurarR : procurar2) {

                JSONObject json = new JSONObject();

                json.put("data_vendaMES", procurarR.getData());
                json.put("filialMES", procurarR.getFilial());
                json.put("valorMES", procurarR.getValor());

                jsonArray.add(json);

            }

            response.setCharacterEncoding("UTF-8");

            try (PrintWriter out = response.getWriter()) {

                out.println(jsonArray.toJSONString());

            }

        } catch (Exception e) {

        }

    }

}
