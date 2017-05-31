package br.senac.tads3.pi03b.gruposete.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.tads3.pi03b.gruposete.dao.VendaDAO;
import br.senac.tads3.pi03b.gruposete.models.Venda;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import org.json.simple.JSONArray;

@WebServlet(name = "BuscaVendaSerlvet", urlPatterns = {"/BuscarRelatorio"})
public class BuscaVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String inicio = request.getParameter("inicio");

        String fim = request.getParameter("fim");

        VendaDAO dao = new VendaDAO();

        try {
            ArrayList<Venda> vendas = dao.procurarVendas(inicio, fim);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BuscaVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        JSONArray jsonArray = new JSONArray();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Relatorios/BuscarRelatorio.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Relatorios/BuscarRelatorio.jsp");
        dispatcher.forward(request, response);
    }

}
