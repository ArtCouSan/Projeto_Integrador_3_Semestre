package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.HotelDAO;
import br.senac.tads3.pi03b.gruposete.models.Hotel;
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

@WebServlet(name = "BuscaHotelServlet", urlPatterns = {"/BuscaHotel"})
public class BuscaHotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Buscar/BuscaHotel.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean erro = false;

        String busca = request.getParameter("pesquisa");

        if (!erro) {

            try {

                HotelDAO dao = new HotelDAO();
                List<Hotel> encontrados = dao.procurarHotel(busca);
                HttpSession sessao = request.getSession();
                sessao.setAttribute("encontrados", encontrados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaHotel.jsp");
                dispatcher.forward(request, response);

            } catch (IOException | ServletException ex) {

                Logger.getLogger(CadastroHotelServlet.class.getName()).log(Level.SEVERE, null, ex);

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(BuscaHotelServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaHotel.jsp");

            dispatcher.forward(request, response);

        }

    }

}
