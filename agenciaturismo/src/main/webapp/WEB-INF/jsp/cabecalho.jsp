<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/foundation.min.css" />
        <link type="text/css"  href="./bootstrap/css/font-awesome.css" rel="stylesheet" />
        <title>Bem Vindo</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${funcionario.acesso == 'Master'}">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav">
                            <li ><i class="glyphicon glyphicon-user"><p style="color: white">${funcionario.nome}</p></i></li>
                            <li ><a href="CadastroCliente"><i class="glyphicon glyphicon-user"> Cadastrar Cliente</i></a></li>
                            <li ><a href="CadastroFuncionario"><i class="glyphicon glyphicon-briefcase"> Cadastrar Funcionário</i></a></li>
                            <li ><a href="CadastroHotel"><i class="glyphicon glyphicon-header"> Cadastrar Hoteis</i></a></li>
                            <li ><a href="CadastroVoo" ><i class="glyphicon glyphicon-plane"> Cadastrar Vôos</i></a></li>
                            <li ><a href="BuscaCliente"><i class="glyphicon glyphicon-search"> Buscar Cliente</i></a></li>
                            <li ><a href="BuscaFuncionario"><i class="glyphicon glyphicon-search"> Buscar Funcionários</i></a></li>
                            <li ><a href="BuscaHotel"><i class="glyphicon glyphicon-search"> Buscar Hotel</i></a></li>
                            <li ><a href="BuscaVoo"><i class="glyphicon glyphicon-search"> Buscar Vôo</i></a></li>
                            <li ><a href="PreVenda"><i class="glyphicon glyphicon-shopping-cart"> Vender</i></a></li>
                            <li ><a href="ApresentaBuscarRelatorio"><i class="glyphicon glyphicon-shopping-cart"> Buscar Vendas</i></a></li>
                            <li ><a href="ApresentaBusca3"><i class="glyphicon glyphicon-retweet"> Buscar Alterações</i></a></li>
                            <li ><a href="ApresentaBusca2"><i class="glyphicon glyphicon-list-alt"> Relatório de Vendas</i></a></li>
                            <li ><a href="CadastrarSLA"><i class="glyphicon glyphicon-envelope">  Chamar TI</i></a></li>
                            <li ><a href="ApresentaBuscaSLA"><i class="glyphicon glyphicon-copy">  Chamados TI</i></a></li>
                            <li ><a href="logout"><i class="glyphicon glyphicon-off">  Sair</i></a></li>
                        </ul>
                    </div>
                </nav>
            </c:when>
            <c:when test="${funcionario.acesso == 'Vendedor'}">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav">
                            <li ><i class="glyphicon glyphicon-user"><p style="color: white">${funcionario.nome}</p></i></li>
                            <li ><a href="CadastroCliente"><i class="glyphicon glyphicon-user"> Cadastrar Cliente</i></a></li>
                            <li ><a href="BuscaCliente"><i class="glyphicon glyphicon-search"> Buscar Clientes</i></a></li>
                            <li ><a href="BuscaHotel"><i class="glyphicon glyphicon-search"> Buscar Hoteis</i></a></li>
                            <li ><a href="BuscaVoo"><i class="glyphicon glyphicon-search"> Buscar Vôos</i></a></li>
                            <li ><a href="PreVenda"><i class="glyphicon glyphicon-shopping-cart"> Vender</i></a></li> 
                            <li ><a href="CadastrarSLA"><i class="glyphicon glyphicon-envelope">  Chamar TI</i></a></li>
                            <li ><a href="logout"><i class="glyphicon glyphicon-off"> Sair</i></a></li>
                        </ul>
                    </div>
                </nav>
            </c:when>
            <c:when test="${funcionario.acesso == 'Gerente_Venda'}">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav">
                            <li ><i class="glyphicon glyphicon-user"><p style="color: white">${funcionario.nome}</p></i></li>
                            <li ><a href="CadastroCliente"><i class="glyphicon glyphicon-user"> Cadastrar Cliente</i></a></li>
                            <li ><a href="BuscaCliente"><i class="glyphicon glyphicon-search"> Buscar Clientes</i></a></li>
                            <li ><a href="BuscaHotel"><i class="glyphicon glyphicon-search"> Buscar Hoteis</i></a></li>
                            <li ><a href="BuscaVoo"><i class="glyphicon glyphicon-search"> Buscar Vôos</i></a></li>
                            <li ><a href="PreVenda"><i class="glyphicon glyphicon-shopping-cart"> Vender</i></a></li>
                            <li ><a href="ApresentaBuscarRelatorio"><i class="glyphicon glyphicon-shopping-cart"> Buscar Vendas</i></a></li>
                            <li ><a href="ApresentaBusca3"><i class="glyphicon glyphicon-retweet"> Buscar Alterações</i></a></li>                            
                            <li ><a href="CadastrarSLA"><i class="glyphicon glyphicon-envelope">  Chamar TI</i></a></li>
                            <li ><a href="logout"><i class="glyphicon glyphicon-off"> Sair</i></a></li>
                        </ul>
                    </div>
                </nav>
            </c:when>
            <c:when test="${funcionario.acesso == 'Suporte_Informatica'}">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav">
                            <li ><i class="glyphicon glyphicon-user"><p style="color: white">${funcionario.nome}</p></i></li>
                            <li ><a href="CadastroFuncionario"><i class="glyphicon glyphicon-briefcase"> Cadastrar Funcionários</i></a></li>
                            <li ><a href="BuscaFuncionario"><i class="glyphicon glyphicon-search"> Buscar Funcionários</i></a></li> 
                            <li ><a href="ApresentaBuscaSLA"><i class="glyphicon glyphicon-copy">  Chamar TI</i></a></li>
                            <li ><a href="logout"><i class="glyphicon glyphicon-off"> Sair</i></a></li>
                        </ul>
                    </div>
                </nav>
            </c:when>
            <c:when test="${funcionario.acesso == 'Gerente_Informatica'}">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav">
                            <li ><i class="glyphicon glyphicon-user"><p style="color: white">${funcionario.nome}</p></i></li>
                            <li ><a href="CadastroFuncionario"><i class="glyphicon glyphicon-briefcase"> Cadastrar Funcionários</i></a></li>
                            <li ><a href="BuscaFuncionario"><i class="glyphicon glyphicon-search"> Buscar Funcionários</i></a></li>
                            <li ><a href="ApresentaBusca3"><i class="glyphicon glyphicon-search"> Buscar Alterações</i></a></li>
                            <li ><a href="ApresentaBuscaSLA"><i class="glyphicon glyphicon-copy">  Chamar TI</i></a></li>
                            <li ><a href="logout"><i class="glyphicon glyphicon-off"> Sair</i></a></li>
                        </ul>
                    </div>
                </nav>
            </c:when>
            <c:when test="${funcionario.acesso == 'Retaguarda'}">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav">
                            <li ><i class="glyphicon glyphicon-user"><p style="color: white">${funcionario.nome}</p></i></li>
                            <li ><a href="CadastroHotel"><i class="glyphicon glyphicon-header"> Cadastrar Hotel</i></a></li>
                            <li ><a href="CadastroVoo" ><i class="glyphicon glyphicon-plane"> Cadastrar Vôo</i></a></li>
                            <li ><a href="BuscaHotel"><i class="glyphicon glyphicon-search"> Buscar Hoteis</i></a></li>
                            <li ><a href="BuscaVoo"><i class="glyphicon glyphicon-search"> Buscar Vôs</i></a></li>
                            <li ><a href="CadastrarSLA"><i class="glyphicon glyphicon-envelope">  Chamar TI</i></a></li>
                            <li ><a href="logout"><i class="glyphicon glyphicon-off"> Sair</i></a></li>
                        </ul>
                    </div>
                </nav>
            </c:when>
            <c:when test="${funcionario.acesso == 'Gerente_Retaguarda'}">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav">
                            <li ><i class="glyphicon glyphicon-user"><p style="color: white">${funcionario.nome}</p></i></li>
                            <li ><a href="CadastroHotel"><i class="glyphicon glyphicon-header"> Cadastrar Hotel</i></a></li>
                            <li ><a href="CadastroVoo" ><i class="glyphicon glyphicon-plane"> Cadastrar Vôo</i></a></li>
                            <li ><a href="BuscaHotel"><i class="glyphicon glyphicon-search"> Buscar Hoteis</i></a></li>
                            <li ><a href="BuscaVoo"><i class="glyphicon glyphicon-search"> Buscar Vôos</i></a></li>
                            <li ><a href="ApresentaBusca3"><i class="glyphicon glyphicon-retweet"> Buscar Alterações</i></a></li>  
                            <li ><a href="CadastrarSLA"><i class="glyphicon glyphicon-envelope">  Chamar TI</i></a></li>
                            <li ><a href="logout"><i class="glyphicon glyphicon-off"> Sair</i></a></li>
                        </ul>
                    </div>
                </nav>
            </c:when>
        </c:choose>
    </body>
</html>
