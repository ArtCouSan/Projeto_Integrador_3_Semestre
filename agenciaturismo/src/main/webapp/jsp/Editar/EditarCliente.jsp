<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <script src="jss/eventos.js" type="text/javascript" ></script>
        <title>Editar Cliente</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <form action="${pageContext.request.contextPath}/EditarCliente" method="post">
            <input type="text" name="identificacao" value="${clientes.getId_cliente()}"/>
            <br>
            <form action="${pageContext.request.contextPath}/CadastroCliente" method="post" class="text-justify">
                <div class="form-group row form-inline">
                    <label for="example-text-input" class="col-2 col-form-label">Nome:</label>
                    <div class="col-10">
                        <input class="form-control" name="nome" type="text" value="${clientes.getNome()}" id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-text-input" class="col-2 col-form-label">CPF:</label>
                    <div class="col-10">
                        <input required class="form-control cpf-mask" value="${clientes.getCpf()}" name="cpf" type="text" id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-text-input" class="col-2 col-form-label">Sexo</label>
                    <select name="sexo" class="form-control" value="${clientes.getSexo()}">
                        <option value="M">Masculino</option>
                        <option value="F">Feminino</option>
                    </select>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-date-input" class="col-2 col-form-label">Nascimento:</label>
                    <div class="col-10">
                        <input class="form-control" value="${clientes.getData_nasc()}" type="date" name="nascimento" id="example-date-input" required>
                    </div>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-text-input" class="col-2 col-form-label">Rua:</label>
                    <div class="col-10">
                        <input required class="form-control" name="rua" value="${clientes.getRua()}"  type="text" id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-number-input" class="col-2 col-form-label">Numero:</label>
                    <div class="col-10">
                        <input class="form-control" type="number" name="numero" value="${clientes.getNumero()}"  id="example-number-input" required>
                    </div>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-text-input" class="col-2 col-form-label">Complemento:</label>
                    <div class="col-10">
                        <input required class="form-control" name="complemento" value="${clientes.getComplemento()}"  type="text" id="example-text-input">
                    </div>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-text-input" class="col-2 col-form-label">CEP:</label>
                    <div class="col-10">
                        <input required class="form-control cep-mask form-control" value="${clientes.getCep()}"  name="cep"  type="text" id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-text-input" class="col-2 col-form-label">Cidade:</label>
                    <div class="col-10">
                        <input class="form-control" name="cidade" value="${clientes.getCidade()}"  type="text"id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-text-input" class="col-2 col-form-label">Bairro:</label>
                    <div class="col-10">
                        <input required class="form-control" name="bairro" value="${clientes.getBairro()}" type="text" id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-text-input" class="col-2 col-form-label">Celular:</label>
                    <div class="col-10">
                        <input required  class="form-control cel-sp-mask" value="${clientes.getCelular()}" name="celular" type="text" id="example-text-input">
                    </div>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-text-input" class="col-2 col-form-label">Telefone:</label>
                    <div class="col-10">
                        <input required  class="form-control phone-ddd-mask" value="${clientes.getTelefone()}"  name="telefone" type="text" id="example-text-input">
                    </div>
                </div>
                <div class="form-group row form-inline">
                    <label for="example-email-input" class="col-2 col-form-label">Email:</label>
                    <div class="col-10">
                        <input class="form-control" type="email" name="email" value="${clientes.getEmail()}" id="example-email-input">
                    </div>
                </div>
                <input type="submit" value="Alterar" />
            </form>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
            <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>