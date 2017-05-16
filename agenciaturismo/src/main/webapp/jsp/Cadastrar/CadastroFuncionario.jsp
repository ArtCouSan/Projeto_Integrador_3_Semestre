<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <title>Cadastro de Funcionario</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <form action="${pageContext.request.contextPath}/CadastroFuncionario" method="post">

            <label for="txtnome">Nome:</label>  
            <input type="text" name="nome" placeholder="Insira nome"required/>
            <br>
            <label for="txtcpf">CPF:</label>
            <input type="text" name="cpf" placeholder="Insira cpf" required/>
            <br>
            <label for="txtsexo">Sexo:</label>
            <input type="text" name="sexo" placeholder="Insira sexo" required/>
            <br>
            <label for="txtnascimento">Nascimento:</label>
            <input type="text" name="nascimento" placeholder="Insira nascimento" required/>
            <br>
            <label for="txtrua">Rua:</label>
            <input type="text" name="rua" placeholder="Insira rua" required/>
            <br>
            <label for="txtnumero">Numero:</label>
            <input type="text" name="numero" placeholder="Insira numero" required/>
            <br>
            <label for="txtcomplemento">Complemento:</label>
            <input type="text" name="complemento" placeholder="Insira complemento" required/>
            <br>
            <label for="txtcep">CEP:</label>
            <input type="text" name="cep" placeholder="Insira cep" required/>
            <br>
            <label for="txtbairro">Bairro:</label>
            <input type="text" name="bairro" placeholder="Insira bairro"  required/>
            <br>
            <label for="txtcidade">Cidade:</label>
            <input type="text" name="cidade" placeholder="Insira cidade" required/>
            <br>
            <label for="txtestado">Estado:</label>
            <input type="text" name="estado" placeholder="Insira estado" required/>
            <br>
            <label for="txttelefone">Telefone:</label>
            <input type="text" name="telefone" placeholder="Insira telefone" required/>
            <br>
            <label for="txtcelular">Celular:</label>
            <input type="text" name="celular" placeholder="Insira celular" required/>
            <br>
            <label for="txtemail">Email:</label>
            <input type="text" name="email" placeholder="Insira email" required/>
            <br>
            <label for="txtdepartamento">Departamento:</label>
            <input type="text" name="departamento" placeholder="Insira departamento" required/>
            <br>
            <label for="txtcargo">Cargo:</label>
            <input type="text" name="cargo" placeholder="Insira cargo" required/>
            <br>
            <label for="txtfilial">Filial:</label>
            <input type="text" name="filial" placeholder="Insira filial" required/>
            <br>
            <input type="submit" value="Salvar"/>
            <input type="reset" value="Apagar"/>
            <br>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
