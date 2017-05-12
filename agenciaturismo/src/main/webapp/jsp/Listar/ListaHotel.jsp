<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Hotel</title>
    </head>
    <body>
    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Data de entrada</th>
                <th>Data de saida</th>
                <th>Preco</th>
                <th>Quantidade de quartos</th>
                <th>Quantidade de hospedes</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="hoteis" items="${encontrados}">
            <tr id="${hoteis.getId_hotel()}">
                <td>${hoteis.getNome_hotel()}</td>
                <td>${hoteis.getData_entrada()}</td>
                <td>${hoteis.getData_saida()}</td>
                <td>${hoteis.getPreco()}</td>
                <td>${hoteis.getQuantidade_quartos()}</td>
                <td>${hoteis.getQuantidade_hospedes()}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
