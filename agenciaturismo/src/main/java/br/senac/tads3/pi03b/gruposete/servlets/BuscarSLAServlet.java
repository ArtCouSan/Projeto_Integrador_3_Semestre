package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.RelatorioDAO;
import br.senac.tads3.pi03b.gruposete.models.RelatorioSLA;
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

@WebServlet(name = "BuscarSLAServlet", urlPatterns = {"/BuscarSLAServlet"})
public class BuscarSLAServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RelatorioDAO relatorio = new RelatorioDAO();

        try {

            JSONArray jsonArray = new JSONArray();

            ArrayList<RelatorioSLA> procurar = relatorio.procurarRelatorioSLA();

            for (RelatorioSLA procuraras: procurar) {

                JSONObject json = new JSONObject();

                json.put("id_sla", procuraras.getId_SLA());
                json.put("mensagem", procuraras.getMensagem());
                json.put("data_m", procuraras.getData());
                json.put("nome", procuraras.getFuncionario());
                json.put("cargo", procuraras.getCargo());
                json.put("filial", procuraras.getFilial());

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
