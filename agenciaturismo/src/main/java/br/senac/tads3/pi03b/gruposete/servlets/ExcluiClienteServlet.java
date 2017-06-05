package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.dao.RelatorioDAO;
import br.senac.tads3.pi03b.gruposete.models.RelatorioMudancas;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/ExcluiClienteServlet")
public class ExcluiClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        ClienteDAO daoCliente = new ClienteDAO();
        if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                daoCliente.excluir(id);
                RelatorioDAO relatorioDAO = new RelatorioDAO();
                RelatorioMudancas relatorio = new RelatorioMudancas();
                relatorio.setId_funcionario(1);
                relatorio.setMudanca("Exclusão de cliente efetuada!");
                relatorioDAO.inserir(relatorio);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ExcluiClienteServlet.class.getName()).log(Level.SEVERE, null, ex); 
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ListaCliente.jsp");
            dispatcher.forward(request, response);
        }
    }
}
