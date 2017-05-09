package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.models.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        if (sessao != null && sessao.getAttribute("usuario") != null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("login");
        String senhaDigitada = request.getParameter("senha");

        Usuario usuarioSistema = Usuario.obterUsuario(usuario, senhaDigitada);
        if (usuarioSistema != null) {
            HttpSession sessao = request.getSession(false);
            if (sessao != null) {
                sessao.invalidate();
            }
            
            sessao = request.getSession(true);
            sessao.setAttribute("usuario", usuarioSistema);

            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/erroLogin.jsp");
        }
    }
}
