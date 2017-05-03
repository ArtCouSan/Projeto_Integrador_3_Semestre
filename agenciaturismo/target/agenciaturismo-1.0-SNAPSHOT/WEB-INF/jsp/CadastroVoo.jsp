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
        <form>
            
            <label for="txtorigem">Origem:</label>  
            <input type="text" name="origem" placeholder="Insira a origem"/>
            <br />
            <label for="txtdestino">Destino:</label>  
            <input type="text" name="destino" placeholder="Insira o destino"/>
            <br />
            <label for="txtquantidade">Quantidade de Passagens:</label>  
            <input type="text" name="quantidade" placeholder="Insira quantidade de passagens"/>
            <br />
            <label for="txtdataIda">Data de ida:</label>  
            <input type="text" name="data_ida" placeholder="Insira data de ida"/>
            <br />
            <label for="txtdataVolta">Data de volta:</label>  
            <input type="text" name="data_volta" placeholder="Insira data de volta"/>
            <br />
        </form>
        <input type="submit" value="Salvar" />
    </body>
</html>
