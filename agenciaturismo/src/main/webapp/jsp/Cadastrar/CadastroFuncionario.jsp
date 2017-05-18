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
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/CadastroFuncionario" method="post" class="form-horizontal" data-toggle="validator">
                <div class="form-group ">
                    <label for="example-text-input" class="control-label col-md-4">Nome:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="nome" type="text" placeholder="Insira nome" data-maxlength="100" id="example-text-input" required>
                        <span class="help-block">Maximo 100 caracteres</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">CPF:</label>
                    <div class="controls col-md-5">
                        <input class="form-control cpf-mask" placeholder="000.000.000-00" name="cpf" type="text" id="example-text-input" required>

                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Sexo</label>
                    <div class="controls col-md-5">
                        <input class="form-control" placeholder="Genero" name="sexo" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-date-input" class="control-label col-md-4">Nascimento:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" placeholder="Insira nascimento" type="date" name="nascimento" id="example-date-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Rua:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="rua" placeholder="Insira rua" data-maxlength="50"  type="text" id="example-text-input" required>
                        <span class="help-block">Maximo 50 caracteres</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-number-input" class="control-label col-md-4">Numero:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="number" name="numero" placeholder="Insira numero"  id="example-number-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Complemento:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="complemento" placeholder="Insira complemento"  type="text" id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">CEP:</label>
                    <div class="controls col-md-5">
                        <input required class="form-control cep-mask form-control" placeholder="00000-000"  name="cep"  type="text" id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Cidade:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="cidade" placeholder="Insira cidade" data-maxlength="100"  type="text"id="example-text-input" required>
                        <span class="help-block">Maximo 100 caracteres</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Bairro:</label>
                    <div class="controls col-md-5">
                        <input required class="form-control" name="bairro" placeholder="Insira bairro" data-maxlength="50" type="text" id="example-text-input" required>
                        <span class="help-block">Maximo 50 caracteres</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Celular:</label>
                    <div class="controls col-md-5">
                        <input required  class="form-control cel-sp-mask" placeholder="(00) 00000-0000" name="celular" type="text" id="example-text-input">
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Telefone:</label>
                    <div class="controls col-md-5">
                        <input required  class="form-control phone-ddd-mask" placeholder="(00) 0000-0000"  name="telefone" type="text" id="example-text-input">
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-email-input" class="control-label col-md-4">Email:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="email" name="email" placeholder="Insira email" id="example-email-input" data-error="Por favor, informe um e-mail correto.">
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Departamento:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" placeholder="Insira departamento" name="departamento" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Cargo:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" placeholder="Insira cargo" name="cargo" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Filial</label>
                    <div class="controls col-md-5">
                        <input class="form-control" placeholder="Insira filial" name="filial" required>
                    </div>
                </div>
                <div class="col-md-12 text-center">
                    <button type="submit"><span class="">Cadastrar</span></button>
                </div>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
