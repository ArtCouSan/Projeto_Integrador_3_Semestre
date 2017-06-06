<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css"  href="./bootstrap/css/font-awesome.css" rel="stylesheet" />
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <title>Buscar Cliente</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container" style="margin-top: 5%;">
            <div class="col-md-6 col-md-offset-3">
                <form role="form" action="BuscaCliente" method="post">
                    <div class="row">
                        <h1 class="text-center">Digite o campo pela informação que gostaria de buscar clientes...</h1>
                        <ul>
                            <li class="list-unstyled"><span class="fa fa-id-card"></span> | Nome do cliente</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-book"></span> | CPF do cliente - Com pontuação</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-heart"></span> | Sexo do cliente - Siglas</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-baby-formula"></span> | Data de nascimento do cliente - Com pontuação</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-globe"></span> | Estado do cliente - Siglas</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-globe"></span> | Cidade do cliente</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-road"></span> | Rua da casa do cliente</li>
                            <li class="list-unstyled"><span class="fa fa-sort-numeric-desc"></span>   | Numero da casa do cliente</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-map-marker"></span> | CEP da casa do cliente - Com pontuação</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-earphone"></span> | Telefone ou Celular do cliente - Com pontuação</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-envelope"></span> | Email do cliente</li>
                        </ul>
                        <div class="form-group">
                            <div class="input-group">
                                <input class="form-control" type="text" name="pesquisa"/>
                                <span class="input-group-btn">
                                    <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"><span style="margin-left:10px;">Pesquisar</span></button>
                                </span>                           
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
        <script src="./bootstrap/js/validator.min.js"></script>
    </body>
</html>
