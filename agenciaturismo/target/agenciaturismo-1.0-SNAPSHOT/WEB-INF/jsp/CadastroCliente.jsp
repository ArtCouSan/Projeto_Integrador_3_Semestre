<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jss/eventos.js" type="text/javascript" ></script>
        <link href="foundation/css/foundation.css" rel="stylesheet" type="text/css"/>
        <link href="foundation/css/foundation-icons/foundation-icons.css" rel="stylesheet" type="text/css"/>
        <title>Cadastro de Funcionario</title>
    </head>
    <body>
        <form action="cliente" method="post">
            <label for="txtnome">Nome:</label>  
            <input type="text" name="nome" placeholder="Insira nome"/>
            <br />
            <label for="txtcpf">CPF:</label>
            <input type="cpf" name="cpf" placeholder="Insira cpf"/>
            <br />
            <label for="txtsexo">Sexo:</label>
            <input type="text" name="sexo" placeholder="Insira sexo"/>
            <br />
            <label for="txtnascimento">Nascimento:</label>
            <input type="text" name="nascimento" placeholder="Insira nascimento"/>
            <br />
            <label for="txtrua">Rua:</label>
            <input type="text" name="rua" placeholder="Insira rua"/>
            <br />
            <label for="txtnumero">Numero:</label>
            <input type="text" name="numero" placeholder="Insira rua"/>
            <br />
            <label for="txtcomplemento">Complemento:</label>
            <input type="text" name="rua" placeholder="Insira complemento"/>
            <br />
            <label for="txtcep">CEP:</label>
            <input type="text" name="cep" placeholder="Insira cep"/>
            <br />
            <label for="txtcidade">Cidade:</label>
            <input type="text" name="cidade" placeholder="Insira cidade"/>
            <br />
            <label for="txtestado">Estado:</label>
            <input type="text" name="estado" placeholder="Insira estado"/>
            <br />
            <label for="txttelefone">Telefone:</label>
            <input type="text" name="telefone" placeholder="Insira telefone"/>
            <br />
            <label for="txtcelular">Celular:</label>
            <input type="text" name="celular" placeholder="Insira celular"/>
            <br />
            <label for="txtemail">Email:</label>
            <input type="text" name="email" placeholder="Insira email"/>
            <br />
            
            <input type="submit" value="Salvar" />
        </form>        
    </body>
</html>