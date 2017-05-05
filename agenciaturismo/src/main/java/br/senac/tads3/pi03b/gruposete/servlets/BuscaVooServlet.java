package br.senac.tads3.pi03b.gruposete.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BuscaVooServlet", urlPatterns = {"/busca-voo"})
public class BuscaVooServlet extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Buscar/BuscaVoo.jsp");
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Codigo buscar Cliente
    }
}
