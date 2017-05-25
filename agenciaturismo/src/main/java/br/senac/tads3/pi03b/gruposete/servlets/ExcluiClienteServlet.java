package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.models.Cliente;

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

@WebServlet("/ExcluiClienteServlet")
public class ExcluiClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String pesquisa = request.getParameter("pesquisa");
        ClienteDAO query = new ClienteDAO();
        if ("edit".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                query.excluir(id);
                List<Cliente> encontrados = query.procurarCliente(pesquisa);
                request.setAttribute("encontrados", encontrados);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ExcluiClienteServlet.class.getName()).log(Level.SEVERE, null, ex); 
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaCliente.jsp");
            dispatcher.forward(request, response);
        }
    }
}
