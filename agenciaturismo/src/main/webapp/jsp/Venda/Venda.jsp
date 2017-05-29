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
                            <label id="total" name="total" class="form-control">0</label>
                        </div>
                        <div class="form-group col-lg-10">
                            <label>Quantidade</label>
                            <label  name="total" class="form-control">0</label>
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
                    <div class="form-group col-sm-4 col-lg-push-">
                        <input name="pesquisaVoo" id="pesquisaVoo" type="text" placeholder="Insira pesquisa" class="input-medium search-query pesquisaVoo">
                        <button onclick="pesquisaVoo()" type="submit" class="btn ">Pesquisar Voo</button>
                    </div>
                </div>
                <div class="container-page">
                    <div class="form-group col-sm-4 col-lg-push-3">
                        <div class="form-group">
                            <input name="pesquisaHotel" id="pesquisaHotel" type="text" placeholder="Insira pesquisa" class="input-medium search-query pesquisaHotel">
                            <button onclick="pesquisaHotel()" type="submit" class="btn">Pesquisar Hotel</button>                    
                        </div>
                    </div>
                </div>
                <div class="container-page" >
                    <table class="table table-striped" id="table">

                    </table>
                </div>
                <label class="h3">Carrinho - Hotel</label>
                <div class="container-page">
                    <table class="table table-striped" >
                        <thead>
                            <tr class="info">
                                <th>Nome</th>
                                <th>Data de entrada</th>
                                <th>Data de saida</th>
                                <th>Preco</th>
                                <th>Quantidade de quartos</th>
                                <th>Quantidade de hospedes</th>
                                <th>Remover</th>
                            </tr>
                        </thead>
                        <tbody id="carrinho">

                        </tbody>
                    </table>
                </div>
                <label class="h3">Carrinho - Vôo</label>
                <div class="container-page">
                    <table class="table table-striped">
                        <thead>
                            <tr class="info">
                                <th>Origem</th>
                                <th>Destino</th>
                                <th>Data de ida</th>
                                <th>Data de volta</th>
                                <th>Qtd. de passagens</th>
                                <th>Preco</th>
                                <th>Remover</th>
                            </tr>
                        <thead>
                        <tbody id="carrinho2">

                        </tbody>
                    </table>
                </div>
                <div class="container-page">
                    <div id="wrap" class="container">
                        <div class="row">
                            <div class="controls col-md-5">
                                <button type="submit" onclick="venda()" class="btn">Vender</button>                    
                            </div>                        
                        </div>
                    </div>
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
