<%-- 
    Document   : ListaFuncionarios
    Created on : May 4, 2017, 10:29:50 PM
    Author     : danimo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Todos Funcionarios:</h1>
        <ul>
            <c:forEach items="${listaFuncionarios}" var="funcionario">
            
                <li><c:out value="${funcionario.nome}"/> <c:out value="${funcionario.sobrenome}"/>, <c:out value="${funcionario.idade}"/></li>
            
            </c:forEach>
        </ul>
    </body>
</html>
