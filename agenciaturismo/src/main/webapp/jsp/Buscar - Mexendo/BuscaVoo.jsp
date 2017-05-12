<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:import url="./Layout/cabecalho.jsp"/>
    <h1>Digite o campo(s) pela informação que gostaria de buscar</h1>
    <form action="${pageContext.request.contextPath}/BuscaVoo" method="post">

        <label for="txtorigem">Origem:</label>  
        <input type="text" name="origem" placeholder="Insira a origem"/>
        <br>
        <label for="txtdestino">Destino:</label>  
        <input type="text" name="destino" placeholder="Insira o destino"/>
        <br>
        <label for="txtquantidade">Quantidade de Passagens:</label>  
        <input type="number" name="quantidade_passagens" placeholder="Insira quantidade de passagens"/>
        <br>
        <label for="txtdataIda">Data de ida:</label>  
        <input type="text" name="data_ida" placeholder="Insira data de ida"/>
        <br>
        <label for="txtdataVolta">Data de volta:</label>  
        <input type="text" name="data_volta" placeholder="Insira data de volta"/>
        <br>
        <label for="txtPreco">Preco:</label>  
        <input type="number" name="preco" placeholder="Insira o preço"/>
        <br>
        <input type="submit" value="Buscar"/>
        <input type="reset" value="Apagar"/>
        <br>
    </form>
    <c:import url="./Layout/rodape.jsp"/>
</body>
</html>
