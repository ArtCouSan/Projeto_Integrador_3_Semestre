%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <script src="./bootstrap/js/event.js" type="text/javascript" ></script>
        <title>Buscar Funcionario</title>
    </head>
    <body>
        <c:import url="WEB-INF/jsp/Layout/cabecalho.jsp"/>
        <form action="BuscaFuncionario" method="post" class="form-horizontal">
            <h1 class="text-center"> Digite o campo(s) pela informa��o que gostaria de buscar</h1>
            <div class="controls col-md-5">
                <input name="pesquisa" type="text" placeholder="Insira pesquisa" class="input-medium search-query">
                <button type="submit" class="btn">Pesquisar</button>
                <button type="reset" class="btn">Apagar</button>
            </div> 
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>