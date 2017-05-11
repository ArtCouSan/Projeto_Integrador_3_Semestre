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
    <form action="${pageContext.request.contextPath}/BuscaHotel" method="post">

        <label for="txtorigem">Nome do Hotel:</label>  
        <input type="text" name="nome_hotel" placeholder="Insira o nome do hotel"/>
        <br>
        <label for="txtdestino">Data de Entrada:</label>  
        <input type="text" name="data_entrada" placeholder="Insira a data de entrada"/>
        <br>
        <label for="txtquantidade">Data de Saida:</label>  
        <input type="text" name="data_saida" placeholder="Insira a data de saida"/>
        <br>
        <label for="txtdataIda">Quantidade de Quartos:</label>  
        <input type="number" name="quantidade_quartos" placeholder="Insira a quantidade de quartos"/>
        <br>
        <label for="txtdataVolta">Quantidade de Hospedes:</label>  
        <input type="number" name="quantidade_hospedes" placeholder="Insira a quantidade de hospedes"/>
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
