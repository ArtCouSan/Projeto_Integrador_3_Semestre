package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.UsuarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Usuario;
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

@WebServlet("/ExcluiUsuarioServlet")
public class ExcluiUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String pesquisa = request.getParameter("pesquisa");
        UsuarioDAO query = new UsuarioDAO();
        if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                query.excluir(id);
                List<Usuario> encontrados = query.procurarUsuario(pesquisa);
                request.setAttribute("encontrados", encontrados);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ExcluiUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex); 
            } catch (Exception ex) {
                Logger.getLogger(ExcluiUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaUsuario.jsp");
            dispatcher.forward(request, response);
        }
    }
}
