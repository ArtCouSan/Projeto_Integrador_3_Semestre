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
            <c:when test="${funcionario.acesso == 'MASTER'}">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav">
                            <li ><i class="glyphicon glyphicon-user"><p style="color: white">${funcionario.nome}</p></i></li>
                            <li ><a href="CadastroCliente"><i class="glyphicon glyphicon-user"> Cadastrar Cliente</i></a></li>
                            <li ><a href="CadastroFuncionario"><i class="glyphicon glyphicon-briefcase"> Cadastrar Funcionario</i></a></li>
                            <li ><a href="CadastroHotel"><i class="glyphicon glyphicon-header"> Cadastrar Hotel</i></a></li>
                            <li ><a href="CadastroVoo" ><i class="glyphicon glyphicon-plane"> Cadastrar Voo</i></a></li>
                            <li ><a href="BuscaCliente"><i class="glyphicon glyphicon-search"> Busca Cliente</i></a></li>
                            <li ><a href="BuscaFuncionario"><i class="glyphicon glyphicon-search"> Busca Funcionario</i></a></li>
                            <li ><a href="BuscaHotel"><i class="glyphicon glyphicon-search"> Busca Hotel</i></a></li>
                            <li ><a href="BuscaVoo"><i class="glyphicon glyphicon-search"> Busca Voo</i></a></li>
                            <li ><a href="PreVenda"><i class="glyphicon glyphicon-shopping-cart"> Venda</i></a></li>
                            <li ><a href="ApresentaBuscarRelatorio"><i class="glyphicon glyphicon-shopping-cart"> Buscar Venda</i></a></li>
                            <li ><a href="ApresentaBusca3"><i class="glyphicon glyphicon-retweet"> Buscar Alterações</i></a></li>
                            <li ><a href="FeedbackServlet"><i class="glyphicon glyphicon-envelope">  Mandar  feedback</i></a></li>
                            <li ><a href="ApresentaBuscaFeedback"><i class="glyphicon glyphicon-warning-sign"> Feedbacks</i></a></li>
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
                            <li ><a href="BuscaCliente"><i class="glyphicon glyphicon-search"> Busca Cliente</i></a></li>
                            <li ><a href="BuscaHotel"><i class="glyphicon glyphicon-search"> Busca Hotel</i></a></li>
                            <li ><a href="BuscaVoo"><i class="glyphicon glyphicon-search"> Busca Voo</i></a></li>
                            <li ><a href="PreVenda"><i class="glyphicon glyphicon-shopping-cart"> Venda</i></a></li> 
                            <li ><a href="FeedbackServlet"><i class="glyphicon glyphicon-envelope"> Mandar feedback</i></a></li>
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
                            <li ><a href="CadastroHotel"><i class="glyphicon glyphicon-header"> Cadastrar Hotel</i></a></li>
                            <li ><a href="CadastroVoo" ><i class="glyphicon glyphicon-plane"> Cadastrar Voo</i></a></li>
                            <li ><a href="BuscaCliente"><i class="glyphicon glyphicon-search"> Busca Cliente</i></a></li>
                            <li ><a href="BuscaHotel"><i class="glyphicon glyphicon-search"> Busca Hotel</i></a></li>
                            <li ><a href="BuscaVoo"><i class="glyphicon glyphicon-search"> Busca Voo</i></a></li>
                            <li ><a href="PreVenda"><i class="glyphicon glyphicon-shopping-cart"> Venda</i></a></li>
                            <li ><a href="ApresentaBuscarRelatorio"><i class="glyphicon glyphicon-shopping-cart"> Buscar Venda</i></a></li>
                            <li ><a href="ApresentaBusca3"><i class="glyphicon glyphicon-retweet"> Buscar Alterações</i></a></li>                            
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
                            <li ><a href="CadastroFuncionario"><i class="glyphicon glyphicon-briefcase"> Cadastrar Funcionario</i></a></li>
                            <li ><a href="BuscaFuncionario"><i class="glyphicon glyphicon-search"> Busca Funcionario</i></a></li>                          
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
                            <li ><a href="CadastroFuncionario"><i class="glyphicon glyphicon-briefcase"> Cadastrar Funcionario</i></a></li>
                            <li ><a href="BuscaFuncionario"><i class="glyphicon glyphicon-search"> Busca Funcionario</i></a></li>
                            <li ><a href="ApresentaBusca3"><i class="glyphicon glyphicon-search"> Buscar Alterações</i></a></li>                            
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
                            <li ><a href="CadastroVoo" ><i class="glyphicon glyphicon-plane"> Cadastrar Voo</i></a></li>
                            <li ><a href="BuscaHotel"><i class="glyphicon glyphicon-search"> Busca Hotel</i></a></li>
                            <li ><a href="BuscaVoo"><i class="glyphicon glyphicon-search"> Busca Voo</i></a></li>
                            <li ><a href="FeedbackServlet"><i class="glyphicon glyphicon-envelope"> Mandar feedback</i></a></li>
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
                            <li ><a href="CadastroVoo" ><i class="glyphicon glyphicon-plane"> Cadastrar Voo</i></a></li>
                            <li ><a href="BuscaHotel"><i class="glyphicon glyphicon-search"> Busca Hotel</i></a></li>
                            <li ><a href="BuscaVoo"><i class="glyphicon glyphicon-search"> Busca Voo</i></a></li>
                            <li ><a href="ApresentaBusca3"><i class="glyphicon glyphicon-retweet"> Buscar Alterações</i></a></li>                            
                            <li ><a href="logout"><i class="glyphicon glyphicon-off"> Sair</i></a></li>
                        </ul>
                    </div>
                </nav>
            </c:when>
        </c:choose>
    </body>
</html>
