package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.RelatorioDAO;
import br.senac.tads3.pi03b.gruposete.models.RelatorioMudancas;
import br.senac.tads3.pi03b.gruposete.models.RelatorioSLA;
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

@WebServlet(name = "ExcluiSLAServlet", urlPatterns = {"/ExcluiSLAServlet"})
public class ExcluiSLAServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(request.getParameter("id"));

            RelatorioDAO relatorioDAO = new RelatorioDAO();
            RelatorioMudancas relatorio = new RelatorioMudancas();
            RelatorioSLA relatorios = new RelatorioSLA();

            relatorioDAO.excluirSLA(id);

            HttpSession sessao = request.getSession();
            int identificacaoF = (int) sessao.getAttribute("id_func");
            relatorio.setId_func(identificacaoF);
            relatorio.setMudanca("Exclusão de chamado efetuado!");

            relatorioDAO.inserir(relatorio);

            response.sendRedirect(request.getContextPath() + "/inicio");

        } catch (SQLException | ClassNotFoundException ex) {

            Logger.getLogger(ExcluiSLAServlet.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {

            Logger.getLogger(ExcluiSLAServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
