<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Funcionários</title>
    </head>
    <body>
    <c:import url="./Layout/cabecalho.jsp"/>
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
                <th>Cargo</th>
                <th>Filial</th>
                <th>Departamento</th>
                <th>Ativo ?</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="funcionarios" items="${encontrados}">
            <tr>
                <td><c:out value="${funcionarios.nome}"></c:out></td>
            <td><c:out value="${funcionarios.cpf}"></c:out></td>
            <td><c:out value="${funcionarios.sexo}"></c:out></td>
            <td><c:out value="${funcionarios.data_nasc}"></c:out></td>
            <td><c:out value="${funcionarios.numero}"></c:out></td>
            <td><c:out value="${funcionarios.cep}"></c:out></td>
            <td><c:out value="${funcionarios.rua}"></c:out></td>
            <td><c:out value="${funcionarios.bairro}"></c:out></td>
            <td><c:out value="${funcionarios.cidade}"></c:out></td>
            <td><c:out value="${funcionarios.logradouro}"></c:out></td>
            <td><c:out value="${funcionarios.complemento}"></c:out></td>
            <td><c:out value="${funcionarios.celular}"></c:out></td>
            <td><c:out value="${funcionarios.telefone}"></c:out></td>
            <td><c:out value="${funcionarios.email}"></c:out></td>
            <td><c:out value="${funcionarios.cargo}"></c:out></td>
            <td><c:out value="${funcionarios.filial}"></c:out></td>
            <td><c:out value="${funcionarios.departamento}"></c:out></td>
            <td><c:out value="${true}"></c:out></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<c:import url="./Layout/rodape.jsp"/>
</body>
</html>
