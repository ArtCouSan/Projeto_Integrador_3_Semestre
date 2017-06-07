<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <link type="text/css"  href="./bootstrap/css/font-awesome.css" rel="stylesheet" />
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <script src="./bootstrap/js/relatoriosVendas.js"></script>
        <title>Relatorio Dados - Vendas</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container-fluid">
            <section class="container"> 
                <label class="h3">Relatorio Anual <span class="fa fa-line-chart"></span> :</label>
                <div class="container-page">
                    <table class="table table-striped" >
                        <thead>
                            <tr class="info">
                                <th>Data</th>
                                <th>Filial</th>
                                <th>Total de vendas no ano</th>
                            </tr>
                        </thead>
                        <tbody id="resultado1">

                        </tbody>
                    </table>
                </div>
                <label class="h3">Relatorio Mensal <span class="fa fa-line-chart"></span> :</label>
                <div class="container-page">
                    <table class="table table-striped" >
                        <thead>
                            <tr class="info">
                                <th>Data</th>
                                <th>Filial</th>
                                <th>Total de vendas no mês</th>
                            </tr>
                        </thead>
                        <tbody id="resultado2">

                        </tbody>
                    </table>
                </div>       
            </section>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/prettify/r298/prettify.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
        <script src="./bootstrap/js/multiselect.min.js" type="text/javascript" ></script>
    </body>
</html>