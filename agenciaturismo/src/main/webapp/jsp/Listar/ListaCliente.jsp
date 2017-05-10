<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Cliente</title>
    </head>
    <body>
        <c:import url="./Layout/cabecalho.jsp" />
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
                    <tr>
                        <td><c:out value="${clientes.nome}"></c:out></td>
                        <td><c:out value="${clientes.cpf}"></c:out></td>
                        <td><c:out value="${clientes.sexo}"></c:out></td>
                        <td><c:out value="${clientes.data_nasc}"></c:out></td>
                        <td><c:out value="${clientes.numero}"></c:out></td>
                        <td><c:out value="${clientes.cep}"></c:out></td>
                        <td><c:out value="${clientes.rua}"></c:out></td>
                        <td><c:out value="${clientes.bairro}"></c:out></td>
                        <td><c:out value="${clientes.cidade}"></c:out></td>
                        <td><c:out value="${clientes.logradouro}"></c:out></td>
                        <td><c:out value="${clientes.complemento}"></c:out></td>
                        <td><c:out value="${clientes.celular}"></c:out></td>
                        <td><c:out value="${clientes.telefone}"></c:out></td>
                        <td><c:out value="${clientes.email}"></c:out></td>
                        <td><c:out value="${true}"></c:out></td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:import url="./Layout/rodape.jsp"/>
    </body>
</html>
