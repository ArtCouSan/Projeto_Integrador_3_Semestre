/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.models.Cliente;
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

/**
 *
 * @author Rafael
 */
@WebServlet(name = "ListaClienteServlet", urlPatterns = {"/lista-cliente"})
public class ListaClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            List<Cliente> lista = clienteDAO.ListaCliente();
            request.setAttribute("listaClientes", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ListaCliente.jsp");
            dispatcher.forward(request, response);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
