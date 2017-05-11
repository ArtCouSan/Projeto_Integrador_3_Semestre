<%-- 
    Document   : login
    Created on : 10/05/2017, 20:17:49
    Author     : rafael.fsilva7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <div>
                <label for="txtusuario">Usuário</label>
                <input type="text" name="usuario" id="txtusuario" placeholder="user" />
            </div>
            <div>
                <label for="txtsenha">Senha</label>
                <input type="password" name="senha" id="txtsenha" placeholder="password"/>
            </div>
            <div>
                <input type="submit" value="Entrar" />
            </div>
        </form>
    <c:import url="./Layout/rodape.jsp"/>
    </body>
</html>

