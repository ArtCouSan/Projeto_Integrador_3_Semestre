package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.VooDAO;
import br.senac.tads3.pi03b.gruposete.models.Voo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaVooServlet", urlPatterns = {"/lista-voo"})
public class ListaVooServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            VooDAO vooDAO = new VooDAO();
            List<Voo> lista = vooDAO.ListaVoo();
            request.setAttribute("listaVoos", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Listar/ListaVoo.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
