<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <script src="./bootstrap/js/event.js" type="text/javascript" ></script>
        <title>Editar Cliente</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <form name="editac" action="EditarCliente" method="post" class="form-horizontal">
            <input type="hidden" name="identificacao" value="${clientes.getId_cliente()}"/>
            <div class="form-group ">
                <c:if test="${erroNome}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-text-input" class="control-label col-md-4">Nome:</label>
                <div class="controls col-md-5">
                    <input class="form-control" name="nome" type="text" value="${clientes.getNome()}" data-maxlength="100" id="example-text-input" required>
                    <span class="help-block">Maximo 100 caracteres</span>
                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroCpf}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-text-input" class="control-label col-md-4">CPF:</label>
                <div class="controls col-md-5">
                    <input class="form-control cpf-mask" value="${clientes.getCpf()}" name="cpf" type="text" id="example-text-input" required>

                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroSexo}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-text-input" class="control-label col-md-4">Sexo</label>
                <div class="controls col-md-5">
                    <input class="form-control" value="${clientes.getSexo()}" name="sexo" required>
                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroNascimento}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-date-input" class="control-label col-md-4">Nascimento:</label>
                <div class="controls col-md-5">
                    <input class="form-control" value="${clientes.getData_nasc()}" type="date" name="nascimento" id="example-date-input" required>
                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroRua}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-text-input" class="control-label col-md-4">Rua:</label>
                <div class="controls col-md-5">
                    <input class="form-control" name="rua" value="${clientes.getRua()}" data-maxlength="50"  type="text" id="example-text-input" required>
                    <span class="help-block">Maximo 50 caracteres</span>
                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroNumero}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-number-input" class="control-label col-md-4">Numero:</label>
                <div class="controls col-md-5">
                    <input class="form-control" type="number" name="numero" value="${clientes.getNumero()}" id="example-number-input" required>
                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroComplemento}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-text-input" class="control-label col-md-4">Complemento:</label>
                <div class="controls col-md-5">
                    <input class="form-control" name="complemento" value="${clientes.getComplemento()}" type="text" id="example-text-input" required>
                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroCep}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-text-input" class="control-label col-md-4">CEP:</label>
                <div class="controls col-md-5">
                    <input required class="form-control cep-mask form-control" value="${clientes.getCep()}" name="cep"  type="text" id="example-text-input" required>
                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroCidade}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-text-input" class="control-label col-md-4">Cidade:</label>
                <div class="controls col-md-5">
                    <input class="form-control" name="cidade" value="${clientes.getCidade()}" data-maxlength="100"  type="text"id="example-text-input" required>
                    <span class="help-block">Maximo 100 caracteres</span>
                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroBairro}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-text-input" class="control-label col-md-4">Bairro:</label>
                <div class="controls col-md-5">
                    <input required class="form-control" name="bairro" value="${clientes.getBairro()}" data-maxlength="50" type="text" id="example-text-input" required>
                    <span class="help-block">Maximo 50 caracteres</span>
                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroCelular}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-text-input" class="control-label col-md-4">Celular:</label>
                <div class="controls col-md-5">
                    <input class="form-control cel-sp-mask" value="${clientes.getCelular()}" name="celular" type="text" id="example-text-input" required>
                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroTelefone}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-text-input" class="control-label col-md-4">Telefone:</label>
                <div class="controls col-md-5">
                    <input class="form-control phone-ddd-mask" value="${clientes.getTelefone()}" name="telefone" type="text" id="example-text-input" required>
                </div>
            </div>
            <div class="form-group">
                <c:if test="${erroEmail}">
                    <div class="erro">O nome é obrigatório</div>
                </c:if>
                <label for="example-email-input" class="control-label col-md-4">Email:</label>
                <div class="controls col-md-5">
                    <input class="form-control" type="email" name="email" value="${clientes.getEmail()}"  id="example-email-input" data-error="Por favor, informe um e-mail correto." required>
                </div>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <div class="aab controls col-md-4">
                    <div class="controls col-md-8" >
                        <input type="submit" value="Alterar" />
                    </div>
                </div>
            </div>
        </form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>