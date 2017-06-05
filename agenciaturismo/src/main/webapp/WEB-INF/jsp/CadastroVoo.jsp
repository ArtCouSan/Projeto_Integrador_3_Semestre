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
        <script src="./bootstrap/js/aceitacoes.js" type="text/javascript" ></script>
        <title>Cadastro de Voo</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="panel-body">
            
            <form action="CadastroVoo" onsubmit="return confirmar('cadastrar')"  method="post" class="form-horizontal">
                
                <div class="form-group ">
                    <c:if test="${erroOrigem}">
                        <div class="erro">Digite a origem</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Origem <span class="glyphicon glyphicon-home"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="origem" placeholder="Insira a origem" type="text" id="example-text-input" required> 
                    </div>
                </div>
                
                <div class="form-group ">
                    <c:if test="${erroDestino}">
                        <div class="erro">Digite o destino</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Destino <span class="glyphicon glyphicon-pushpin"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="destino" placeholder="Insira o destino" type="text" id="example-text-input" required>
                    </div>
                </div>
                
                <div class="form-group ">

                    <c:if test="${erroQuantidade_passagens}">
                        <div class="erro">Digite a quantidade de passagens</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Quantidade de passagens <span class="glyphicon glyphicon-plane"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="number" name="quantidade_passagens" placeholder="Insira quantidade de passagens" id="example-text-input" required>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="example-date-input" class="control-label col-md-4">* Data de ida <span class="glyphicon glyphicon-calendar"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="data_ida" placeholder="Insira data de ida" type="date" id="example-date-input" required>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="example-date-input" class="control-label col-md-4">* Data de volta <span class="glyphicon glyphicon-calendar"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="data_volta" placeholder="Insira data de volta" type="date" id="example-date-input" required>
                    </div>
                </div>
                
                <div class="form-group">
                    <c:if test="${erroPreco}">
                        <div class="erro">Digite o preço</div>
                    </c:if>
                    <label for="example-number-input" class="control-label col-md-4">* Preço <span class="glyphicon glyphicon-usd"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="number" name="preco" placeholder="Insira o preço" id="example-number-input" required>
                    </div>
                </div>
                
                <div class="col-lg-offset-4">
                    <button type="submit" style="width: 555px" class="btn btn-primary botao_g"><span class="glyphicon glyphicon-floppy-saved"> Cadastrar</span></button>
                </div>

            </form>
            
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
