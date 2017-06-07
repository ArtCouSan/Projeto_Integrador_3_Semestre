<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/font-awesome.css" rel="stylesheet" />
        <script src="./bootstrap/js/camposMascara.js" type="text/javascript" ></script>
        <script src="./bootstrap/js/aceitacoes.js" type="text/javascript" ></script>
        <title>Cadastro de Funcionario</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="panel-body">
            <form action="CadastroFuncionario"  method="post" class="form-horizontal" >
                <div class="form-group ">
                    <c:if test="${erroNome}">
                        <script>alert("Erro no nome!")</script>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Nome <span class="fa fa-id-card"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" name="nome" type="text" placeholder="Insira nome" id="nome" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCpf}">
                        <script>alert("Erro no cpf!")</script>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* CPF <span class="glyphicon glyphicon-book"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="14" class="form-control" name="cpf" type="text" id="cpf" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">* Sexo <span class="glyphicon glyphicon-heart"></span> :</label>
                    <div class="controls col-md-5">
                        <select name="sexo" required>
                            <option value="M">Masculino</option>
                            <option value="F">Feminino</option>
                            <option value="O">Outros</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroNascimento}">
                        <script>alert("Erro na data de nascimento!")</script>
                    </c:if>
                    <label for="example-date-input" class="control-label col-md-4">* Nascimento <span class="glyphicon glyphicon-baby-formula" ></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="date" name="nascimento" id="datanasc" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroRua}">
                        <script>alert("Erro na rua!")</script>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Rua <span class="glyphicon glyphicon-road"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="50" class="form-control" name="rua" placeholder="Insira rua" type="text" id="rua" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroNumero}">
                        <script>alert("Erro no número!")</script>
                    </c:if>
                    <label for="example-number-input" class="control-label col-md-4">* Número <span class="fa fa-sort-numeric-desc"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="5" class="form-control" min="0" type="number" name="numero" placeholder="Insira numero"  id="numero" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Complemento <span class="fa fa-flag"></span> :</label>
                    <div class="controls col-md-5">
                        <input  maxlength="20" class="form-control" name="complemento" placeholder="Insira complemento"  type="text" id="complemento">
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCep}">
                        <script>alert("Erro no cep!")</script>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* CEP <span class="glyphicon glyphicon-map-marker"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="9" required class="form-control" name="cep"  type="text" id="cep" required>
                    </div>
                </div>

                <div class="form-group">
                    <c:if test="${erroCidade}">
                        <script>alert("Erro na cidade!")</script>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Cidade <span class="glyphicon glyphicon-globe"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" name="cidade" placeholder="Insira cidade" type="text" id="cidade" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">* Estado <span class="glyphicon glyphicon-globe"></span> :</label>
                    <div class="controls col-md-5">
                        <select name="estado" required>
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
                        <input maxlength="15" class="form-control" name="celular" type="text" id="celular">
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-text-input" class="control-label col-md-4">Telefone <span class="glyphicon glyphicon-earphone"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="14" class="form-control" name="telefone" type="text" id="telefone">
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroEmail}">
                        <script>alert("Erro no email!")</script>
                    </c:if>
                    <label for="example-email-input" class="control-label col-md-4">* Email <span class="glyphicon glyphicon-envelope"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="50" class="form-control" type="email" name="email" placeholder="Insira email" id="email" data-error="Por favor, informe um e-mail correto." required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroDepartamento}">
                        <script>alert("Erro no departamento!")</script>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Departamento <span class="glyphicon glyphicon-inbox"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" placeholder="Insira departamento" name="departamento" id="departamento" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroCargo}">
                        <script>alert("Erro no cargo!")</script>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Cargo <span class="glyphicon glyphicon-lock"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" placeholder="Insira cargo" name="cargo" id="cargo" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroFilial}">
                        <script>alert("Erro na filial!")</script>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Filial <span class="fa fa-rss"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" placeholder="Insira filial" name="filial" id="filial" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroLogin}">
                        <script>alert("Erro no login!")</script>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Login <span class="fa fa-sign-in"></span> :</label>
                    <div class="controls col-md-5">
                        <input maxlength="100" class="form-control" placeholder="login" name="login" id="login" value="" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroSenha}">
                        <script>alert("Erro na senha!")</script>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Senha <span class="glyphicon glyphicon-th"></span> :</label>
                    <div class="controls col-md-5">
                        <input type="password" maxlength="100" class="form-control" placeholder="senha" name="senha" id="senha" value="" required>
                    </div>
                </div>
                <div class="form-group">
                    <c:if test="${erroAcesso}">
                        <script>alert("Erro no acesso!")</script>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Acesso <span class="glyphicon glyphicon-eye-open"></span> :</label>
                    <div class="controls col-md-5">
                        <select name="acesso" required>
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
                    <button type="submit" style="width: 800px" class="btn btn-primary botao_g"><span class="glyphicon glyphicon-floppy-saved"> Cadastrar</span></button>
                </div>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>