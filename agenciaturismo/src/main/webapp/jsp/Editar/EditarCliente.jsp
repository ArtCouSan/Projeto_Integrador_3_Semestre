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

        <label for="txtnome">Nome:</label>  
        <input type="text" name="nome" value="{}"/>
        <br>
        <label for="txtcpf">CPF:</label>
        <input type="text" name="cpf" value="{}"/>
        <br>
        <label for="txtsexo">Sexo:</label>
        <input type="text" name="sexo" value="{}"/>
        <br>
        <label for="txtnascimento">Nascimento:</label>
        <input type="text" name="nascimento" value="{}"/>
        <br>
        <label for="txtrua">Rua:</label>
        <input type="text" name="rua" value="{}"/>
        <br>
        <label for="txtnumero">Numero:</label>
        <input type="text" name="numero" value="{}"/>
        <br>
        <label for="txtcomplemento">Complemento:</label>
        <input type="text" name="complemento" value="{}"/>
        <br>
        <label for="txtcep">CEP:</label>
        <input type="text" name="cep" value="{}"/>
        <br>
        <label for="txtlogradouro">Logradouro:</label>
        <input type="text" name="logradouro" value="{}"/>
        <br>
        <label for="txtcidade">Cidade:</label>
        <input type="text" name="cidade" value="{}"/>
        <br>
        <label for="txtbairro">Bairro:</label>
        <input type="text" name="bairro" value="{}"/>
        <br>
        <label for="txtestado">Estado:</label>
        <input type="text" name="estado" value="{}"/>
        <br>
        <label for="txttelefone">Telefone:</label>
        <input type="text" name="telefone" value="{}"/>
        <br>
        <label for="txtcelular">Celular:</label>
        <input type="text" name="celular" value="{}"/>
        <br>
        <label for="txtemail">Email:</label>
        <input type="text" name="email" value="{}"/>
        <br>
        <input type="submit" value="Salvar"/>
        <br>
    </form>     
    <c:import url="./Layout/rodape.jsp"/>
</body>
</html>