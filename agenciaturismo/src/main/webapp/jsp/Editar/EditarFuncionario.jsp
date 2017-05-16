<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jss/eventos.js" type="text/javascript" ></script>
        <!--        <link href="foundation/css/foundation.css" rel="stylesheet" type="text/css"/>
                <link href="foundation/css/foundation-icons/foundation-icons.css" rel="stylesheet" type="text/css"/>-->
        <title>Alterar Funcionario</title>
    </head>
    <body>
    <c:import url="./Layout/cabecalho.jsp"/>
    <form action="${pageContext.request.contextPath}/EditarFuncionario" method="post">
        <label name="identificacao">${funcionarios.getId_func()}</label>
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
    <c:import url="./Layout/rodape.jsp"/>
</body>
</html>
