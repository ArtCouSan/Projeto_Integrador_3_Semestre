package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.UsuarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Usuario;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "AlteraUsuarioServlet", urlPatterns = {"/EditarUsuario"})
public class AlteraUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        UsuarioDAO dao = new UsuarioDAO();
        String action = request.getParameter("action");
        if ("edit".equalsIgnoreCase(action)) {
            try {
                Usuario usuario = dao.getUsuarioById(id);
                request.setAttribute("usuario", usuario);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AlteraUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Editar/EditarCliente.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDAO dao = new UsuarioDAO();
        boolean erro = false;
        
        String senha = request.getParameter("senha");
        
        if (senha == null || senha.length() < 1) {
            erro = true;
            request.setAttribute("erroSenha", true);
        }
        
        int id = Integer.parseInt(request.getParameter("identificacao"));

        if (erro == false) {
            Usuario usuarioHumilde = new Usuario();
            usuarioHumilde.setId_usuario(id);
            usuarioHumilde.setSenha(senha);

            try {
                dao.alterar(usuarioHumilde);
                response.sendRedirect("index.jsp");
            } catch (Exception ex) {
                Logger.getLogger(AlteraUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Editar/EditarUsuario.jsp");
            dispatcher.forward(request, response);
        }
    }
}
