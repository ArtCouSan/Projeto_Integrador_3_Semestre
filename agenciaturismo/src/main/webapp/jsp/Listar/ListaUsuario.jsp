<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <title>Listar Usuario</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <table class="table table-striped">
            <thead>
                <tr class="info">
                    <th>Nome</th>
                    <th>Login</th>
                    <th>Acesso</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="usuarios" items="${encontrados}">
                    <tr >
                        <td><c:out value="${usuarios.getNome()}"/></td>
                        <td><c:out value="${usuarios.getLogin()}"/></td>
                        <td><c:out value="${usuarios.getAcesso()}"/></td>
                        <td><a class="btn btn-danger" href="ExcluiUsuarioServlet?action=remove&id=${usuarios.getId_usuario()}&pesquisa=${pesquisa}"/><i class="glyphicon glyphicon-trash">Remover</i></a></td>
                        <td><a class="btn btn-info" href="EditarUsuario?action=edit&id=${usuarios.getId_usuario()}"><i class="glyphicon glyphicon-pencil">Alterar</i></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
