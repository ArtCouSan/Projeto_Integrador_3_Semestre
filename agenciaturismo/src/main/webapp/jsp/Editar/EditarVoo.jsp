<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jss/eventos.js" type="text/javascript" ></script>
        <!--        <link href="foundation/css/foundation.css" rel="stylesheet" type="text/css"/>
                <link href="foundation/css/foundation-icons/foundation-icons.css" rel="stylesheet" type="text/css"/>-->
        <title>Cadastro de Voo</title>
    </head>
    <body>
    <c:import url="./Layout/cabecalho.jsp"/>
    <form action="${pageContext.request.contextPath}/EditarVoo" method="post">
        <label name="identificacao">${voo.getId_voo()}</label>
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
    <c:import url="./Layout/rodape.jsp"/>
</body>
</html>
