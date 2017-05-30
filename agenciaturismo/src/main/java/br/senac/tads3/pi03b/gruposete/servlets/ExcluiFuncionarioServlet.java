package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Funcionario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/ExcluiFuncionarioServlet")
public class ExcluiFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String pesquisa = request.getParameter("pesquisa");
        FuncionarioDAO query = new FuncionarioDAO();
        if ("delete".equalsIgnoreCase(action)) {
            String cpf = request.getParameter("cpf");
            try {
                query.excluir(cpf);
                List<Funcionario> encontrados = query.procurarFuncionario(pesquisa);
                request.setAttribute("encontrados", encontrados);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ExcluiFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaFuncionario.jsp");
            dispatcher.forward(request, response);
        }
    }
}
