package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import br.senac.tads3.pi03b.gruposete.dao.RelatorioDAO;
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
import javax.servlet.http.HttpSession;

@WebServlet("/ExcluiFuncionarioServlet")
public class ExcluiFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        FuncionarioDAO query = new FuncionarioDAO();

        RelatorioDAO relatorioDAO = new RelatorioDAO();
        RelatorioMudancas relatorio = new RelatorioMudancas();

        if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                query.excluir(id);
                HttpSession sessao = request.getSession();
                int identificacaoF = (int) sessao.getAttribute("id_func");
                relatorio.setId_func(identificacaoF);
                relatorio.setMudanca("Exclusão de funcionario efetuada!");
                relatorioDAO.inserir(relatorio);

            } catch (ClassNotFoundException | SQLException ex) {

                Logger.getLogger(ExcluiFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);

            } catch (Exception ex) {
                Logger.getLogger(ExcluiFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            response.sendRedirect(request.getContextPath() + "/inicio");

        }
    }
}
