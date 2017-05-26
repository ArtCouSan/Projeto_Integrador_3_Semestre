package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.UsuarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastroUsuarioServlet", urlPatterns = {"/CadastroUsuario"})
public class CadastroUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Cadastrar/CadastroUsuario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuarioDAO dao = new UsuarioDAO();
        boolean erro = false;

        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String acesso = request.getParameter("acesso");

        if (nome == null || nome.length() < 1) {
            erro = true;
            request.setAttribute("erroNome", true);
        }

        if (login == null || login.length() < 1) {
            erro = true;
            request.setAttribute("erroLogin", true);
        }

        if (senha == null || senha.length() < 4) {
            erro = true;
            request.setAttribute("erroSenha", true);
        }

        if (acesso == null || acesso.length() < 1) {
            erro = true;
            request.setAttribute("erroAcesso", true);
        }

        if (erro == false) {
            Usuario usuarioHumilde = new Usuario(nome, login, senha, acesso);
            
            try {
                dao.inserir(usuarioHumilde);
                response.sendRedirect("index.jsp");
            } catch (Exception ex) {
                Logger.getLogger(CadastroUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Cadastrar/CadastroUsuario.jsp");
            dispatcher.forward(request, response);
        }
    }
}
