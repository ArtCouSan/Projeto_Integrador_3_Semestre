package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.models.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "BuscaUsuarioServlet", urlPatterns = {"/BuscaUsuarioServlet"})
public class BuscaUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Buscar/BuscaUsuario.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean erro = false;

        String pesquisa = request.getParameter("pesquisa");

        if (!erro) {

            try {
                ClienteDAO dao = new ClienteDAO();
                List<Cliente> encontrados = dao.procurarCliente(pesquisa);
                request.setAttribute("encontrados", encontrados);
                request.setAttribute("pesquisa", pesquisa);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaUsuario.jsp");
                dispatcher.forward(request, response);

            } catch (IOException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(BuscaClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListarUsuario.jsp");
            dispatcher.forward(request, response);
        }
    }
}