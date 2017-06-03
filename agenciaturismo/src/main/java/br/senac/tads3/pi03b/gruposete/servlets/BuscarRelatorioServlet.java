package br.senac.tads3.pi03b.gruposete.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BuscarRelatorioServlet", urlPatterns = {"/BuscarRelatorio"})
public class BuscarRelatorioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String inicio = request.getParameter("inicio");

        String fim = request.getParameter("fim");

        System.out.println("<><><><><><><>");

    }

}
