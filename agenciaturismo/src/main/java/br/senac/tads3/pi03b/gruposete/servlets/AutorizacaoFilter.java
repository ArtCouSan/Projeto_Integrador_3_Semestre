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
            "AlteraUsuarioServlet",
            "AlteraVooServlet",
            "BuscaClienteServlet",
            "BuscaFuncionarioServlet",
            "BuscaHotelServlet",
            "BuscaUsuarioServlet",
            "BuscaVooServlet",
            "CadastroClienteServlet",
            "CadastroFuncionarioServlet",
            "CadastroHotelServlet",
            "CadastroUsuarioServlet",
            "CadastroVooServlet",
            "ExcluiClienteServlet",
            "ExcluiFuncionarioServlet",
            "ExcluiHotelServlet",
            "ExcluiUsuarioServlet",
            "ExcluiVooServlet",
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
            httpResponse.sendRedirect(httpRequest.getContextPath() + "WEB-INF/jsp/erroNaoAutorizado.jsp");
        }
    }

    private static boolean verificarAcesso(Funcionario func, HttpServletRequest request, HttpServletResponse response) {
        String paginaAcessada = request.getRequestURI();
        String pagina = paginaAcessada.replace(request.getContextPath(), "");
        if (pagina.endsWith("") && func.temPapel("MASTER")) {
            return true;
        } else if (pagina.contains("Cliente") || pagina.contains("BuscaVoo") || pagina.contains("BuscaHotel") && func.temPapel("BASICO")) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {

    }

}
