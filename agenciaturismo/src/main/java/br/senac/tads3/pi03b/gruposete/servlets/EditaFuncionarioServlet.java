package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Funcionario;
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

@WebServlet("/EditaFuncionarioServlet")
public class EditaFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        FuncionarioDAO dao = new FuncionarioDAO();

        String action = request.getParameter("action");

        if ("edit".equalsIgnoreCase(action)) {

            try {

                Funcionario funcionarios = dao.getFuncionarioById(id);

                request.setAttribute("funcionarios", funcionarios);

            } catch (SQLException | ClassNotFoundException ex) {

                Logger.getLogger(EditaFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Editar/EditarFuncionario.jsp");
            dispatcher.forward(request, response);

        }

    }

}
