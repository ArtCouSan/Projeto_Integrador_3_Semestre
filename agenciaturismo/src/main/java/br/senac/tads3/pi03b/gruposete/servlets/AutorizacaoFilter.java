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
        if (pagina.endsWith("") && func.temPapel("Master")) {
            return true;
        } else if (pagina.contains("inicio") || pagina.contains("Cliente") || pagina.contains("BuscaVoo")
                || pagina.contains("BuscaHotel") || pagina.contains("FeedbackServlet")
                || pagina.contains("Venda") && func.temPapel("Vendedor")) {
            return true;
        } else if (pagina.contains("inicio") || pagina.contains("Cliente") || pagina.contains("Hotel")
                || pagina.contains("Voo") || pagina.contains("Venda")
                || pagina.contains("ApresentaBuscarRelatorio") || pagina.contains("ApresentaBuscar3")
                && func.temPapel("Gerente_Venda")) {
            return true;
        } else if (pagina.contains("inicio") || pagina.contains("Funcionario") && func.temPapel("Suporte_Informatica")) {
            return true;
        } else if (pagina.contains("inicio") || pagina.contains("Funcionario") || pagina.contains("ApresentaBuscar3")
                && func.temPapel("Gerente_Informatica")) {
            return true;
        } else if (pagina.contains("inicio") || pagina.contains("Hotel") || pagina.contains("Voo")
                || pagina.contains("FeedbackServlet") && func.temPapel("Retaguarda")) {
            return true;
        } else if (pagina.contains("inicio") || pagina.contains("Hotel") || pagina.contains("Voo")
                || pagina.contains("ApresentaBuscar3") && func.temPapel("Gerente_Retaguarda")) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {

    }

}
