package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
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

@WebServlet(name = "PreVendaServlet", urlPatterns = {"/PreVenda"})
public class PreVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Venda/PreVenda.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean erro = true;

        ClienteDAO cliente = new ClienteDAO();

        String cpf = request.getParameter("cpf");

        boolean verificaCPF = false;
        
        try {
            
            verificaCPF = cliente.verificarCPF(cpf);
            
        } catch (SQLException | ClassNotFoundException ex) {
            
            Logger.getLogger(PreVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        if (cpf == null || !"   .   .   -  ".equals(cpf) || verificaCPF) {
            erro = true;
            request.setAttribute("erroCpf", true);
        }

        if (erro) {

            HttpSession sessao = request.getSession();
            sessao.setAttribute("cpf", cpf);
            response.sendRedirect("/jsp/Venda/Venda.jsp");

        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Venda/PreVenda.jsp");
            dispatcher.forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
