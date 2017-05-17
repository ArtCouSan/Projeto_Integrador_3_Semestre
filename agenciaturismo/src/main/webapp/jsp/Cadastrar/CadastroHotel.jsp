<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <title>Cadastro de Hotel</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/CadastroHotel" method="post" class="form-horizontal">
                <div class="form-group ">
                    <label for="example-text-input" class="control-label col-md-4">Nome do Hotel:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="nome_hotel" placeholder="Insira o nome do hotel" type="text" id="example-text-input" required> 
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-date-input" class="control-label col-md-4">Data de entrada:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="data_entrada" placeholder="Insira a data de entrada" type="date" id="example-date-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-date-input" class="control-label col-md-4">Data de saida:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" name="data_saida" placeholder="Insira a data de saida" type="date" id="example-date-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-number-input" class="control-label col-md-4">Quantidade de Quartos:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="number" name="quantidade_quartos" placeholder="Insira a quantidade de quartos" id="example-number-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-number-input" class="control-label col-md-4">Quantidade de Hospedes:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="number" name="quantidade_hospedes" placeholder="Insira a quantidade de hospedes" id="example-number-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="example-number-input" class="control-label col-md-4">Preco:</label>
                    <div class="controls col-md-5">
                        <input class="form-control" type="number" name="preco" placeholder="Insira o preço" id="example-number-input" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="aab controls col-md-4">
                        <div class="controls col-md-8" >
                            <button type="submit"><span class="">Salvar</span></button>
                            <button type="reset"><span class="">Apagar Campos</span></button>
                        </div>
                    </div>
                </div>  
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
