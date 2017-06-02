package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.models.Cliente;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AlteraClienteServlet", urlPatterns = {"/EditarCliente"})
public class AlteraClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ClienteDAO dao = new ClienteDAO();
        String action = request.getParameter("action");
        if ("edit".equalsIgnoreCase(action)) {
            try {
                Cliente clientes = dao.getClienteById(id);
                request.setAttribute("clientes", clientes);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AlteraClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Editar/EditarCliente.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClienteDAO dao = new ClienteDAO();
        boolean erro = false, verifica = false;

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
        String data_nasc = request.getParameter("nascimento");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String complemento = request.getParameter("complemento");

//        if (nome == null || nome.length() < 1) {
//            erro = true;
//            request.setAttribute("erroNome", true);
//        }
//
//        if (numero <= 0) {
//            erro = true;
//            request.setAttribute("erroNumero", true);
//        }
//
//        if (rua == null || rua.length() < 1) {
//            erro = true;
//            request.setAttribute("erroRua", true);
//        }
//
//        if (estado == null || estado.length() < 1) {
//            erro = true;
//            request.setAttribute("erroEstado", true);
//        }
//
//        if (cidade == null || cidade.length() < 1) {
//            erro = true;
//            request.setAttribute("erroCidade", true);
//        }
//
//        if (complemento == null || complemento.length() < 1) {
//            erro = true;
//            request.setAttribute("erroComplemento", true);
//        }
//
//        if (telefone == null || !"(  )    -    ".equals(telefone)) {
//            erro = true;
//            request.setAttribute("erroTelefone", true);
//        }
//
//        if (celular == null || !"(  )     -    ".equals(celular)) {
//            erro = true;
//            request.setAttribute("erroCelular", true);
//        }
//
//        if (email == null || !email.contains("@") && !email.contains(".com") || !email.contains(".com.br")) {
//            erro = true;
//            request.setAttribute("erroEmail", true);
//        }
//        
//        try {
//            verifica = dao.verificarCPF(cpf);
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(AlteraFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (cpf == null || !"   .   .   -  ".equals(cpf)) {
//            erro = true;
//            request.setAttribute("erroCpf", true);
//        }
//
//        if (cep == null || !"     -   ".equals(cep)) {
//            erro = true;
//            request.setAttribute("erroCep", true);
//        }

        int id = Integer.parseInt(request.getParameter("identificacao"));

        if (erro == false) {
            Cliente cliente = new Cliente(nome, cpf, sexo, data_nasc, numero,
                    cep, rua, estado, cidade, complemento, celular,
                    telefone, email, true);
            cliente.setId_cliente(id);

            try {
                dao.alterar(cliente);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Layout/index.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AlteraClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Editar/EditarCliente.jsp");
            dispatcher.forward(request, response);
        }
    }
}
