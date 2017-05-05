<%-- 
    Document   : CadastroFuncionarioSimplao
    Created on : May 4, 2017, 12:44:11 PM
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
        <h1>Cadastro Da Humildade</h1>
        
        <form action="cadastro-funcionario-simplao" method="POST">
            <input type="text" name="nome" id="nomeFun"/>
            <input type="text" name="sobrenome" id="sobrenomeFun"/>
            <input type="number" name="idade" id="idadeFun"/>
            <input type="submit"/>
        </form>
    </body>
</html>
