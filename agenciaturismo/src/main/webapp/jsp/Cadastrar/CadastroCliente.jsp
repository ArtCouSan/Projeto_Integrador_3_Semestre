<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html >
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Cadastro de Cliente</title>
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />

    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <div class="panel-body">
            <form action="CadastroCliente" method="post" class="form-horizontal">
                <div class="form-group ">
                    <c:if test="${erroNome}">
                        <div class="erro">O nome é obrigatório</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Nome:</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" name="nome" type="text" placeholder="Insira nome"  id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroCpf}">
                        <div class="erro">O nome é obrigatório</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">CPF:</label>
                    <div class="controls col-md-5">
                        <input maxlength="14"  class="form-control" onkeypress="mascara(this, '###.###.###-##')"  placeholder="000.000.000-00" name="cpf" type="text" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroSexo}">
                        <div class="erro">O nome é obrigatório</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Sexo</label>
                    <div class="controls col-md-5">
                        <input class="form-control" placeholder="Genero" name="sexo" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroNascimento}">
                        <div class="erro">O nome é obrigatório</div>
                    </c:if>
                    <label for="example-date-input" class="control-label col-md-4">Nascimento:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" placeholder="Insira nascimento" type="date" name="nascimento" id="example-date-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroRua}">
                        <div class="erro">O nome é obrigatório</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Rua:</label>
                    <div class="controls col-md-5">
                        <input maxlength="50" class="form-control" name="rua" placeholder="Insira rua"  type="text" id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroNumero}">
                        <div class="erro">O nome é obrigatório</div>
                    </c:if>
                    <label for="example-number-input" class="control-label col-md-4">Numero:</label>
                    <div class="controls col-md-5">
                        <input maxlength="3" class="form-control" type="number" name="numero" placeholder="Insira numero"  id="example-number-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroComplemento}">
                        <div class="erro">O nome é obrigatório</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Complemento:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="complemento" placeholder="Insira complemento"  type="text" id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroCep}">
                        <div class="erro">O nome é obrigatório</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">CEP:</label>
                    <div class="controls col-md-5">
                        <input required class="form-control form-control" onkeypress="mascara(this, '#####-###')" placeholder="00000-000"  name="cep"  type="text" id="example-text-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroCidade}">
                        <div class="erro">O nome é obrigatório</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Cidade:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="cidade" placeholder="Insira cidade" type="text"id="example-text-input" required>

                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroBairro}">
                        <div class="erro">O nome é obrigatório</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Bairro:</label>
                    <div class="controls col-md-5">
                        <input required class="form-control" name="bairro" placeholder="Insira bairro" type="text" id="example-text-input" required>

                    </div>
                </div>
                <div class="form-group">                  
                    <label for="example-text-input" class="control-label col-md-4">Celular:</label>
                    <div class="controls col-md-5">
                        <input class="form-control cel-sp-mask" onkeypress="mascara(this, '(##) #####-####')" placeholder="(00) 00000-0000" name="celular" type="text" id="example-text-input" data-mask="(00) 0000-0000" data-mask-selectonfocus="true">
                    </div>
                </div>
                <div class="form-group">               
                    <label for="example-text-input" class="control-label col-md-4">Telefone:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" onkeypress="mascara(this, '(##) ####-####')" placeholder="(00) 0000-0000"  name="telefone" type="text" id="example-text-input">
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-email-input" class="control-label col-md-4">Email:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="email" name="email" placeholder="Insira email" id="example-email-input" data-error="Por favor, informe um e-mail correto." required>
                    </div>
                </div>
                <div class="col-md-12 text-center">
                    <button type="submit" class="btn btn-primary botao_g"><span class="">Cadastrar</span></button>
                </div>
            </form>
        </div>
        <script src="./bootstrap/js/campos_Cliente.js" type="text/javascript" ></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
>>>>>>> master
