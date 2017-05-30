package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.dao.VendaDAO;
import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.models.Venda;
import java.io.FileNotFoundException;
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

@WebServlet("/VendaServlet")
public class VendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {

        String cpf = request.getParameter("cpf");
        ClienteDAO clienteData = new ClienteDAO();
        Cliente cliente = null;
        try {
            cliente = clienteData.getClienteByCPF(cpf);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        double totalP = Double.parseDouble(request.getParameter("totalP"));
        Venda venda = new Venda(cliente.getId_cliente(), 2, totalP);
        VendaDAO vendaData = new VendaDAO();
        try {
            vendaData.inserir(venda);
        } catch (SQLException | ClassNotFoundException ex) {
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

        String[] idsV = idsVoos.split(",");
        String[] precosV = precosVoos.split(",");
        String[] quantidadesV = quantidadeVoos.split(",");
        String[] idsH = idsHoteis.split(",");
        String[] precosH = precosHoteis.split(",");
        String[] quantidadesH = quantidadeHoteis.split(",");

        for (int i = 0; i < idsV.length; i++) {

            try {

                int idV = Integer.parseInt(idsV[i]);
                int quantidadeV = Integer.parseInt(quantidadesV[i]);
                float precoV = Float.parseFloat(precosV[i]);

                vendaData.inserirLista(idV, quantidadeV, precoV, idLista);

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        for (int i = 0; i < idsH.length; i++) {

            try {

                int idH = Integer.parseInt(idsH[i]);
                int quantidadeH = Integer.parseInt(quantidadesH[i]);
                float precoH = Float.parseFloat(precosH[i]);

                vendaData.inserirLista(idH, quantidadeH, precoH, idLista);

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(VendaServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
        
        System.out.println("Chegou");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index");
        dispatcher.forward(request, response);
    }

}
