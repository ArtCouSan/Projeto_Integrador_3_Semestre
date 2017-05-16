<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <link href="teste.css" rel="stylesheet" type="text/css"/>
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
                    <th>Sexo</th>
                    <th>Data de Nascimento</th>
                    <th>Numero</th>
                    <th>CEP</th>
                    <th>Rua</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Logradouro</th>
                    <th>Complemento</th>
                    <th>Celular</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>Ativo ?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="clientes" items="${encontrados}">
                    <tr >
                        <td><c:out value="${clientes.getNome()}"/></td>
                        <td><c:out value="${clientes.getCpf()}"/></td>
                        <td><c:out value="${clientes.getSexo()}"/></td>
                        <td><c:out value="${clientes.getData_nasc()}"/></td>
                        <td><c:out value="${clientes.getNumero()}"/></td>
                        <td><c:out value="${clientes.getCep()}"/></td>
                        <td><c:out value="${clientes.getRua()}"/></td>
                        <td><c:out value="${clientes.getBairro()}"/></td>
                        <td><c:out value="${clientes.getCidade()}"/></td>
                        <td><c:out value="${clientes.getComplemento()}"/></td>
                        <td><c:out value="${clientes.getCelular()}"/></td>
                        <td><c:out value="${clientes.getTelefone()}"/></td>
                        <td><c:out value="${clientes.getEmail()}"/></td>
                        <td><c:out value="${true}"/></td>
                        <td><a class="btn btn-danger" href="ExcluiClienteServlet?action=edit&id=<c:out value="${clientes.getId_cliente()}"/>&pesquisa=<c:out value="${pesquisa}"/>"><i class="icon-trash">Remover</i><</a></td>
                        <td><a class="btn " href="EditaClienteServlet?action=edit&id=<c:out value="${clientes.getId_cliente()}"/>"><i class="icon-pencil">Alterar</i></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
