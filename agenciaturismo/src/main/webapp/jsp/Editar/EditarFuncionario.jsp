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
        <label name="identificacao">${funcionario.getId_func()}</label>
        <label for="txtnome">Nome:</label>  
        <input type="text" name="nome" value="${funcionario.getNome()}"/>
        <br>
        <label for="txtcpf">CPF:</label>
        <input type="text" name="cpf" value="${funcionario.getCpf()}"/>
        <br>
        <label for="txtsexo">Sexo:</label>
        <input type="text" name="sexo" value="${funcionario.getSexo()}"/>
        <br>
        <label for="txtnascimento">Nascimento:</label>
        <input type="text" name="nascimento" value="${funcionario.getData_nasc()}"/>
        <br>
        <label for="txtrua">Rua:</label>
        <input type="text" name="rua" value="${funcionario.getRua()}"/>
        <br>
        <label for="txtnumero">Numero:</label>
        <input type="text" name="numero" value="${funcionario.getNumero()}"/>
        <br>
        <label for="txtcomplemento">Complemento:</label>
        <input type="text" name="complemento" value="${funcionario.getComplemento()}"/>
        <br>
        <label for="txtlogradouro">Logradouro:</label>
        <input type="text" name="logradouro" value="${funcionario.getLogradouro()}"/>
        <br>
        <label for="txtcep">CEP:</label>
        <input type="text" name="cep" value="${funcionario.getCep()}"/>
        <br>
        <label for="txtbairro">Bairro:</label>
        <input type="text" name="bairro" value="${funcionario.getBairro()}"/>
        <br>
        <label for="txtcidade">Cidade:</label>
        <input type="text" name="cidade" value="${funcionario.getCidade()}"/>
        <br>
        <label for="txttelefone">Telefone:</label>
        <input type="text" name="telefone" value="${funcionario.getTelefone()}"/>
        <br>
        <label for="txtcelular">Celular:</label>
        <input type="text" name="celular" value="${funcionario.getCelular()}""/>
        <br>
        <label for="txtemail">Email:</label>
        <input type="text" name="email" value="${funcionario.getEmail()}"/>
        <br>
        <label for="txtdepartamento">Departamento:</label>
        <input type="text" name="departamento" value="${funcionario.getDepartamento()}"/>
        <br>
        <label for="txtcargo">Cargo:</label>
        <input type="text" name="cargo" value="${funcionario.getCargo()}"/>
        <br>
        <label for="txtfilial">Filial:</label>
        <input type="text" name="filial" value="${funcionario.getFilial()}"/>
        <br>
        <input type="submit" value="Alterar"/>
        <br>
    </form>
    <c:import url="./Layout/rodape.jsp"/>
</body>
</html>
