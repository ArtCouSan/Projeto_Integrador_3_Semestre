package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.models.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditaClienteServlet")
public class EditaClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ClienteDAO dao = new ClienteDAO();

        String action = request.getParameter("action");

        if ("edit".equalsIgnoreCase(action)) {

            try {

                Cliente clientes = dao.getClienteById(id);

                request.setAttribute("clientes", clientes);

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(EditaClienteServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Editar/EditaCliente.jsp");
            dispatcher.forward(request, response);

        }
    }

}
