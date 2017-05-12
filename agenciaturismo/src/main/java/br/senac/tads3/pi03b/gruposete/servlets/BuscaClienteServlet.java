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
import javax.servlet.http.HttpSession;

@WebServlet(name = "BuscaClienteServlet", urlPatterns = {"/BuscaCliente"})
public class BuscaClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Buscar/BuscaCliente.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean erro = false;

        String nome = request.getParameter("nome");

        String cpf = request.getParameter("cpf");

        String sexo = request.getParameter("sexo");

        String data_nasc = request.getParameter("nascimento");

        String telefone = request.getParameter("telefone");

        String celular = request.getParameter("celular");

        String email = request.getParameter("email");

        int numero;

        try {

            numero = Integer.parseInt(request.getParameter("numero"));

        } catch (NumberFormatException e) {

            numero = 0;

        }

        String cep = request.getParameter("cep");

        String rua = request.getParameter("rua");

        String bairro = request.getParameter("bairro");

        String cidade = request.getParameter("cidade");

        String logradouro = request.getParameter("logradouro");

        String complemento = request.getParameter("complemento");

        if (!erro) {

            Cliente cliHumilde = new Cliente(nome, cpf, sexo, data_nasc, numero,
                    cep, rua, bairro, cidade, logradouro, complemento, celular,
                    telefone, email, true);

            try {
                ClienteDAO dao = new ClienteDAO();
                List<Cliente> encontrados = dao.procurarCliente(cliHumilde);
                request.getServletContext.setAttribute("encontrados", encontrados);
                for (Cliente encontrado : encontrados) {
                    System.out.println(encontrado.getBairro());
                    System.out.println(encontrado.getNome());
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListaCliente.jsp");
                dispatcher.forward(request, response);

            } catch (IOException | SQLException | ClassNotFoundException ex) {

                Logger.getLogger(BuscaClienteServlet.class.getName()).log(Level.SEVERE, null, ex);

            }

        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Listar/ListarCliente.jsp");

            dispatcher.forward(request, response);

        }
    }

}
