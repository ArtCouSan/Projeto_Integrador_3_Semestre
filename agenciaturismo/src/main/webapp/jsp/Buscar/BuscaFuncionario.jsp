<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link href="foundation/css/foundation.css" rel="stylesheet" type="text/css"/>
                <link href="foundation/css/foundation-icons/foundation-icons.css" rel="stylesheet" type="text/css"/>-->
        <title>Buscar Funcionario</title>
    </head>
    <body>
    <c:import url="./Layout/cabecalho.jsp"/>
    <form action="${pageContext.request.contextPath}/BuscaFuncionario" method="post">
        <label for="txtPesquisa">Pesquisa:</label>  
        <input type="text" name="pesquisa" placeholder="Insira a pesquisa"/>
        <input type="submit" value="Buscar"/>
        <input type="reset" value="Apagar"/>
    </form>
    <c:import url="./Layout/rodape.jsp"/>
</body>
</html>
