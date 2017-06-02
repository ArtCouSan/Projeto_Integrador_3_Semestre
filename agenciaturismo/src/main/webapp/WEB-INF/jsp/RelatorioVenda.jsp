<%-- 
    Document   : RelatorioVenda
    Created on : May 30, 2017, 9:32:51 PM
    Author     : danimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio de Vendas</title>
    </head>
    <body>
        <h1>RELATORIO DE VENDAS</h1>
        
        <c:import url="./cabecalho.jsp"/>
        <table class="table table-striped">
            <thead>
                <tr class="info">
                    <th>Venda</th>
                    <th>Cliente</th>
                    <th>Vendedor</th>
                    <th>Valor Total</th>
                    <th>Data</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="venda" items="${vendas}">
                    <tr >
                        <td name="venda"><c:out value="${vendas.getId()}"/></td>
                        <td name="cliente"><c:out value="${venda.getCliente()}"/></td>
                        <td name="vendedor"><c:out value="${venda.getFuncionario()}"/></td>
                        <td name="total"><c:out value="${venda.getTotal()}"/></td>
                        <td name="data"><c:out value="${venda.getData()}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
