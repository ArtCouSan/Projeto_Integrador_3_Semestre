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

@WebServlet("ExcluiHotelServlet")
public class ExcluiHotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        String pesquisa = request.getParameter("pesquisa");

        HotelDAO query = new HotelDAO();

        if ("edit".equalsIgnoreCase(action)) {

            int id = Integer.parseInt(request.getParameter("id"));

            try {

                query.excluirHotel(id);

                List<Hotel> encontrados = query.procurarHotel(pesquisa);

                request.setAttribute("encontrados", encontrados);

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(ExcluiHotelServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaHotel.jsp");
            dispatcher.forward(request, response);

        }

    }
}
