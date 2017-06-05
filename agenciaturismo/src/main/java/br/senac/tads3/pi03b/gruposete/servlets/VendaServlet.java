package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.dao.HotelDAO;
import br.senac.tads3.pi03b.gruposete.dao.RelatorioDAO;
import br.senac.tads3.pi03b.gruposete.dao.VendaDAO;
import br.senac.tads3.pi03b.gruposete.dao.VooDAO;
import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.models.Hotel;
import br.senac.tads3.pi03b.gruposete.models.RelatorioMudancas;
import br.senac.tads3.pi03b.gruposete.models.Venda;
import br.senac.tads3.pi03b.gruposete.models.Voo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VendaServlet")
public class VendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {

        double totalP = Double.parseDouble(request.getParameter("totalP"));

        if (totalP != 0) {

            String cpf = request.getParameter("cpf");
            ClienteDAO clienteData = new ClienteDAO();
            Cliente cliente = null;

            try {

                cliente = clienteData.getClienteByCPF(cpf);

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            Venda venda = new Venda(cliente.getId_cliente(), 2, totalP);

            VendaDAO vendaData = new VendaDAO();

            try {

                vendaData.inserir(venda);
                RelatorioDAO relatorioDAO = new RelatorioDAO();
                RelatorioMudancas relatorio = new RelatorioMudancas();
                relatorio.setId_funcionario(1);
                relatorio.setMudanca("Venda efetuada!");
                relatorioDAO.inserir(relatorio);

            } catch (SQLException | ClassNotFoundException | ParseException ex) {

                Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            int idLista = 0;

            try {

                idLista = vendaData.maiorIdVenda();

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            String idsVoos = request.getParameter("idsVoos");
            String idsHoteis = request.getParameter("idsHoteis");
            String precosVoos = request.getParameter("precosVoos");
            String precosHoteis = request.getParameter("precosHoteis");
            String quantidadeVoos = request.getParameter("quantidadeVoos");
            String quantidadeHoteis = request.getParameter("quantidadeHoteis");

            if (idsVoos.length() != 0) {

                String[] idsV = idsVoos.split(",");
                String[] precosV = precosVoos.split(",");
                String[] quantidadesV = quantidadeVoos.split(",");

                for (int i = 0; i < idsV.length; i++) {

                    try {

                        VooDAO voo = new VooDAO();

                        int idV = Integer.parseInt(idsV[i]);

                        Voo vooEncontrado = voo.getVooById(idV);
                        int qtd_encontradaV = vooEncontrado.getQuantidade_passagens();

                        int quantidadeV = Integer.parseInt(quantidadesV[i]);
                        float precoV = Float.parseFloat(precosV[i]);

                        int novaQtdVoo = qtd_encontradaV - quantidadeV;

                        vendaData.inserirLista(idV, quantidadeV, precoV, idLista, "V");

                        vendaData.removerEstoqueVoo(idV, novaQtdVoo);

                    } catch (SQLException | ClassNotFoundException ex) {

                        Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

            if (idsHoteis.length() != 0) {

                String[] idsH = idsHoteis.split(",");
                String[] precosH = precosHoteis.split(",");
                String[] quantidadesH = quantidadeHoteis.split(",");

                for (int i = 0; i < idsH.length; i++) {

                    try {

                        HotelDAO hotel = new HotelDAO();

                        int idH = Integer.parseInt(idsH[i]);

                        Hotel hotelEncontrado = hotel.getHotelById(idH);
                        int qtd_encontradaH = hotelEncontrado.getQuantidade_quartos();

                        int quantidadeH = Integer.parseInt(quantidadesH[i]);
                        float precoH = Float.parseFloat(precosH[i]);

                        int novaQtdHotel = qtd_encontradaH - quantidadeH;

                        vendaData.inserirLista(idH, quantidadeH, precoH, idLista, "H");

                        vendaData.removerEstoqueHotel(idH, novaQtdHotel);

                    } catch (SQLException | ClassNotFoundException ex) {

                        Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);

                    }

                }

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
            dispatcher.forward(request, response);

        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
            dispatcher.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index");
        dispatcher.forward(request, response);
    }

}
