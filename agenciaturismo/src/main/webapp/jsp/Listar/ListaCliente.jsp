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
                    <tr id="${clientes.getId_cliente()}">
                        <td>${clientes.getNome()}"</td>
                        <td>${clientes.getCpf()}"</td>
                        <td>${clientes.getSexo()}"</td>
                        <td>${clientes.getData_nasc()}"</td>
                        <td>${clientes.getNumero()}"</td>
                        <td>${clientes.getCep()}"></td>
                        <td>${clientes.getRua()}"></td>
                        <td>${clientes.getBairro()}"></td>
                        <td>${clientes.getCidade()}"></td>
                        <td>${clientes.getLogradouro()}"></td>
                        <td>${clientes.getComplemento()}"></td>
                        <td>${clientes.getCelular()}"></td>
                        <td>${clientes.getTelefone()}"></td>
                        <td>${clientes.getEmail()}"></td>
                        <td>${true}"></td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:import url="./Layout/rodape.jsp"/>
    </body>
</html>
