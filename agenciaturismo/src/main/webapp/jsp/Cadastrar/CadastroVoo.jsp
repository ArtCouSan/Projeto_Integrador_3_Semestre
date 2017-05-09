<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jss/eventos.js" type="text/javascript" ></script>
        <link href="foundation/css/foundation.css" rel="stylesheet" type="text/css"/>
        <link href="foundation/css/foundation-icons/foundation-icons.css" rel="stylesheet" type="text/css"/>
        <title>Cadastro de Voo</title>
    </head>
    <body>
    <c:import url="./Layout/cabecalho.jsp"/>
    <form>

        <label for="txtorigem">Origem:</label>  
        <input type="text" name="origem" placeholder="Insira a origem"/>

        <label for="txtdestino">Destino:</label>  
        <input type="text" name="destino" placeholder="Insira o destino"/>

        <label for="txtquantidade">Quantidade de Passagens:</label>  
        <input type="number" name="quantidade" placeholder="Insira quantidade de passagens"/>

        <label for="txtdataIda">Data de ida:</label>  
        <input type="text" name="data_ida" placeholder="Insira data de ida"/>

        <label for="txtdataVolta">Data de volta:</label>  
        <input type="text" name="data_volta" placeholder="Insira data de volta"/>

        <label for="txtPreco">Preco:</label>  
        <input type="number" name="preco" placeholder="Insira o preço"/>

        <input type="submit" value="Salvar"/>
        <input type="reset" value="Apagar"/>
        
    </form>
    <c:import url="./Layout/rodape.jsp"/>
</body>
</html>
