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
        <title>Buscar Voo</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container">
            <div class="col-md-6 col-md-offset-3">
                <form role="form" action="BuscaVoo" method="post">
                    <div class="row">
                        <h1 class="text-center"> Digite o campo pela informação que gostaria de buscar do vôo...</h1>
                        <ul>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-home"></span> | Origem do vôo</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-pushpin"></span> | Destino do vôo</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-plane"></span> | Quantidade de passagens do vôo</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-calendar"></span> | Data de ida - Com pontuação</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-calendar"></span> | Data de volta - Com pontuação</li>
                            <li class="list-unstyled"><span class="glyphicon glyphicon-usd"></span> | Preço do vôo</li>     
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
