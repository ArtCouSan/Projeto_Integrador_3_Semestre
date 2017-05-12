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
            response.sendRedirect(request.getContextPath() + "/index.html");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Login/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("login");
        String senhaDigitada = request.getParameter("senha");

        Usuario user = Usuario.obterUsuario(usuario, senhaDigitada);
        if (user != null) {
            HttpSession sessao = request.getSession(false);
            if (sessao != null) {
                sessao.invalidate();
            }
            
            sessao = request.getSession(true);
            sessao.setAttribute("usuario", user);

            response.sendRedirect(request.getContextPath() + ">>>>>>>>>>>TELA MENU AQUI<<<<<<<<<<<<<");
        } else {
            response.sendRedirect(request.getContextPath() + ">>>>>>>>>>>ERRO<<<<<<<<<<<<<<<");
        }
    }
}
