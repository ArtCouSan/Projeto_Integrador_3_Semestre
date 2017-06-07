package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.VendaDAO;
import br.senac.tads3.pi03b.gruposete.models.Voo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "BuscaVooVendaServlet", urlPatterns = {"/BuscarVooVenda"})
public class BuscaVooVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String busca = request.getParameter("busca");

            VendaDAO dao = new VendaDAO();

            ArrayList<Voo> voo = dao.procurarVoo(busca);

            JSONArray jsonArray = new JSONArray();

            for (Voo voos : voo) {

                JSONObject json = new JSONObject();

                json.put("id_voo", voos.getId());
                json.put("data_volta", voos.getData_volta());
                json.put("data_ida", voos.getData_ida());
                json.put("origem", voos.getOrigem());
                json.put("preco", voos.getPreco());
                json.put("quantidade_passagens", voos.getQuantidade_passagens());
                json.put("destino", voos.getDestino());
                jsonArray.add(json);

            }

            response.setCharacterEncoding("UTF-8");
            
            try (PrintWriter out = response.getWriter()) {

                out.println(jsonArray.toJSONString());

            }

        } catch (ClassNotFoundException | SQLException e) {
        }

    }

   

}
