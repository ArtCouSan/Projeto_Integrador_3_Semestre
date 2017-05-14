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
    <form action="${pageContext.request.contextPath}/EditarHotel" method="post">

        <label name="identificacao">${hotel.getId_hotel()}</label>
        <br>
        <label for="txtorigem">Nome do Hotel:</label>  
        <input type="text" name="nome_hotel" value="${hotel.getNome_hotel()}"/>
        <br>
        <label for="txtdestino">Data de Entrada:</label>  
        <input type="text" name="data_entrada" value="${hotel.getData_entrada()}"/>
        <br>
        <label for="txtquantidade">Data de Saida:</label>  
        <input type="text" name="data_saida" value="${hotel.getData_saida()}"/>
        <br>
        <label for="txtdataIda">Quantidade de Quartos:</label>  
        <input type="number" name="quantidade_quartos" value="${hotel.getQuantidade_quartos()}"/>
        <br>
        <label for="txtdataVolta">Quantidade de Hospedes:</label>  
        <input type="number" name="quantidade_hospedes" value="${hotel.getQuantidade_hospedes()}"/>
        <br>
        <label for="txtPreco">Preco:</label>  
        <input type="number" name="preco" value="${hotel.getPreco()}"/>
        <br>
        <input type="submit" value="Alterar"/>
        <br>
    </form>
    <c:import url="./Layout/rodape.jsp"/>
</body>
</html>

