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
        <script src="./bootstrap/js/event.js" type="text/javascript" ></script>
        <title>Buscar Funcionario</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container" style="margin-top: 5%;">
            <div class="col-md-6 col-md-offset-3">
                <form role="form" action="BuscaFuncionario" method="post">
                    <div class="row">
                        <h1 class="text-center"> Digite o campo pela informação que gostaria de buscar do funcionario...</h1>
                        <ul>
                            <li class="list-unstyled">Dicas:</li>
                            <li class="list-unstyled"><span class="fa fa-id-card"></span> | Nome do funcionario</li>
                            <li class="list-unstyled"><span class="fa fa-rss"></span> | Filial do funcionario</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-inbox"></span> | Departamento do funcionario</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-lock"></span> | Cargo do funcionario</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-book"></span> | CPF do funcionario - Com pontuação</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-heart"></span> | Sexo do funcionario - Siglas</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-baby-formula"></span> | Data de nascimento do funcionario - Com pontuação</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-globe"></span> | Estado do funcionario - Siglas</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-globe"></span> | Cidade do funcionario</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-road"></span> | Rua da casa do funcionario</li>
                            <li class="list-unstyled"><span class="fa fa-sort-numeric-desc"></span>   | Numero da casa do funcionario</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-map-marker"></span> | CEP da casa do funcionario - Com pontuação</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-earphone"></span> | Telefone ou Celular do funcionario - Com pontuação</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-envelope"></span> | Email do funcionario</li>
                        </ul>
                        <div class="form-group">
                            <div class="input-group">
                                <input class="form-control" type="text" name="pesquisa" required/>
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
    </body>
</html>
