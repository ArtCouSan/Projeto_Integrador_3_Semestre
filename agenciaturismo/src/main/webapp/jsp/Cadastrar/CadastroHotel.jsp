<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jss/eventos.js" type="text/javascript" ></script>
<!--        <link href="foundation/css/foundation.css" rel="stylesheet" type="text/css"/>
        <link href="foundation/css/foundation-icons/foundation-icons.css" rel="stylesheet" type="text/css"/>-->
        <title>Cadastro de Hotel</title>
    </head>
    <body>
    <c:import url="./Layout/cabecalho.jsp"/>
    <form action="${pageContext.request.contextPath}/CadastroHotel">

        <label for="txtorigem">Nome do Hotel:</label>  
        <input type="text" name="nome_hotel" placeholder="Insira o nome do hotel"/>

        <label for="txtdestino">Data de Entrada:</label>  
        <input type="text" name="data_entrada" placeholder="Insira a data de entrada"/>

        <label for="txtquantidade">Data de Saida:</label>  
        <input type="text" name="data_saida" placeholder="Insira a data de saida"/>

        <label for="txtdataIda">Quantidade de Quartos:</label>  
        <input type="number" name="quantidade_quartos" placeholder="Insira a quantidade de quartos"/>

        <label for="txtdataVolta">Quantidade de Hospedes:</label>  
        <input type="number" name="quantidade_hospedes" placeholder="Insira a quantidade de hospedes"/>

        <label for="txtPreco">Preco:</label>  
        <input type="number" name="preco" placeholder="Insira o preço"/>

        <input type="submit" value="Salvar"/>
        <input type="reset" value="Apagar"/>

    </form>
    <c:import url="./Layout/rodape.jsp"/>
</body>
</html>
