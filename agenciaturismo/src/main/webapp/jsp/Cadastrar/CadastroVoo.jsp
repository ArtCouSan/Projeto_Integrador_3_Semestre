<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <title>Cadastro de Voo</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <form action="${pageContext.request.contextPath}/CadastroVoo" method="post">

            <label for="txtorigem">Origem:</label>  
            <input type="text" name="origem" placeholder="Insira a origem" required/>
            <br>
            <label for="txtdestino">Destino:</label>  
            <input type="text" name="destino" placeholder="Insira o destino" required/>
            <br>
            <label for="txtquantidade">Quantidade de Passagens:</label>  
            <input type="number" name="quantidade_passagens" placeholder="Insira quantidade de passagens" required/>
            <br>
            <label for="txtdataIda">Data de ida:</label>  
            <input type="text" name="data_ida" placeholder="Insira data de ida" required/>
            <br>
            <label for="txtdataVolta">Data de volta:</label>  
            <input type="text" name="data_volta" placeholder="Insira data de volta" required/>
            <br>
            <label for="txtPreco">Preco:</label>  
            <input type="number" name="preco" placeholder="Insira o preço" required/>
            <br>
            <input type="submit" value="Salvar"/>
            <input type="reset" value="Apagar"/>
            <br>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
