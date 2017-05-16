<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <script src="jss/eventos.js" type="text/javascript" ></script>
        <title>Editar Hotel</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <form action="${pageContext.request.contextPath}/EditarHotel" method="post" class="form-horizontal">
            <input type="text" name="identificacao" value="${hoteis.getId_hotel()}"/>
            <br>
            <label for="txtorigem">Nome do Hotel:</label>  
            <input type="text" name="nome_hotel" value="${hoteis.getNome_hotel()}"/>
            <br>
            <label for="txtdestino">Data de Entrada:</label>  
            <input type="text" name="data_entrada" value="${hoteis.getData_entrada()}"/>
            <br>
            <label for="txtquantidade">Data de Saida:</label>  
            <input type="text" name="data_saida" value="${hoteis.getData_saida()}"/>
            <br>
            <label for="txtdataIda">Quantidade de Quartos:</label>  
            <input type="number" name="quantidade_quartos" value="${hoteis.getQuantidade_quartos()}"/>
            <br>
            <label for="txtdataVolta">Quantidade de Hospedes:</label>  
            <input type="number" name="quantidade_hospedes" value="${hoteis.getQuantidade_hospedes()}"/>
            <br>
            <label for="txtPreco">Preco:</label>  
            <input type="number" name="preco" value="${hoteis.getPreco()}"/>
            <br>
            <input type="submit" value="Alterar"/>
            <br>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>

