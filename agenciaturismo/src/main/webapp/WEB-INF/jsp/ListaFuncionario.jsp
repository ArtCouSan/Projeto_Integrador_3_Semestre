<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <script src="./bootstrap/js/aceitacoes.js" type="text/javascript" ></script>
        <script src="./bootstrap/js/event.js" type="text/javascript" ></script> 
        <title>Listar Funcionários</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <table class="table table-striped">
            <thead>
                <tr class="info">
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Data de Nascimento</th>
                    <th>Celular</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>Cargo</th>
                    <th>Filial</th>
                    <th>Departamento</th>
                    <th>Remover</th>
                    <th>Editar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="funcionarios" items="${encontrados}">
                    <tr >
                        <td name="nome"><c:out value="${funcionarios.getNome()}"/></td>
                        <td name="cpf"><c:out value="${funcionarios.getCpf()}"/></td>
                        <td name="data_nasc"><c:out value="${funcionarios.getData_nasc()}"/></td>
                        <td name="celular"><c:out value="${funcionarios.getCelular()}"/></td>
                        <td name="telefone"><c:out value="${funcionarios.getTelefone()}"/></td>
                        <td name="email"><c:out value="${funcionarios.getEmail()}"/></td>
                        <td name="cargo"><c:out value="${funcionarios.getCargo()}"/></td>
                        <td name="filial"><c:out value="${funcionarios.getFilial()}"/></td>
                        <td name="departamento"><c:out value="${funcionarios.getDepartamento()}"/></td>
                        <td><a class="btn btn-danger" style="width: 100px" onclick="exclusao(${funcionarios.getId()}, 'Funcionario')"/><i class="glyphicon glyphicon-trash"> Remover </i></a></td>
                        <td><a class="btn btn-info" style="width: 100px" href="EditarFuncionario?action=edit&id=${funcionarios.getId()}"><i class="glyphicon glyphicon-pencil">Alterar</i></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
