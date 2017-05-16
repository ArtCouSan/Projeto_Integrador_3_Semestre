<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link href="teste.css" rel="stylesheet" type="text/css"/>
        <title>Listar Funcionários</title>
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
                    <tr >
                        <td name="nome"><c:out value="${funcionarios.getNome()}"/></td>
                        <td name="cpf"><c:out value="${funcionarios.getCpf()}"/></td>
                        <td name="sexo"><c:out value="${funcionarios.getSexo()}"/></td>
                        <td name="data_nasc"><c:out value="${funcionarios.getData_nasc()}"/></td>
                        <td name="numero"><c:out value="${funcionarios.getNumero()}"/></td>
                        <td name="cep"><c:out value="${funcionarios.getCep()}"/></td>
                        <td name="rua"><c:out value="${funcionarios.getRua()}"/></td>
                        <td name="bairro"><c:out value="${funcionarios.getBairro()}"/></td>
                        <td name="cidade"><c:out value="${funcionarios.getCidade()}"/></td>
                        <td name="complemento"><c:out value="${funcionarios.getComplemento()}"/></td>
                        <td name="celular"><c:out value="${funcionarios.getCelular()}"/></td>
                        <td name="telefone"><c:out value="${funcionarios.getTelefone()}"/></td>
                        <td name="email"><c:out value="${funcionarios.getEmail()}"/></td>
                        <td name="cargo"><c:out value="${funcionarios.getCargo()}"/></td>
                        <td name="filial"><c:out value="${funcionarios.getFilial()}"/></td>
                        <td name="departamento"><c:out value="${funcionarios.getDepartamento()}"/></td>
                        <td name="ativo">${true}</td>
                        <td><a class="btn btn-danger" href="ExcluiFuncionarioServlet?action=edit&id=<c:out value="${funcionarios.getId_func()}"/>&pesquisa=<c:out value="${pesquisa}"/>"><i class="icon-trash">Remover</i><</a></td>
                        <td><a class="btn" href="EditarFuncionario?action=edit&id=<c:out value="${funcionarios.getId_func()}"/>"><i class="icon-pencil">Alterar</i></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
