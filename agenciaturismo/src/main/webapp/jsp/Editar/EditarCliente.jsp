<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jss/eventos.js" type="text/javascript" ></script>
        <!--        <link href="foundation/css/foundation.css" rel="stylesheet" type="text/css"/>
                <link href="foundation/css/foundation-icons/foundation-icons.css" rel="stylesheet" type="text/css"/>-->
        <title>Editar Cliente</title>
    </head>
    <body>
    <c:import url="./Layout/cabecalho.jsp"/>
    <form action="${pageContext.request.contextPath}/EditarCliente" method="post">
        <label name="identificacao">${clientes.getId_cliente()}</label>
        <br>
        <label for="txtnome">Nome:</label>  
        <input type="text" name="nome" value="${clientes.getNome()}"/>
        <br>
        <label for="txtcpf">CPF:</label>
        <input type="text" name="cpf" value="${clientes.getCpf()}"/>
        <br>
        <label for="txtsexo">Sexo:</label>
        <input type="text" name="sexo" value="${clientes.getSexo()}"/>
        <br>
        <label for="txtnascimento">Nascimento:</label>
        <input type="text" name="nascimento" value="${clientes.getData_nasc()}"/>
        <br>
        <label for="txtrua">Rua:</label>
        <input type="text" name="rua" value="${clientes.getRua()}"/>
        <br>
        <label for="txtnumero">Numero:</label>
        <input type="text" name="numero" value="${clientes.getNumero()}"/>
        <br>
        <label for="txtcomplemento">Complemento:</label>
        <input type="text" name="complemento" value="${clientes.getComplemento()}"/>
        <br>
        <label for="txtcep">CEP:</label>
        <input type="text" name="cep" value="${clientes.getCep()}"/>
        <br>
        <label for="txtcidade">Cidade:</label>
        <input type="text" name="cidade" value="${clientes.getCidade()}"/>
        <br>
        <label for="txtbairro">Bairro:</label>
        <input type="text" name="bairro" value="${clientes.getBairro()}"/>
        <br>
        <label for="txttelefone">Telefone:</label>
        <input type="text" name="telefone" value="${clientes.getTelefone()}"/>
        <br>
        <label for="txtcelular">Celular:</label>
        <input type="text" name="celular" value="${clientes.getCelular()}"/>
        <br>
        <label for="txtemail">Email:</label>
        <input type="text" name="email" value="${clientes.getEmail()}"/>
        <br>
        <input type="submit" value="Alterar" />
        <br>
    </form>     
    <c:import url="./Layout/rodape.jsp"/>
</body>
</html>