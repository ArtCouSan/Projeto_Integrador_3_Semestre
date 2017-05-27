<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <script src="./bootstrap/js/event.js" type="text/javascript" ></script>
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Cliente</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <table class="table table-striped">
            <thead>
                <tr class="info">
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Data de Nascimento</th>
                    <th>Celular</th>
                    <th>Telefone</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="clientes" items="${encontrados}">
                    <tr >
                        <td><c:out value="${clientes.getNome()}"/></td>
                        <td><c:out value="${clientes.getCpf()}"/></td>
                        <td><c:out value="${clientes.getData_nasc()}"/></td>
                        <td><c:out value="${clientes.getCelular()}"/></td>
                        <td><c:out value="${clientes.getTelefone()}"/></td>
                        <td><c:out value="${clientes.getEmail()}"/></td>
                        <td><a class="btn btn-danger" href="ExcluiClienteServlet?action=delete&id=${clientes.getId_cliente()}"/><i class="glyphicon glyphicon-trash">Remover</i></a></td>
                        <td><a class="btn btn-info" href="EditarCliente?action=edit&id=${clientes.getId_cliente()}"><i class="glyphicon glyphicon-pencil">Alterar</i></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
