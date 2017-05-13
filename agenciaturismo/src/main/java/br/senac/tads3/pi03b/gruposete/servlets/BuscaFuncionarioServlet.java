package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Funcionario;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "BuscaFuncionarioServlet", urlPatterns = {"/BuscaFuncionario"})
public class BuscaFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Buscar/BuscaFuncionario.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean erro = false;

        String busca = request.getParameter("pesquisa");
     
        if (!erro) {
           
            try {

                FuncionarioDAO dao = new FuncionarioDAO();
                List<Funcionario> encontrados = dao.procurarFuncionario(busca);
                HttpSession sessao = request.getSession();
                sessao.setAttribute("encontrados", encontrados);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaFuncionario.jsp");
                dispatcher.forward(request, response);

            } catch (IOException | ClassNotFoundException | SQLException ex) {

                Logger.getLogger(BuscaFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaFuncionario.jsp");
            dispatcher.forward(request, response);

        }
    }
}
