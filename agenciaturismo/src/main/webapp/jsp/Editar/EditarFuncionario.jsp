<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <script src="jss/eventos.js" type="text/javascript" ></script>
        <title>Editar Funcionario</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <form action="${pageContext.request.contextPath}/EditarFuncionario" method="post">
            <input type="text" name="identificacao" value="${funcionarios.getId_func()}"/>
            <br>
            <label for="txtnome">Nome:</label>  
            <input type="text" name="nome" value="${funcionarios.getNome()}"/>
            <br>
            <label for="txtcpf">CPF:</label>
            <input type="text" name="cpf" value="${funcionarios.getCpf()}"/>
            <br>
            <label for="txtsexo">Sexo:</label>
            <input type="text" name="sexo" value="${funcionarios.getSexo()}"/>
            <br>
            <label for="txtnascimento">Nascimento:</label>
            <input type="text" name="nascimento" value="${funcionarios.getData_nasc()}"/>
            <br>
            <label for="txtrua">Rua:</label>
            <input type="text" name="rua" value="${funcionarios.getRua()}"/>
            <br>
            <label for="txtnumero">Numero:</label>
            <input type="text" name="numero" value="${funcionarios.getNumero()}"/>
            <br>
            <label for="txtcomplemento">Complemento:</label>
            <input type="text" name="complemento" value="${funcionarios.getComplemento()}"/>
            <br>
            <label for="txtcep">CEP:</label>
            <input type="text" name="cep" value="${funcionarios.getCep()}"/>
            <br>
            <label for="txtbairro">Bairro:</label>
            <input type="text" name="bairro" value="${funcionarios.getBairro()}"/>
            <br>
            <label for="txtcidade">Cidade:</label>
            <input type="text" name="cidade" value="${funcionarios.getCidade()}"/>
            <br>
            <label for="txttelefone">Telefone:</label>
            <input type="text" name="telefone" value="${funcionarios.getTelefone()}"/>
            <br>
            <label for="txtcelular">Celular:</label>
            <input type="text" name="celular" value="${funcionarios.getCelular()}""/>
            <br>
            <label for="txtemail">Email:</label>
            <input type="text" name="email" value="${funcionarios.getEmail()}"/>
            <br>
            <label for="txtdepartamento">Departamento:</label>
            <input type="text" name="departamento" value="${funcionarios.getDepartamento()}"/>
            <br>
            <label for="txtcargo">Cargo:</label>
            <input type="text" name="cargo" value="${funcionarios.getCargo()}"/>
            <br>
            <label for="txtfilial">Filial:</label>
            <input type="text" name="filial" value="${funcionarios.getFilial()}"/>
            <br>
            <input type="submit" value="Alterar"/>
            <br>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
