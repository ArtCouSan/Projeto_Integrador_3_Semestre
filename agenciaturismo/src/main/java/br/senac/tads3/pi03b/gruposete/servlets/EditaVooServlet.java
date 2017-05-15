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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/EditaVooServlet")
public class EditaVooServlet extends HttpServlet {

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

                Logger.getLogger(EditaVooServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Editar/EditarVoo.jsp");
            dispatcher.forward(request, response);

        }
    }

}
