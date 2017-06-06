package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.RelatorioDAO;
import br.senac.tads3.pi03b.gruposete.models.RelatorioFeed;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FeedbackServlet", urlPatterns = {"/FeedbackServlet"})
public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/FeedbackSuporte.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mensagem = request.getParameter("mensagem");

        String okay = mensagem.trim();

        if (okay.length() <= 1040 && okay.length() >= 1) {

            RelatorioFeed feed = new RelatorioFeed();

            HttpSession sessao = request.getSession();
            int identificacaoF = (int) sessao.getAttribute("id_func");
            feed.setId_func(identificacaoF);

            feed.setMensagem(mensagem);

            RelatorioDAO dao = new RelatorioDAO();

            try {
                
                dao.feed(feed);

            } catch (Exception ex) {

                Logger.getLogger(FeedbackServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
            dispatcher.forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
