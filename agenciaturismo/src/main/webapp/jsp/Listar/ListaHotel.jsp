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
                        <td name="nome">${hoteis.getNome_hotel()}</td>
                        <td name="data_entrada">${hoteis.getData_entrada()}</td>
                        <td name="data_saida">${hoteis.getData_saida()}</td>
                        <td name="preco">${hoteis.getPreco()}</td>
                        <td name="quantidade_quartos">${hoteis.getQuantidade_quartos()}</td>
                        <td name="quantidade_hospedes">${hoteis.getQuantidade_hospedes()}</td>
                        <td><button name="${hoteis.getId_hotel()}">Excluir</button></td>
                        <td><button >Alterar</button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
