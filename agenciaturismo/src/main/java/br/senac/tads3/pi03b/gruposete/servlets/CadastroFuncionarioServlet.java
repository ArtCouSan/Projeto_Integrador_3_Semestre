package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.dao.FuncionarioDAO;
import br.senac.tads3.pi03b.gruposete.models.Funcionario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CadastroFuncionarioServlet", urlPatterns = {"/CadastroFuncionario"})
public class CadastroFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Cadastrar/CadastroFuncionario.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FuncionarioDAO dao = new FuncionarioDAO();

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
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String complemento = request.getParameter("complemento");
        String cargo = request.getParameter("cargo");
        String filial = request.getParameter("filial");
        String departamento = request.getParameter("departamento");
        
//        if (nome == null || nome.length() < 1) {
//            erro = true;
//            request.setAttribute("erroNome", true);
//        }
//        if (numero <= 0) {
//            erro = true;
//            request.setAttribute("erroNumero", true);
//        }
//        if (rua == null || rua.length() < 1) {
//            erro = true;
//            request.setAttribute("erroRua", true);
//        }
//        if (bairro == null || bairro.length() < 1) {
//            erro = true;
//            request.setAttribute("erroBairro", true);
//        }
//        if (cidade == null || cidade.length() < 1) {
//            erro = true;
//            request.setAttribute("erroCidade", true);
//        }
//        if (complemento == null || complemento.length() < 1) {
//            erro = true;
//            request.setAttribute("erroComplemento", true);
//        }
//        if (cargo == null || cargo.length() < 1) {
//            erro = true;
//            request.setAttribute("erroCargo", true);
//        }
//        if (filial == null || filial.length() < 1) {
//            erro = true;
//            request.setAttribute("erroFilial", true);
//        }
//        if (departamento == null || departamento.length() < 1) {
//            erro = true;
//            request.setAttribute("erroDepartamento", true);
//        }

        if (erro != true) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> func");
            Funcionario func = new Funcionario(nome, cpf, sexo, data_nasc,
                    numero, cep, rua, bairro, cidade, complemento,
                    celular, telefone, email, true, cargo, filial, departamento);
            try {
                dao.inserir(func);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> cadastrou");
                response.sendRedirect("index.jsp");
            } catch (Exception ex) {
                Logger.getLogger(CadastroFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Cadastrar/CadastroFuncionario.jsp");
            dispatcher.forward(request, response);
        }
    }
}
