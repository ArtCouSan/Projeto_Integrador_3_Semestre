package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.services.ClienteService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CadastroClienteServlet", urlPatterns = {"/CadastroCliente"})
public class CadastroClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/CadastroCliente.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClienteService service = new ClienteService();
        ClienteDAO dao = new ClienteDAO();

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

        Cliente cliente = new Cliente(nome, cpf, sexo, data_nasc, numero,
                cep, rua, estado, cidade, complemento, celular,
                telefone, email, true);

        if (service.validaCliente(cliente)) {
            try {
                dao.inserir(cliente);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Layout/index.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(CadastroClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("erroNome", service.validaNome(nome));
            request.setAttribute("erroNumero", service.validaNumero(numero));
            request.setAttribute("erroRua", service.validaRua(rua));
            request.setAttribute("erroCidade", service.validaCidade(cidade));
            request.setAttribute("erroCep", service.validaCep(cep));
            request.setAttribute("erroCpf", service.validaCpf(cpf));
            request.setAttribute("erroEmail", service.validaEmail(email));
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Cadastrar/CadastroCliente.jsp");
            dispatcher.forward(request, response);
        }
    }
}
