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
        <script src="./bootstrap/js/camposMascara.js" type="text/javascript" ></script>
        <title>Editar Funcionario</title>
    </head>
    <body>
        <c:import url="WEB-INF/jsp/Layout/cabecalho.jsp"/>
        <div class="panel-body">
            <form name="editaf" action="EditarFuncionario" method="post" class="form-horizontal">
                <input type="hidden" name="cpf" value="${funcionarios.getCpf()}"/>

                <div class="form-group ">
                    <c:if test="${erroNome}">
                        <div class="erro">Digite seu nome completo</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Nome:</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getNome()}" maxlength="100" class="form-control" name="nome" type="text" placeholder="Insira nome" id="nome" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Sexo</label>
                    <div class="controls col-md-5">
                        <select name="sexo" value="${funcionarios.getSexo()}" >
                            <option value="Masculino">Masculino</option>
                            <option value="Feminino">Feminino</option>
                            <option value="Outros">Outros</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-date-input" class="control-label col-md-4">Nascimento:</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getData_nasc()}" class="form-control" type="date" name="nascimento" id="datanasc" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroRua}">
                        <div class="erro">Digite sua rua</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Rua:</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getRua()}" maxlength="50" class="form-control" name="rua" placeholder="Insira rua" type="text" id="rua" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroNumero}">
                        <div class="erro">Digite o número da sua casa</div>
                    </c:if>
                    <label for="example-number-input" class="control-label col-md-4">Numero:</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getNumero()}" maxlength="5" class="form-control" type="number" name="numero" placeholder="Insira numero"  id="numero" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Complemento:</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getComplemento()}" maxlength="20" class="form-control" name="complemento" placeholder="Insira complemento"  type="text" id="complemento">
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCep}">
                        <div class="erro">Digite seu CEP</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">CEP:</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getCep()}" maxlength="9" required class="form-control" name="cep"  type="text" id="cep" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCidade}">
                        <div class="erro">Digite sua cidade</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Cidade:</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getCidade()}" maxlength="100" class="form-control" name="cidade" placeholder="Insira cidade" type="text" id="cidade" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Estado:</label>
                    <div class="controls col-md-5">
                        <select name="estado" value="${funcionarios.getEstado()}" >
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
                        <input value="${funcionarios.getCelular()}" maxlength="14" class="form-control" name="celular" type="text" id="celular">
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Telefone:</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getTelefone()}" maxlength="13" class="form-control" name="telefone" type="text" id="telefone">
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-email-input" class="control-label col-md-4">Email:</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getEmail()}" maxlength="50" class="form-control" type="email" name="email" placeholder="Insira email" id="email" data-error="Por favor, informe um e-mail correto." required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroDepartamento}">
                        <div class="erro">Digite o Departamento</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Departamento:</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getDepartamento()}" maxlength="100" class="form-control" placeholder="Insira departamento" name="departamento" id="departamento" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCargo}">
                        <div class="erro">Digite o cargo</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Cargo:</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getCargo()}" maxlength="100" class="form-control" placeholder="Insira cargo" name="cargo" id="cargo" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroFilial}">
                        <div class="erro">Digite a filial</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Filial</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getFilial()}" maxlength="100" class="form-control" placeholder="Insira filial" name="filial" id="filial" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroLogin}">
                        <div class="erro">Digite o login</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Login</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getLogin()}" maxlength="100" class="form-control" placeholder="login" name="login" id="login" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroSenha}">
                        <div class="erro">Digite sua senha</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">Senha</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getSenha()}" type="password" maxlength="100" class="form-control" placeholder="senha" name="senha" id="senha" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Acesso</label>
                    <div class="controls col-md-5">
                        <select name="acesso" value="${funcionarios.getAcesso()}" >
                            <option value="MASTER">MASTER</option>
                            <option value="BASICO">BASICO</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="aab controls col-md-4">
                        <div class="controls col-md-8" >
                            <button type="submit"><span class="">Alterar</span></button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
