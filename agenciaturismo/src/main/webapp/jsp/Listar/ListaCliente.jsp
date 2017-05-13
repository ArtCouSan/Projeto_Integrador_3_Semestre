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
        <table>
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
                    <tr id="${clientes.getId_cliente()}">
                        <td name="nome">${clientes.getNome()}</td>
                        <td name="cpf">${clientes.getCpf()}</td>
                        <td name="sexo">${clientes.getSexo()}</td>
                        <td name="data_nasc">${clientes.getData_nasc()}</td>
                        <td name="numero">${clientes.getNumero()}</td>
                        <td name="cep">${clientes.getCep()}</td>
                        <td name="rua">${clientes.getRua()}</td>
                        <td name="bairro">${clientes.getBairro()}</td>
                        <td name="cidade">${clientes.getCidade()}</td>
                        <td name="logradouro">${clientes.getLogradouro()}</td>
                        <td name="complemento">${clientes.getComplemento()}</td>
                        <td name="celular">${clientes.getCelular()}</td>
                        <td name="telefone">${clientes.getTelefone()}</td>
                        <td name="email">${clientes.getEmail()}</td>
                        <td name="ativo">${true}</td>
                        <td><a class="button" href="CaminhoDoServlet?action=edit&id=<c:out value="${cliente.id}"/>">Atualizar</a></td>
                        <td><button >Alterar</button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
