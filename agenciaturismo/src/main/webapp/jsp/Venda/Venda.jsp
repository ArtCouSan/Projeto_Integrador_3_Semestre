<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <script src="./bootstrap/js/vendaEventosBusca.js"></script>
        <title>Venda</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <div class="container-fluid">
            <section class="container">
                <div class="container-page">				
                    <div class="col-md-6">
                        <div class="form-group col-lg-10">
                            <label>Total</label>
                            <label  name="total" class="form-control"></label>
                        </div>
                        <div class="form-group col-lg-10">
                            <label>Quantidade</label>
                            <label  name="total" class="form-control"></label>
                        </div>
                    </div>
                </div>
                <div class="container-page ">	
                    <div class="form-group col-sm-4 col-lg-push-1">
                        <label>Usuário:</label>
                        <label  name="usuario" class="form-control">${user}</label>
                    </div>
                    <div class="form-group col-sm-4 col-lg-push-1">
                        <label>CPF:</label>
                        <label name="cpf" class="form-control">${cpf}</label>
                    </div>		
                </div>
                <div class="container-page">
                    <div id="wrap" class="container">
                        <div class="row">
                            <div class="controls col-md-5">
                                <input name="pesquisaVoo" id="pesquisaVoo" type="text" placeholder="Insira pesquisa" class="input-medium search-query pesquisaVoo">
                                <button onclick="pesquisaVoo()" type="submit" class="btn">Pesquisar Voo</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container-page">
                    <div id="wrap" class="container">
                        <div class="row">
                            <div class="controls col-md-5">
                                <input name="pesquisaHotel" id="pesquisaHotel" type="text" placeholder="Insira pesquisa" class="input-medium search-query pesquisaHotel">
                                <button onclick="pesquisaHotel()" type="submit" class="btn">Pesquisar Hotel</button>                    
                            </div>                        
                        </div>
                    </div>
                </div>
                <div class="container-page">
                    <table class="table table-striped" id="table">

                    </table>
                </div>
            </section>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/prettify/r298/prettify.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
        <script src="./bootstrap/js/multiselect.min.js" type="text/javascript" ></script>
    </body>
</html>
