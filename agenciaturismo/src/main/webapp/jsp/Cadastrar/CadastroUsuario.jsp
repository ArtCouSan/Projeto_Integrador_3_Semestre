<%-- 
    Document   : CadastroUsuario
    Created on : May 24, 2017, 8:52:46 PM
    Author     : danimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>TELA DE CADASTRO DE USUARIO</h1>
        <form action="${contextPath}/CadastroUsuario" method="POST">
            <label for="name">Nome</label>
            <input type="text" name="nome" id="nometxt" required/>
            
            <label for="name">Nome de Usuário</label>
            <input type="text" name="login" id="nomeUserTxt" required/>
            
            <label for="name">Senha</label>
            <input type="password" name="senha" id="pass" required/>
            
            <select name="acesso">
                <option value="MASTER">MASTER</option>
                <option value="BASICO">BASICO</option>
            </select>
            
            <input type="submit"/>
        </form>
    </body>
</html>
