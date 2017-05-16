bvbvb<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <script src="jss/eventos.js" type="text/javascript" ></script>
        <title>Editar Voo</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <form action="${pageContext.request.contextPath}/EditarVoo" method="post" class="form-horizontal">
            <input type="text" name="identificacao" value="${voos.getId_voo()}"/>
            <br>
            <label for="txtorigem">Origem:</label>  
            <input type="text" name="origem" value="${voos.getOrigem()}"/>
            <br>
            <label for="txtdestino">Destino:</label>  
            <input type="text" name="destino" value="${voos.getDestino()}"/>
            <br>
            <label for="txtquantidade">Quantidade de Passagens:</label>  
            <input type="number" name="quantidade_passagens" value="${voos.getQuantidade_passagens()}"/>
            <br>
            <label for="txtdataIda">Data de ida:</label>  
            <input type="text" name="data_ida" value="${voos.getData_ida()}"/>
            <br>
            <label for="txtdataVolta">Data de volta:</label>  
            <input type="text" name="data_volta" value="${voos.getData_volta()}"/>
            <br>
            <label for="txtPreco">Preco:</label>  
            <input type="number" name="preco" value="${voos.getPreco()}"/>
            <br>
            <input type="submit" value="Alterar"/>
            <br>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
