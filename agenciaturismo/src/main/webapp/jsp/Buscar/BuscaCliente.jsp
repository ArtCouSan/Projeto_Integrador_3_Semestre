
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:import url="./Layout/cabecalho.jsp"/>
       <h1>Digite o campo(s) pela informação que gostaria de buscar</h1>
    <form action="${pageContext.request.contextPath}/BuscaCliente">
        <label for="txtnome">Nome:</label>  
            <input type="text" name="nome" placeholder="Insira nome"/>

            <label for="txtcpf">CPF:</label>
            <input type="text" name="cpf" placeholder="Insira cpf"/>

            <label for="txtsexo">Sexo:</label>
            <input type="text" name="sexo" placeholder="Insira sexo"/>

            <label for="txtnascimento">Nascimento:</label>
            <input type="text" name="nascimento" placeholder="Insira nascimento"/>

            <label for="txtrua">Rua:</label>
            <input type="text" name="rua" placeholder="Insira rua"/>

            <label for="txtnumero">Numero:</label>
            <input type="text" name="numero" placeholder="Insira numero"/>

            <label for="txtcomplemento">Complemento:</label>
            <input type="text" name="complemento" placeholder="Insira complemento"/>

            <label for="txtcep">CEP:</label>
            <input type="text" name="cep" placeholder="Insira cep"/>

            <label for="txtlogradouro">Logradouro:</label>
            <input type="text" name="logradouro" placeholder="Insira logradouro"/>

            <label for="txtcidade">Cidade:</label>
            <input type="text" name="cidade" placeholder="Insira cidade"/>

            <label for="txtbairro">Bairro:</label>
            <input type="text" name="bairro" placeholder="Insira bairro"/>

            <label for="txtestado">Estado:</label>
            <input type="text" name="estado" placeholder="Insira estado"/>

            <label for="txttelefone">Telefone:</label>
            <input type="text" name="telefone" placeholder="Insira telefone"/>

            <label for="txtcelular">Celular:</label>
            <input type="text" name="celular" placeholder="Insira celular"/>

            <label for="txtemail">Email:</label>
            <input type="text" name="email" placeholder="Insira email"/>

            <input type="submit" value="Buscar"/>
            <input type="reset" value="Apagar"/>
    </form>
    <c:import url="./Layout/rodape.jsp"/> 
</body>
</html>
