package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.RelatorioDAO;
import br.senac.tads3.pi03b.gruposete.dao.VooDAO;
import br.senac.tads3.pi03b.gruposete.models.RelatorioMudancas;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet("/ExcluiVooServlet")
public class ExcluiVooServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        VooDAO query = new VooDAO();

        RelatorioDAO relatorioDAO = new RelatorioDAO();
        RelatorioMudancas relatorio = new RelatorioMudancas();
        if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                query.excluir(id);
                HttpSession sessao = request.getSession();
                int identificacaoF = (int) sessao.getAttribute("id_func");
                relatorio.setId_func(identificacaoF);
                relatorio.setMudanca("Exclusão de vôo efetuada!");
                relatorioDAO.inserir(relatorio);

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/BuscarVoo.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(ExcluiVooServlet.class.getName()).log(Level.SEVERE, null, ex);

            } catch (Exception ex) {

                Logger.getLogger(ExcluiVooServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }
}
