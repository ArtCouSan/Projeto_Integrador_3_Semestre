package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.models.Funcionario;
import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        if (sessao != null && sessao.getAttribute("usuario") != null) {
            response.sendRedirect(request.getContextPath() + "/index");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Login/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        FuncionarioDAO funcDAO = new FuncionarioDAO();

        Funcionario func = null;
        try {
            func = funcDAO.obterFuncionario(login, senha);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (func != null) {
            
            HttpSession sessao = request.getSession(false);
            
            if (sessao != null) {
                sessao.invalidate();
            }
            
            sessao = request.getSession(true);
            sessao.setAttribute("funcionario", func);

            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/jsp/Login/erroLogin.jsp");
        }
    }
}
