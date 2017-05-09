<%-- 
    Document   : login
    Created on : 07/05/2017, 23:42:20
    Author     : Rafael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <div>
                <label for="txtusuario">Nome de usuário</label>
                <input type="text" name="usuario" id="txtusuario" />
            </div>
            <div>
                <label for="txtsenha">Senha</label>
                <input type="password" name="senha" id="txtsenha" />
            </div>
            <div>
                <input type="submit" value="Entrar" />
            </div>
        </form>
    <c:import url="./Layout/rodape.jsp"/>
    </body>
</html>
