s<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css"  href="./bootstrap/css/font-awesome.css" rel="stylesheet" />
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <script src="./bootstrap/js/camposMascara.js" type="text/javascript" ></script>
        <script src="./bootstrap/js/aceitacoes.js" type="text/javascript" ></script>
        <title>Editar Funcionario</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="panel-body">

            <form name="editaf" action="EditarFuncionario" method="post" class="form-horizontal">

                <input type="hidden" name="identificacao" value="${funcionarios.getId()}"/>
                <input type="hidden" name="login" value="${funcionarios.getLogin()}"/>
                <input type="hidden" name="senha" value="${funcionarios.getSenha()}"/>

                <div class="form-group ">
                    <c:if test="${erroNome}">
                        <div class="erro">Digite seu nome completo</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Nome <span class="fa fa-id-card"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getNome()}" maxlength="100" class="form-control" name="nome" type="text" placeholder="Insira nome" id="nome" required>
                    </div>
                </div>

                <div class="form-group ">
                    <c:if test="${erroCpf}">
                        <div class="erro">Digite um cpf válido</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Cpf <span class="fa fa-id-card"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getCpf()}" maxlength="100" class="form-control" name="cpf" type="text" placeholder="Insira cpf" id="cpf" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroSexo}">
                        <div class="erro">Selecione uma opcao</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Sexo <span class="glyphicon glyphicon-heart"></span> :</label>
                    <div class="controls col-md-5">
                        <select name="sexo" value="${funcionarios.getSexo()}" >
                            <option value="Masculino">Masculino</option>
                            <option value="Feminino">Feminino</option>
                            <option value="Outros">Outros</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroNascimento}">
                        <div class="erro">Selecione uma data</div>
                    </c:if>
                    <label for="example-date-input" class="control-label col-md-4">* Nascimento <span class="glyphicon glyphicon-baby-formula" ></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getData_nasc()}" class="form-control" type="date" name="nascimento" id="datanasc" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroRua}">
                        <div class="erro">Digite sua rua</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Rua <span class="glyphicon glyphicon-road"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getRua()}" maxlength="50" class="form-control" name="rua" placeholder="Insira rua" type="text" id="rua" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroNumero}">
                        <div class="erro">Digite o número da sua casa</div>
                    </c:if>
                    <label for="example-number-input" class="control-label col-md-4">* Numero <span class="fa fa-sort-numeric-desc"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getNumero()}" maxlength="5" class="form-control" type="number" name="numero" placeholder="Insira numero"  id="numero" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Complemento <span class="fa fa-flag"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getComplemento()}" maxlength="20" class="form-control" name="complemento" placeholder="Insira complemento"  type="text" id="complemento">
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCep}">
                        <div class="erro">Digite seu CEP</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* CEP <span class="glyphicon glyphicon-map-marker"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getCep()}" maxlength="9" required class="form-control" name="cep"  type="text" id="cep" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCidade}">
                        <div class="erro">Digite sua cidade</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Cidade <span class="glyphicon glyphicon-globe"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getCidade()}" maxlength="100" class="form-control" name="cidade" placeholder="Insira cidade" type="text" id="cidade" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroEstado}">
                        <div class="erro">Selecione uma opção</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Estado <span class="glyphicon glyphicon-globe"></span> :</label>
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
                    <label for="example-text-input" class="control-label col-md-4">Celular <span class="glyphicon glyphicon-phone"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getCelular()}" maxlength="14" class="form-control" name="celular" type="text" id="celular">
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Telefone <span class="glyphicon glyphicon-earphone"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getTelefone()}" maxlength="13" class="form-control" name="telefone" type="text" id="telefone">
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroEmail}">
                        <div class="erro">Digite um email válido</div>
                    </c:if>
                    <label for="example-email-input" class="control-label col-md-4">* Email <span class="glyphicon glyphicon-envelope"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getEmail()}" maxlength="50" class="form-control" type="email" name="email" placeholder="Insira email" id="email" data-error="Por favor, informe um e-mail correto." required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroDepartamento}">
                        <div class="erro">Digite o Departamento</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Departamento <span class="glyphicon glyphicon-inbox"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getDepartamento()}" maxlength="100" class="form-control" placeholder="Insira departamento" name="departamento" id="departamento" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCargo}">
                        <div class="erro">Digite o cargo</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Cargo <span class="glyphicon glyphicon-lock"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getCargo()}" maxlength="100" class="form-control" placeholder="Insira cargo" name="cargo" id="cargo" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroFilial}">
                        <div class="erro">Digite a filial</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Filial <span class="fa fa-rss"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getFilial()}" maxlength="100" class="form-control" placeholder="Insira filial" name="filial" id="filial" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroLogin}">
                        <div class="erro">Digite o login</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Login <span class="fa fa-sign-in"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getLogin()}" maxlength="100" class="form-control" placeholder="login" name="login" id="login" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroSenha}">
                        <div class="erro">Digite sua senha</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Senha <span class="glyphicon glyphicon-th"></span> :</label>
                    <div class="controls col-md-5">
                        <input value="${funcionarios.getSenha()}" type="password" maxlength="100" class="form-control" placeholder="senha" name="senha" id="senha" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroAcesso}">
                        <div class="erro">Acesso invalido</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Acesso <span class="glyphicon glyphicon-eye-open"></span> :</label>
                    <div class="controls col-md-5">
                        <select name="acesso" value="${funcionarios.getAcesso()}" >
                            <option value="Master">Master</option>
                            <option value="Vendedor">Vendedor</option>
                            <option value="Gerente_Venda">Gerente Venda</option>
                            <option value="Suporte_Informatica">Suporte Informatica</option>
                            <option value="Gerente_Informatica">Gerente Informatica</option>
                            <option value="Retaguarda">Retaguarda</option>
                            <option value="Gerente_Retaguarda">Gerente Retaguarda</option> 
                        </select>
                    </div>
                </div>
                <div class="col-lg-offset-4">
                    <button type="submit" style="width: 555px" class="btn btn-danger botao_g"><span class="glyphicon glyphicon-floppy-saved"> Alterar</span></button>
                </div>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
