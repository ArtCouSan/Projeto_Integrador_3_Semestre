<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <link href="teste.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Cliente</title>
    </head>
    <body>
        <table/>
    <thead>
        <tr>
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
            <tr name="identificacao" id="${clientes.getId_cliente()}">
                <td>${clientes.getNome()}</td>
                <td>${clientes.getCpf()}</td>
                <td>${clientes.getSexo()}</td>
                <td>${clientes.getData_nasc()}</td>
                <td>${clientes.getNumero()}</td>
                <td>${clientes.getCep()}</td>
                <td>${clientes.getRua()}</td>
                <td>${clientes.getBairro()}</td>
                <td>${clientes.getCidade()}</td>
                <td>${clientes.getComplemento()}</td>
                <td>${clientes.getCelular()}</td>
                <td>${clientes.getTelefone()}</td>
                <td>${clientes.getEmail()}</td>
                <td>${true}</td>
                <td><a class="button" href="ExcluiClienteServlet?action=edit&id=<c:out value="${clientes.getId_cliente()}"/>&pesquisa=<c:out value="${pesquisa}"/>">Remover</a></td>
                <td><a class="button" href="EditaClienteServlet?action=edit&id=<c:out value="${clientes.getId_cliente()}"/>">Alterar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
