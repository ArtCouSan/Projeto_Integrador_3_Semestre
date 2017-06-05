package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.HotelDAO;
import br.senac.tads3.pi03b.gruposete.models.Hotel;
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

@WebServlet(name = "BuscaHotelServlet", urlPatterns = {"/BuscaHotel"})
public class BuscaHotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/BuscaHotel.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HotelDAO dao = new HotelDAO();
        String pesquisa = request.getParameter("pesquisa");

        try {
           if ("".equals(pesquisa.trim())) {
                List<Hotel> encontrados = dao.ListarHotel();
                request.setAttribute("encontrados", encontrados);
                request.setAttribute("pesquisa", pesquisa);
            } else {
                List<Hotel> encontrados = dao.procurarHotel(pesquisa);
                request.setAttribute("encontrados", encontrados);
                request.setAttribute("pesquisa", pesquisa);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ListaHotel.jsp");
            dispatcher.forward(request, response);

        } catch (IOException | ServletException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CadastroHotelServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
