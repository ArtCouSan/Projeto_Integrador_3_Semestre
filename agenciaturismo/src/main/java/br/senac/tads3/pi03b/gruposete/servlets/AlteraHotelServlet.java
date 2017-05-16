package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.HotelDAO;
import br.senac.tads3.pi03b.gruposete.models.Hotel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AlteraHotelServlet", urlPatterns = {"/EditarHotel"})
public class AlteraHotelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HotelDAO dao = new HotelDAO();

        String action = request.getParameter("action");

        if ("edit".equalsIgnoreCase(action)) {

            try {

                Hotel hoteis = dao.getHotelById(id);

                request.setAttribute("hoteis", hoteis);

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(AlteraHotelServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Editar/EditarHotel.jsp");
            dispatcher.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean erro = false;

        String nome_hotel = request.getParameter("nome_hotel");
        if (nome_hotel == null || nome_hotel.length() < 1) {
            erro = true;
            request.setAttribute("erroNome_hotel", true);
        }
        String data_entrada = request.getParameter("data_entrada");
        if (data_entrada == null || !"  /  /    ".equals(data_entrada)) {
            erro = true;
            request.setAttribute("erroData_entrada", true);
        }
        String data_saida = request.getParameter("data_saida");
        if (data_saida == null || !"  /  /    ".equals(data_saida)) {
            erro = true;
            request.setAttribute("erroData_saida", true);
        }
        int quantidade_quartos = Integer.parseInt(request.getParameter("quantidade_quartos"));
        if (quantidade_quartos < 1) {
            erro = true;
            request.setAttribute("erroQuantidade_quartos", true);
        }
        int quantidade_hospedes = Integer.parseInt(request.getParameter("quantidade_hospedes"));
        if (quantidade_hospedes < 1) {
            erro = true;
            request.setAttribute("erroQuantidade_hospedes", true);
        }
        float preco = Float.parseFloat(request.getParameter("preco"));
        if (preco < 0) {
            erro = true;
            request.setAttribute("erroPreco", true);
        }

        int id = Integer.parseInt(request.getParameter("identificacao"));

        if (!erro) {
            Hotel hotel = new Hotel(nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes, preco, true);
            hotel.setId_hotel(id);
            try {
                HotelDAO dao = new HotelDAO();
                dao.alterar(hotel);
                HttpSession sessao = request.getSession();
                sessao.setAttribute("editarHotel", hotel);
                response.sendRedirect("index.jsp");

            } catch (Exception ex) {

            }

        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Editar/EditarHotel.jsp");

            dispatcher.forward(request, response);

        }

    }

}
