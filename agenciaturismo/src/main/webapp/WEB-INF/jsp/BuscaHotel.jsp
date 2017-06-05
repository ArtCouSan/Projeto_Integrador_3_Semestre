<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <title>Buscar Hotel</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container" style="margin-top: 5%;">
            <div class="col-md-6 col-md-offset-3">
                <form role="form" action="BuscaHotel" method="post">
                    <div class="row">
                        <h1 class="text-center"> Digite o campo pela informação que gostaria de buscar hotel...</h1>
                        <ul>
                            <li class="list-unstyled">Dicas:</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-home"></span> | Nome do hotel</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-calendar"></span> | Data de entrada no hotel</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-calendar"></span> | Data de saida do hotel</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-bed"></span> | Quantidade de quartos</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-user"></span> | Quantidade de hospedes</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-usd"></span> | Preço</li>               
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
    </body>
</html>
