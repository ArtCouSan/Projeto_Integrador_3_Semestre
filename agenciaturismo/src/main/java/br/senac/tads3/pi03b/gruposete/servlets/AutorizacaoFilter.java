package br.senac.tads3.pi03b.gruposete.servlets;

import br.senac.tads3.pi03b.gruposete.models.Funcionario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AutorizacaoFilter",
        servletNames = {
            "AlteraClienteServlet",
            "AlteraFuncionarioServlet",
            "AlteraHotelServlet",
            "AlteraVooServlet",
            "ApresentaBusca3Servlet",
            "ApresentaBuscaFeedback",
            "ApresentaVendaServlet",
            "BuscaClienteServlet",
            "BuscaFuncionarioServlet",
            "BuscaHotelServlet",
            "BuscaHotelVendaServlet",
            "BuscaVendaServlet",
            "BuscaVooServlet",
            "BuscaVooVendaServlet",
            "BuscarFeedback",
            "BuscarRelatorio",
            "BuscarRelatorioMudanca",
            "CadastroClienteServlet",
            "CadastroFuncionarioServlet",
            "CadastroHotelServlet",
            "CadastroVooServlet",
            "ErroLoginServlet",
            "ExcluiClienteServlet",
            "ExcluiFuncionarioServlet",
            "ExcluiHotelServlet",
            "ExcluiVooServlet",
            "FeedbackServlet",
            "InicioServlet",
            "LoginServlet",
            "LogoutServlet",
            "PreVendaServlet",
            "VendaServlet"},
        urlPatterns = {"/protegido/*"}
)
public class AutorizacaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession sessao = httpRequest.getSession();
        Funcionario func = (Funcionario) sessao.getAttribute("funcionario");
        if (func == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        if (verificarAcesso(func, httpRequest, httpResponse)) {
            chain.doFilter(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/erroNaoAutorizado.jsp");
            dispatcher.forward(request, response);
        }
    }

    private static boolean verificarAcesso(Funcionario func, HttpServletRequest request, HttpServletResponse response) {
        String paginaAcessada = request.getRequestURI();
        String pagina = paginaAcessada.replace(request.getContextPath(), "");
        //master
        if (pagina.endsWith("") && func.temPapel("Master")) {
            return true;
        } //Vendedor
        else if (pagina.contains("inicio") || pagina.contains("Cliente") || pagina.contains("BuscaVoo")
                || pagina.contains("BuscaHotel") || pagina.contains("CadastrarSLA")
                || pagina.contains("Venda") && func.temPapel("Vendedor")) {
            return true;
        } //Gerente Venda
        else if (pagina.contains("inicio") || pagina.contains("Cliente") || pagina.contains("BuscaHotel")
                || pagina.contains("BuscaVoo") || pagina.contains("Venda") || pagina.contains("CadastrarSLA")
                || pagina.contains("ApresentaBuscarRelatorio") || pagina.contains("ApresentaBusca2")
                || pagina.contains("BuscarRelatorio") || pagina.contains("ApresentaBusca3")
                || pagina.contains("BuscarRelatorioMudanca") && func.temPapel("Gerente_Venda")) {
            return true;
        } //Suporte Informatica 
        else if (pagina.contains("inicio") || pagina.contains("Funcionario")
                || pagina.contains("ApresentaBuscaSLA") && func.temPapel("Suporte_Informatica")) {
            return true;
        } //Gerente Informatica
        else if (pagina.contains("inicio") || pagina.contains("Funcionario")
                || pagina.contains("ApresentaBuscaSLA") || pagina.contains("BuscarRelatorioMudanca")
                || pagina.contains("ApresentaBusca3") && func.temPapel("Gerente_Informatica")) {
            return true;
        } //Retaguarda
        else if (pagina.contains("inicio") || pagina.contains("Hotel") || pagina.contains("Voo")
                || pagina.contains("CadastrarSLA") && func.temPapel("Retaguarda")) {
            return true;
        } //Gerente Retaguarda
        else if (pagina.contains("inicio") || pagina.contains("Hotel") || pagina.contains("Voo")
                || pagina.contains("ApresentaBusca3") || pagina.contains("CadastrarSLA")
                || pagina.contains("BuscarRelatorioMudanca") && func.temPapel("Gerente_Retaguarda")) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {

    }

}
