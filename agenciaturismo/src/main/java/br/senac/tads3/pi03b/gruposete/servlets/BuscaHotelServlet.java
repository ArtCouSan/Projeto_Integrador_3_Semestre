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

        String nome_hotel = request.getParameter("nome_hotel");
        String data_entrada = request.getParameter("data_entrada");
        String data_saida = request.getParameter("data_saida");

        int quantidade_quartos;
        try {
            quantidade_quartos = Integer.parseInt(request.getParameter("quantidade_quartos"));
        } catch (NumberFormatException e) {
            quantidade_quartos = 0;
        }

        int quantidade_hospedes;
        try {
            quantidade_hospedes = Integer.parseInt(request.getParameter("quantidade_hospedes"));
        } catch (NumberFormatException e) {
            quantidade_hospedes = 0;
        }

        float preco;
        try {
            preco = Float.parseFloat(request.getParameter("preco"));
        } catch (NumberFormatException e) {
            preco = 0;
        }

        if (!erro) {
            Hotel hotel = new Hotel(nome_hotel, data_entrada, data_saida, quantidade_quartos, quantidade_hospedes, preco, true);
            try {

                HotelDAO dao = new HotelDAO();
                List<Hotel> encontrados = dao.procurarHotel(hotel);
                HttpSession sessao = request.getSession();
                sessao.setAttribute("encontrados", encontrados);
                for (Hotel encontrado : encontrados) {
                    System.out.println(encontrado.getNome_hotel());
                    System.out.println(encontrado.getPreco());
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaHotel.jsp");
                dispatcher.forward(request, response);

            } catch (IOException | ServletException ex) {
                Logger.getLogger(CadastroHotelServlet.class.getName()).log(Level.SEVERE, null, ex);

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(BuscaHotelServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListarHotel.jsp");
            dispatcher.forward(request, response);
        }
    }
}
