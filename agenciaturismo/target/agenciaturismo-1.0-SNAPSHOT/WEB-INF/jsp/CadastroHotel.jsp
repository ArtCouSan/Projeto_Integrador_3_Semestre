<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jss/eventos.js" type="text/javascript" ></script>
        <link href="foundation/css/foundation.css" rel="stylesheet" type="text/css"/>
        <link href="foundation/css/foundation-icons/foundation-icons.css" rel="stylesheet" type="text/css"/>
        <title>Cadastro de Hotel</title>
    </head>
    <body>
        <form>
            
            <label for="txtorigem">Nome do Hotel:</label>  
            <input type="text" name="nome_hotel" placeholder="Insira o nome do hotel"/>
            <br/>
            
            <label for="txtdestino">Data de Entrada:</label>  
            <input type="text" name="data_entrada" placeholder="Insira a data de entrada"/>
            <br/>
            
            <label for="txtquantidade">Data de Saida:</label>  
            <input type="text" name="data_saida" placeholder="Insira a data de saida"/>
            <br/>
            
            <label for="txtdataIda">Quantidade de Quartos:</label>  
            <input type="text" name="quantidade_quartos" placeholder="Insira a quantidade de quartos"/>
            <br/>
            
            <label for="txtdataVolta">Quantidade de Hospedes:</label>  
            <input type="text" name="quantidade_hospedes" placeholder="Insira a quantidade de hospedes"/>
            <br/>
            
            <input type="submit" value="Salvar"/>
            <input type="reset" value="Apagar"/>
            
        </form>
    </body>
</html>
