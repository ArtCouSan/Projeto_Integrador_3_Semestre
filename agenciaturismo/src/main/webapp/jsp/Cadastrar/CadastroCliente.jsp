<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html >
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Cadastro de Cliente</title>
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <form action="${pageContext.request.contextPath}/CadastroCliente" method="post" >
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">Nome:</label>
                <div class="col-10">
                    <input class="form-control" name="nome" type="text" placeholder="Insira nome" id="example-text-input" required>
                </div>
            </div>
            <label for="txtcpf">CPF:</label>
            <input type="text" name="cpf" placeholder="Insira cpf" required/>
            <br>
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">Sexo</label>
                <select name="sexo" class="form-control">
                    <option value="M">Masculino</option>
                    <option value="F">Feminino</option>
                </select>
            </div>
            <div class="form-group row form-inline">
                <label for="example-date-input" class="col-2 col-form-label">Nascimento:</label>
                <div class="col-10">
                    <input class="form-control" placeholder="Insira nascimento" type="date" name="nascimento" id="example-date-input" required>
                </div>
            </div>
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">Rua:</label>
                <div class="col-10">
                    <input required class="form-control" name="rua" placeholder="Insira rua"  type="text" id="example-text-input" required>
                </div>
            </div>
            <div class="form-group row form-inline">
                <label for="example-number-input" class="col-2 col-form-label">Numero:</label>
                <div class="col-10">
                    <input class="form-control" type="number" name="numero" placeholder="Insira numero"  id="example-number-input" required>
                </div>
            </div>
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">Complemento:</label>
                <div class="col-10">
                    <input required class="form-control" name="complemento" placeholder="Insira complemento"  type="text" id="example-text-input" required>
                </div>
            </div>
            <label for="txtcep">CEP:</label>
            <input type="text" name="cep" placeholder="Insira cep" required/>
            <br>
            <label for="txtcidade">Cidade:</label>
            <input type="text" name="cidade" placeholder="Insira cidade" required/>
            <br>
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">Bairro:</label>
                <div class="col-10">
                    <input required class="form-control" name="bairro" placeholder="Insira bairro" type="text" id="example-text-input" required>
                </div>
            </div>
            <label for="txttelefone">Telefone:</label>
            <input type="text" name="telefone" placeholder="Insira telefone" />
            <br>
            <label for="txtcelular">Celular:</label>
            <input type="text" name="celular" placeholder="Insira celular" />
            <br>
            <div class="form-group row form-inline">
                <label for="example-email-input" class="col-2 col-form-label">Email:</label>
                <div class="col-10">
                    <input class="form-control" type="email" name="email" placeholder="Insira email" id="example-email-input">
                </div>
            </div>
            <input type="submit" value="Salvar"/>
            <input type="reset" value="Apagar"/>
            <br>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
