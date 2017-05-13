package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.VooDAO;
import br.senac.tads3.pi03b.gruposete.models.Voo;
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

@WebServlet(name = "BuscaVooServlet", urlPatterns = {"/BuscaVoo"})
public class BuscaVooServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Buscar/BuscaVoo.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean erro = false;
        String origem = request.getParameter("origem");

        String destino = request.getParameter("destino");

        String data_ida = request.getParameter("data_ida");

        String data_volta = request.getParameter("data_volta");

        int quantidade_passagens;

        try {

            quantidade_passagens = Integer.parseInt(request.getParameter("quantidade_passagens"));

        } catch (NumberFormatException e) {

            quantidade_passagens = 0;

        }

        float preco;

        try {

            preco = Float.parseFloat(request.getParameter("preco"));

        } catch (NumberFormatException e) {

            preco = 0;

        }

        if (!erro) {

            try {
                Voo voo = new Voo(data_ida, data_volta, destino, origem, quantidade_passagens, preco, true);

                VooDAO dao = new VooDAO();

                List<Voo> encontrados;

                encontrados = dao.procurarVoo(voo);

                HttpSession sessao = request.getSession();

                sessao.setAttribute("encontrados", encontrados);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaVoo.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(BuscaVooServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaVoo.jsp");
            dispatcher.forward(request, response);

        }

    }
}
