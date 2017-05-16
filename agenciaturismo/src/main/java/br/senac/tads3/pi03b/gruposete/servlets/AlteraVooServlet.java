package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.VooDAO;
import br.senac.tads3.pi03b.gruposete.models.Voo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AlteraVooServlet", urlPatterns = {"/EditarVoo"})
public class AlteraVooServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        VooDAO dao = new VooDAO();

        String action = request.getParameter("action");

        if ("edit".equalsIgnoreCase(action)) {

            try {

                Voo voos = dao.getVooById(id);

                request.setAttribute("voos", voos);

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(AlteraVooServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Editar/EditarVoo.jsp");
            dispatcher.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean erro = false;

        String origem = request.getParameter("origem");
        if (origem == null || origem.length() < 1) {
            erro = true;
            request.setAttribute("erroOrigem", true);
        }
        String destino = request.getParameter("destino");
        if (destino == null || destino.length() < 1) {
            erro = true;
            request.setAttribute("erroDestino", true);
        }
        String data_ida = request.getParameter("data_ida");
        if (data_ida == null || !"  /  /    ".equals(data_ida)) {
            erro = true;
            request.setAttribute("erroData_ida", true);
        }
        String data_volta = request.getParameter("data_volta");
        if (data_volta == null || !"  /  /    ".equals(data_volta)) {
            erro = true;
            request.setAttribute("erroData_volta", true);
        }

        int quantidade_passagens = Integer.parseInt(request.getParameter("quantidade_passagens"));
        if (quantidade_passagens < 1) {
            erro = true;
            request.setAttribute("erroQuantidade_passagens", true);
        }

        float preco = Float.parseFloat(request.getParameter("preco"));
        if (preco < 0) {
            erro = true;
            request.setAttribute("erroPreco", true);
        }

        int id = Integer.parseInt(request.getParameter("identificacao"));

        if (!erro) {
            Voo voo = new Voo(data_ida, data_volta, destino, origem, quantidade_passagens, preco, true);
            voo.setId_voo(id);
            try {
                VooDAO dao = new VooDAO();
                dao.alterar(voo);
                HttpSession sessao = request.getSession();
                sessao.setAttribute("editarVoo", voo);
                response.sendRedirect("index.jsp");

            } catch (Exception ex) {

            }

        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Editar/EditarVoo.jsp");

            dispatcher.forward(request, response);

        }
    }

}
