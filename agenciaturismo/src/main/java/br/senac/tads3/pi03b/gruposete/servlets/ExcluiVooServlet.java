package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.VooDAO;
import br.senac.tads3.pi03b.gruposete.models.Voo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/ExcluiVooServlet")
public class ExcluiVooServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        String pesquisa = request.getParameter("pesquisa");

        VooDAO query = new VooDAO();

        if ("edit".equalsIgnoreCase(action)) {

            int id = Integer.parseInt(request.getParameter("id"));

            try {

                query.excluirVoo(id);

                List<Voo> encontrados = query.procurarVoo(pesquisa);

                request.setAttribute("encontrados", encontrados);

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(ExcluiVooServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaVoo.jsp");
            dispatcher.forward(request, response);

        }

    }

}
