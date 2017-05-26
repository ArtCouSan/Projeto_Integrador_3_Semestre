<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <title>Buscar Usuario</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <form action="${contextPath}/BuscaUsuario" method="post" class="form-horizontal">
            <h1 class="text-center"> Digite o campo(s) pela informação que gostaria de buscar</h1>
            <div class="controls col-md-5">
                <input name="pesquisa" type="text" placeholder="Insira pesquisa" class="input-medium search-query">
                <button type="submit" class="btn">Pesquisar</button>
                <button type="reset" class="btn">Apagar</button>
            </div> 
        </form>
    </body>
</html>
