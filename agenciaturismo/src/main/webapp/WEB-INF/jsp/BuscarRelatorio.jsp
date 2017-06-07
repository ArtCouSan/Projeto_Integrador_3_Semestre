<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <script src="./bootstrap/js/relatoriosVenda.js" type="text/javascript" ></script>
        <title>Buscar Venda</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <h1 class="text-center"> Digite os campos pela data da venda - Campos vazios, todas as vendas</h1>
        <div class="input-group col-lg-offset-4">
            <label>Inicio: </label>
            <input name="inicio" type="date" id="inicio" class="search-query">
            <label>Fim: </label>
            <input name="fim" type="date" id="fim" class="search-query">
            <button onclick="pesquisar()" class="btn bg-success">Pesquisar</button>
        </div>
        <br />
        <br />
        <table class="table table-striped">
            <thead>
                <tr class="info">
                    <th>Data</th>
                    <th>Filial</th>
                    <th>Cliente</th>
                    <th>Funcionario</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody id="resultado">

            </tbody>
        </table>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>