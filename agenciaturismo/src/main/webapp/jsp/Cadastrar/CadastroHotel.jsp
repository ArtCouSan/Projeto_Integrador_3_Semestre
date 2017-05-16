<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <title>Cadastro de Hotel</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <form action="${pageContext.request.contextPath}/CadastroHotel" method="post">

            <label for="txtorigem">Nome do Hotel:</label>  
            <input type="text" name="nome_hotel" placeholder="Insira o nome do hotel" required/>
            <br>
            <label for="txtdestino">Data de Entrada:</label>  
            <input type="text" name="data_entrada" placeholder="Insira a data de entrada" required/>
            <br>
            <label for="txtquantidade">Data de Saida:</label>  
            <input type="text" name="data_saida" placeholder="Insira a data de saida" required/>
            <br>
            <label for="txtdataIda">Quantidade de Quartos:</label>  
            <input type="number" name="quantidade_quartos" placeholder="Insira a quantidade de quartos" required/>
            <br>
            <label for="txtdataVolta">Quantidade de Hospedes:</label>  
            <input type="number" name="quantidade_hospedes" placeholder="Insira a quantidade de hospedes" required/>
            <br>
            <label for="txtPreco">Preco:</label>  
            <input type="number" name="preco" placeholder="Insira o preço"/>
            <br>
            <input type="submit" value="Salvar"/>
            <input type="reset" value="Apagar"/>
            <br>        
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
