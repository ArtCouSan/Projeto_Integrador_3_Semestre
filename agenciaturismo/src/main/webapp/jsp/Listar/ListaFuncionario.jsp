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
            <tr name="id" id="${funcionarios.getId_funcionario()}">
                <td name="nome">${funcionarios.getNome()}</td>
                <td name="cpf">${funcionarios.getCpf()}</td>
                <td name="sexo">${funcionarios.getSexo()}</td>
                <td name="data_nasc">${funcionarios.getData_nasc()}></td>
                <td name="numero">${funcionarios.getNumero()}</td>
                <td name="cep">${funcionarios.getCep()}</td>
                <td name="rua">${funcionarios.getRua()}</td>
                <td name="bairro">${funcionarios.getBairro()}</td>
                <td name="cidade">${funcionarios.getCidade()}</td>
                <td name="logradouro">${funcionarios.getLogradouro()}</td>
                <td name="complemento">${funcionarios.getComplemento()}</td>
                <td name="celular">${funcionarios.getCelular()}</td>
                <td name="telefone">${funcionarios.getTelefone()}</td>
                <td name="email">${funcionarios.getEmail()}</td>
                <td name="cargo">${funcionarios.getCargo}</td>
                <td name="filial">${funcionarios.getFilial}</td>
                <td name="departamento">${funcionarios.getDepartamento}</td>
                <td name="ativo">${true}></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<c:import url="./Layout/rodape.jsp"/>
</body>
</html>
