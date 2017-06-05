<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <script src="./bootstrap/js/camposMascara.js" type="text/javascript" ></script>
        <script src="./bootstrap/js/aceitacoes.js" type="text/javascript" ></script>
        <title>Editar Voo</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="panel-body">
            
            <form name="editav" onsubmit="return confirmar('alterar')" action="EditarVoo" method="post" class="form-horizontal">
                
                <input type="hidden" name="identificacao" value="${voos.getId()}"/>
                
                <div class="form-group ">
                    <c:if test="${erroOrigem}">
                        <div class="erro">Digite a origem</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Origem <span class="glyphicon glyphicon-home"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="origem" value="${voos.getOrigem()}"type="text" id="example-text-input" required> 
                    </div>
                </div>
                    
                <div class="form-group ">
                    <c:if test="${erroDestino}">
                        <div class="erro">Digite o destino</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Destino <span class="glyphicon glyphicon-pushpin"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="destino" value="${voos.getDestino()}" type="text" id="example-text-input" required>
                    </div>
                </div>
                    
                <div class="form-group ">
                    <c:if test="${erroQuantidade_passagens}">
                        <div class="erro">Digite a quantidade de passagens</div>
                    </c:if>
                    <label for="example-text-input" class="control-label col-md-4">* Quantidade de passagens <span class="glyphicon glyphicon-plane"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="number" name="quantidade_passagens" value="${voos.getQuantidade_passagens()}" id="example-text-input" required>
                    </div>
                </div>
                    
                <div class="form-group">
                    <label for="example-date-input" class="control-label col-md-4">* Data de ida <span class="glyphicon glyphicon-calendar"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="data_ida" value="${voos.getData_ida()}" type="date" id="example-date-input" required>
                    </div>
                </div>
                    
                <div class="form-group">
                    <c:if test="${erroData_volta}">
                        <div class="erro">O nome é obrigatório</div>
                    </c:if>
                    <label for="example-date-input" class="control-label col-md-4">* Data de volta <span class="glyphicon glyphicon-calendar"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="data_volta" value="${voos.getData_volta()}" type="date" id="example-date-input" required>
                    </div>
                </div>
                    
                <div class="form-group">
                    <c:if test="${erroPreco}">
                        <div class="erro">Digite um valor</div>
                    </c:if>
                    <label for="example-number-input" class="control-label col-md-4">* Preço <span class="glyphicon glyphicon-usd"></span> :</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="number" name="preco" value="${voos.getPreco()}" id="example-number-input" required>
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
