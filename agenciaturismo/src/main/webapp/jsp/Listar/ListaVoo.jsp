<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Voos</title>
    </head>
    <body>
    <table>
        <thead>
            <tr>
                <th>Origem</th>
                <th>Destino</th>
                <th>Data de ida</th>
                <th>Data de volta</th>
                <th>Quantidade de passagens</th>
                <th>Preco</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="voos" items="${encontrados}">
            <tr id="${voos.getId_voo()}">
                <td>${voos.getOrigem()}</td>
                <td>${voos.getDestino()}</td>
                <td>${voos.getData_ida()}</td>
                <td>${voos.getData_volta()}</td>
                <td>${voos.getQuantidade_passagens()}</td>
                <td>${voos.getPreco()}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
