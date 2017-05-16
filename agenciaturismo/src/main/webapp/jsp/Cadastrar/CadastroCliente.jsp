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
        <form action="${pageContext.request.contextPath}/CadastroCliente" method="post" class="text-justify" data-toggle="validator">
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">Nome:</label>
                <div class="col-10">
                    <input class="form-control" name="nome" type="text" placeholder="Insira nome" data-maxlength="100" id="example-text-input" required>
                    <span class="help-block">Maximo 100 caracteres</span>
                </div>
            </div>
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">CPF:</label>
                <div class="col-10">
                    <input class="form-control cpf-mask" placeholder="000.000.000-00" name="cpf" type="text" id="example-text-input" required>

                </div>
            </div>
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
                    <input class="form-control" name="rua" placeholder="Insira rua" data-maxlength="50"  type="text" id="example-text-input" required>
                    <span class="help-block">Maximo 50 caracteres</span>
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
                    <input class="form-control" name="complemento" placeholder="Insira complemento"  type="text" id="example-text-input" required>
                </div>
            </div>
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">CEP:</label>
                <div class="col-10">
                    <input required class="form-control cep-mask form-control" placeholder="00000-000"  name="cep"  type="text" id="example-text-input" required>
                </div>
            </div>
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">Cidade:</label>
                <div class="col-10">
                    <input class="form-control" name="cidade" placeholder="Insira cidade" data-maxlength="100"  type="text"id="example-text-input" required>
                    <span class="help-block">Maximo 100 caracteres</span>
                </div>
            </div>
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">Bairro:</label>
                <div class="col-10">
                    <input required class="form-control" name="bairro" placeholder="Insira bairro" data-maxlength="50" type="text" id="example-text-input" required>
                    <span class="help-block">Maximo 50 caracteres</span>
                </div>
            </div>
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">Celular:</label>
                <div class="col-10">
                    <input required  class="form-control cel-sp-mask" placeholder="(00) 00000-0000" name="celular" type="text" id="example-text-input">
                </div>
            </div>
            <div class="form-group row form-inline">
                <label for="example-text-input" class="col-2 col-form-label">Telefone:</label>
                <div class="col-10">
                    <input required  class="form-control phone-ddd-mask" placeholder="(00) 0000-0000"  name="telefone" type="text" id="example-text-input">
                </div>
            </div>
            <div class="form-group row form-inline">
                <label for="example-email-input" class="col-2 col-form-label">Email:</label>
                <div class="col-10">
                    <input class="form-control" type="email" name="email" placeholder="Insira email" id="example-email-input" data-error="Por favor, informe um e-mail correto.">
                </div>
                <div class="help-block with-errors"></div>
            </div>
            <div class="btn-toolbar">
                <div class="btn-group">
                    <button type="submit"><i class="icon-ok">Cadastrar</i></button>
                    <button type="reset"><i class="icon-remove">Apagar Campos</i></button>
                </div>
            </div>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
