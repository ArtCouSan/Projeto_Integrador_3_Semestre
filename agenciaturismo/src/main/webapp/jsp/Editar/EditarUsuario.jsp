<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuário</title>
    </head>
    <body>
    <c:import url="/jsp/Layout/cabecalho.jsp"/>
    <form action="EditarUsuario" method="post">
        <input type="hidden" name="identificacao" value="${usuario.getId_usuario()}"/>

        <label>Nome:</label>
        <input name="nome" type="text" /> 
        
        <label>Login:</label>
        <input name="login" type="text" /> 
        
        <label>Senha:</label>
        <input name="senha" type="password" required /> 
        
        <label>Acesso:</label>
        <input name="acesso" type="text"/> 

        <button type="submit"><span class="">Alterar</span></button>

    </form>
</body>
</html>
