package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.ClienteDAO;
import br.senac.tads3.pi03b.gruposete.dao.RelatorioDAO;
import br.senac.tads3.pi03b.gruposete.models.Cliente;
import br.senac.tads3.pi03b.gruposete.models.RelatorioMudancas;
import br.senac.tads3.pi03b.gruposete.services.ClienteService;
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
import javax.servlet.http.HttpSession;

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
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditarCliente.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClienteService service = new ClienteService();
        ClienteDAO dao = new ClienteDAO();
        
        RelatorioDAO relatorioDAO = new RelatorioDAO();
        RelatorioMudancas relatorio = new RelatorioMudancas();

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
        int id = Integer.parseInt(request.getParameter("identificacao"));

        request.setAttribute("erroNome", service.validaNome(nome));
        request.setAttribute("erroCpf", service.validaCpf(cpf));
        request.setAttribute("erroSexo", service.validaSexo(sexo));
        request.setAttribute("erroNascimento", service.validaNascimento(data_nasc));
        request.setAttribute("erroRua", service.validaRua(rua));
        request.setAttribute("erroNumero", service.validaNumero(numero));
        request.setAttribute("erroCep", service.validaCep(cep));
        request.setAttribute("erroCidade", service.validaCidade(cidade));
        request.setAttribute("erroEstado", service.validaEstado(estado));
        request.setAttribute("erroEmail", service.validaEmail(email));

        Cliente cliente = new Cliente(nome, cpf, sexo, data_nasc, numero,
                cep, rua, estado, cidade, complemento, celular,
                telefone, email, true);
        cliente.setId(id);

        if (service.validaCliente(nome, cpf, sexo, data_nasc, rua, numero, cep, cidade, estado, email)) {
            try {
                Cliente clientes = dao.getClienteById(id);
                request.setAttribute("clientes", clientes);
            } catch (ClassNotFoundException | SQLException e) {
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EditarCliente.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                dao.alterar(cliente);
                HttpSession sessao = request.getSession();
                int identificacaoF = (int) sessao.getAttribute("id_func");
                relatorio.setId_func(identificacaoF);
                relatorio.setMudanca("Alteração de cliente efetuada!");
                relatorioDAO.inserir(relatorio);
                response.sendRedirect(request.getContextPath() + "/inicio");
            } catch (Exception ex) {
                Logger.getLogger(AlteraClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
