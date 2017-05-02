package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.models.Contato;
import br.senac.tads3.pi03b.gruposete.models.Endereco;
import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.models.Pessoa;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {
    
    private ClienteDAO dao;
    public static final String LIST = "WEB-INF/jsp/listarClientes.jsp";
    public static final String INSERT_OR_EDIT = "WEB-INF/jsp/cadastrarCliente.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            forward = LIST;
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                dao.excluir(id);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                request.setAttribute("clientes", dao.getListaClientes());
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("edit".equalsIgnoreCase(action)) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Cliente cliente = null;
            try {
                cliente = dao.getClienteById(id);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("cliente", cliente);
        } else if ("insert".equalsIgnoreCase(action)) {
            forward = INSERT_OR_EDIT;
        } else {
            forward = LIST;
            try {
                request.setAttribute("clientes", dao.getListaClientes());
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean erro = false;

        //Contato
        String telefone = request.getParameter("telefone");
        if (telefone == null || !"     -    ".equals(telefone)) {
            erro = true;
            request.setAttribute("erroTelefone", true);
        }
        String celular = request.getParameter("celular");
        if (celular == null || !"     -    ".equals(celular)) {
            erro = true;
            request.setAttribute("erroCelular", true);
        }
        String email = request.getParameter("email");
        if (email == null || !email.contains("@") && !email.contains(".com") || !email.contains(".com.br")) {
            erro = true;
            request.setAttribute("erroEmail", true);
        }
        String dd_telefone = request.getParameter("dd_telefone");
        if (dd_telefone == null || !"(  )".equals(dd_telefone)) {
            erro = true;
            request.setAttribute("erroDd_telefone", true);
        }
        String dd_celular = request.getParameter("dd_celular");
        if (dd_celular == null || !"(  )".equals(dd_celular)) {
            erro = true;
            request.setAttribute("erroDd_celular", true);
        }

        //Endereço
        String rua = request.getParameter("rua");
        if (rua == null || rua.length() < 1) {
            erro = true;
            request.setAttribute("erroRua", true);
        }
        int numero = Integer.parseInt(request.getParameter("numero"));
        if (numero <= 0) {
            erro = true;
            request.setAttribute("erroNumero", true);
        }
        String complemento = request.getParameter("complemento");
        if (complemento == null || complemento.length() < 1) {
            erro = true;
            request.setAttribute("erroComplemento", true);
        }
        String logradouro = request.getParameter("logradouro");
        if (logradouro == null || logradouro.length() < 1) {
            erro = true;
            request.setAttribute("erroLogradouro", true);
        }
        String cep = request.getParameter("cep");
        if (cep == null || !"     -   ".equals(cep)) {
            erro = true;
            request.setAttribute("erroCep", true);
        }
        String cidade = request.getParameter("cidade");
        if (cidade == null || cidade.length() < 1) {
            erro = true;
            request.setAttribute("erroCidade", true);
        }
        String bairro = request.getParameter("bairro");
        if (bairro == null || bairro.length() < 1) {
            erro = true;
            request.setAttribute("erroBairro", true);
        }

        //Pessoa
        String nome = request.getParameter("nome");
        if (nome == null || nome.length() < 1) {
            erro = true;
            request.setAttribute("erroNome", true);
        }
        String cpf = request.getParameter("cpf");
        if (cpf == null || !"   .   .   -  ".equals(cpf)) {
            erro = true;
            request.setAttribute("erroCpf", true);
        }
        char sexo = request.getParameter("sexo").charAt(0);
        if ("".equals(sexo)) {
            erro = true;
            request.setAttribute("erroSexo", true);
        }
        String nascimento = request.getParameter("nascimento");
        if (nascimento == null || !"  /  /    ".equals(nascimento)) {
            erro = true;
            request.setAttribute("erroNascimento", true);
        }

        if (!erro) {
            Contato contato = new Contato(celular, telefone, email, dd_telefone, dd_celular);
            Endereco endereco = new Endereco(numero, cep, rua, bairro, cidade, logradouro, complemento);
            Pessoa pessoa = new Pessoa(nome, cpf, sexo, nascimento, contato, endereco);
            Cliente cliente = new Cliente(true, pessoa);

            try {
                dao.inserir(cliente);
            } catch (Exception ex) {
                Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            HttpSession sessao = request.getSession();
            sessao.setAttribute("novoCliente", cliente);
            response.sendRedirect("resultado.jsp");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("entrada.jsp");
            dispatcher.forward(request, response);
        }
    }
}
