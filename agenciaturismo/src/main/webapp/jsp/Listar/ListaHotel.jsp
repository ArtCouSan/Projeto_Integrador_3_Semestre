<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="teste.css" rel="stylesheet" type="text/css"/>
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
                    <tr name="identificacao" id="${hoteis.getId_hotel()}">
                        <td name="nome">${hoteis.getNome_hotel()}</td>
                        <td name="data_entrada">${hoteis.getData_entrada()}</td>
                        <td name="data_saida">${hoteis.getData_saida()}</td>
                        <td name="preco">${hoteis.getPreco()}</td>
                        <td name="quantidade_quartos">${hoteis.getQuantidade_quartos()}</td>
                        <td name="quantidade_hospedes">${hoteis.getQuantidade_hospedes()}</td>
                        <td><a class="button" href="ExcluiHotelServlet?action=edit&id=<c:out value="${hoteis.getId_hotel()}"/>&pesquisa=<c:out value="${pesquisa}"/>">Remover</a></td>
                        <td><a class="button" href="EditaHotelServlet?action=edit&id=<c:out value="${hoteis.getId_hotel()}"/>">Alterar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
