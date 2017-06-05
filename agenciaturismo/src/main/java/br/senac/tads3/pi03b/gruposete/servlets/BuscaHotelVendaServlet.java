package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.VendaDAO;
import br.senac.tads3.pi03b.gruposete.models.Hotel;
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

@WebServlet(name = "BuscaHotelVendaServlet", urlPatterns = {"/BuscarHotelVenda"})
public class BuscaHotelVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String busca = request.getParameter("busca");

            VendaDAO dao = new VendaDAO();

            ArrayList<Hotel> hotel = dao.procurarHotel(busca);

            response.setContentType("text/html;charset=UTF-8");

            JSONArray jsonArray = new JSONArray();

            for (Hotel object : hotel) {

                JSONObject json = new JSONObject();
                
                json.put("nome_hotel", object.getNome());
                json.put("id_hotel", object.getId());
                json.put("data_entrada", object.getData_entrada());
                json.put("data_saida", object.getData_saida());
                json.put("preco", object.getPreco());
                json.put("quantidade_quartos", object.getQuantidade_quartos());
                json.put("quantidade_hospedes", object.getQuantidade_hospedes());
                jsonArray.add(json);

            }

            try (PrintWriter out = response.getWriter()) {

                out.println(jsonArray.toJSONString());

            }

        } catch (SQLException | ClassNotFoundException ex) {

        }

    }

}
