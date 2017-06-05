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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        if (sessao != null && sessao.getAttribute("usuario") != null) {
            response.sendRedirect(request.getContextPath() + "/inicio");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        FuncionarioDAO funcDAO = new FuncionarioDAO();

        HttpSession sessao;
        try {
            Funcionario func = funcDAO.obterFuncionario(usuario, senha);
            if (func != null) {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> achou usuario");
                sessao = request.getSession(true);
                sessao.setAttribute("funcionario", func);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
                dispatcher.forward(request, response);
            } else {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> nao achou");
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/erroLogin.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
