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

@WebServlet(name = "BuscaVendaSerlvet", urlPatterns = {"/BuscaVenda"})
public class BuscaVendaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String inicio = request.getParameter("inicio");

        String fim = request.getParameter("fim");

        VendaDAO dao = new VendaDAO();

        ArrayList<Venda> vendas = dao.procurarVendas(inicio, fim);

        JSONArray jsonArray = new JSONArray();

    }

}
