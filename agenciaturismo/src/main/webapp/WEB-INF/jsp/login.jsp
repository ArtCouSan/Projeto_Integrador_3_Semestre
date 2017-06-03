<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Agência Turismo</h1>
        <form action="login" method="post">
            <div>
                <label for="txtusuario">Login</label>
                <input type="text" name="usuario" id="txtusuario" placeholder="user" required/>
            </div>
            <div>
                <label for="txtsenha">Senha</label>
                <input type="password" name="senha" id="txtsenha" placeholder="password" required/>
            </div>
            <div>
                <input type="submit" value="Entrar" />
            </div>
        </form>
    <c:import url="./Layout/rodape.jsp"/>
    </body>
</html>

