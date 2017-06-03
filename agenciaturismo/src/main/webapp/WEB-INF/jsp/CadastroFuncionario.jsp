<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <script src="./bootstrap/js/camposMascara.js" type="text/javascript" ></script>
        <title>Cadastro de Funcionario</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="panel-body">
            <form name="cadastrof" action="CadastroFuncionario" method="post" class="form-horizontal" data-toggle="validator">

                <div class="form-group ">
                    <c:if test="${erroNome}">
                        <div class="erro">Digite seu nome completo</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Nome:</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" name="nome" type="text" placeholder="Insira nome" id="nome" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCpf}">
                        <div class="erro">Digite o CPF</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">CPF:</label>
                    <div class="controls col-md-5">
                        <input maxlength="14" class="form-control" name="cpf" type="text" id="cpf" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Sexo</label>
                    <div class="controls col-md-5">
                        <select name="sexo">
                            <option value="M">Masculino</option>
                            <option value="F">Feminino</option>
                            <option value="O">Outros</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-date-input" class="control-label col-md-4">Nascimento:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="date" name="nascimento" id="datanasc" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroRua}">
                        <div class="erro">Digite sua rua</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Rua:</label>
                    <div class="controls col-md-5">
                        <input maxlength="50" class="form-control" name="rua" placeholder="Insira rua" type="text" id="rua" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroNumero}">
                        <div class="erro">Digite o número da sua casa</div>
                    </c:if>
                    <label for="example-number-input" class="control-label col-md-4">Numero:</label>
                    <div class="controls col-md-5">
                        <input maxlength="5" class="form-control" type="number" name="numero" placeholder="Insira numero"  id="numero" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Complemento:</label>
                    <div class="controls col-md-5">
                        <input  maxlength="20" class="form-control" name="complemento" placeholder="Insira complemento"  type="text" id="complemento">
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCep}">
                        <div class="erro">Digite seu CEP</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">CEP:</label>
                    <div class="controls col-md-5">
                        <input maxlength="9" required class="form-control" name="cep"  type="text" id="cep" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCidade}">
                        <div class="erro">Digite sua cidade</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Cidade:</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" name="cidade" placeholder="Insira cidade" type="text" id="cidade" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Estado:</label>
                    <div class="controls col-md-5">
                        <select name="estado">
                            <option value="AC">AC</option>
                            <option value="AL">AL</option>
                            <option value="AP">AP</option>
                            <option value="AM">AM</option>
                            <option value="BA">BA</option>
                            <option value="CE">CE</option>
                            <option value="DF">DF</option>
                            <option value="ES">ES</option>
                            <option value="GO">GO</option>
                            <option value="MA">MA</option>
                            <option value="MT">MT</option>
                            <option value="MS">MS</option>
                            <option value="MG">MG</option>
                            <option value="PA">PA</option>
                            <option value="PB">PB</option>
                            <option value="PR">PR</option>
                            <option value="PE">PE</option>
                            <option value="PI">PI</option>
                            <option value="RJ">RJ</option>
                            <option value="RN">RN</option>
                            <option value="RS">RS</option>
                            <option value="RO">RO</option>
                            <option value="RR">RR</option>
                            <option value="SC">SC</option>
                            <option value="SP">SP</option>
                            <option value="SE">SE</option>
                            <option value="TO">TO</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Celular:</label>
                    <div class="controls col-md-5">
                        <input maxlength="14" class="form-control" name="celular" type="text" id="celular">
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Telefone:</label>
                    <div class="controls col-md-5">
                        <input maxlength="13" class="form-control" name="telefone" type="text" id="telefone">
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroEmail}">
                        <div class="erro">Digite um email válido</div>
                    </c:if>
                    <label for="example-email-input" class="control-label col-md-4">Email:</label>
                    <div class="controls col-md-5">
                        <input maxlength="50" class="form-control" type="email" name="email" placeholder="Insira email" id="email" data-error="Por favor, informe um e-mail correto." required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroDepartamento}">
                        <div class="erro">Digite o Departamento</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Departamento:</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" placeholder="Insira departamento" name="departamento" id="departamento" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCargo}">
                        <div class="erro">Digite o cargo</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Cargo:</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" placeholder="Insira cargo" name="cargo" id="cargo" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroFilial}">
                        <div class="erro">Digite a filial</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Filial</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" placeholder="Insira filial" name="filial" id="filial" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroLogin}">
                        <div class="erro">Digite o login</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Login</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" placeholder="login" name="login" id="login" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroSenha}">
                        <div class="erro">Digite sua senha</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Senha</label>
                    <div class="controls col-md-5">
                        <input type="password" maxlength="100" class="form-control" placeholder="senha" name="senha" id="senha" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroAcesso}">
                        <div class="erro">Acesso invalido</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Acesso</label>
                    <div class="controls col-md-5">
                        <select name="acesso">
                            <option value="MASTER">MASTER</option>
                            <option value="BASICO">BASICO</option>
                        </select>
                    </div>
                </div>

                <div class="col-md-12 text-center">
                    <button type="submit" class="btn btn-primary botao_g"><span class="">Cadastrar</span></button>
                </div>
                
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
