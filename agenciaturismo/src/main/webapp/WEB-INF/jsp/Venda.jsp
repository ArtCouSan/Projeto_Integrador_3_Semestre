<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <link type="text/css"  href="./bootstrap/css/font-awesome.css" rel="stylesheet" />
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <script src="./bootstrap/js/vendaEventosBusca.js"></script>
        <title>Venda</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container-fluid">
            <section class="container">
                <div class="container-page">				
                    <div class="col-md-6">
                        <div class="form-group col-lg-10">
                            <label>Total <span class="glyphicon glyphicon-usd"></span> :</label>
                            <label id="total" name="totalP" class="form-control">0</label>
                        </div>
                        <div class="form-group col-lg-10">
                            <label>Filial <span class="fa fa-rss"></span> :</label>
                            <label  name="filial" class="form-control">${funcionario.filial}</label>
                        </div>
                    </div>
                </div>
                <div class="container-page ">	
                    <div class="form-group col-sm-4 col-lg-push-1">
                        <label>Usuário <span class="fa fa-id-card"></span> :</label>
                        <label  name="usuario" class="form-control">${funcionario.nome}</label>
                    </div>
                    <div class="form-group col-sm-4 col-lg-push-1">
                        <label>CPF <span class="glyphicon glyphicon-book"></span> :</label>
                        <label name="cpf" id="cpf" class="form-control">${cpf}</label>
                    </div>		
                </div>
                <div class="container-page form-group">
                    <div class="input-group">
                        <input name="pesquisaVoo" id="pesquisaVoo" type="text" placeholder="Insira pesquisa" class="form-control pesquisaVoo">
                        <span class="input-group-btn">
                            <button onclick="pesquisaVoo()" class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"><span style="margin-left:10px;"> Pesquisar Voo</span></button>
                        </span>                           
                        <input name="pesquisaHotel" id="pesquisahotel" type="text" placeholder="Insira pesquisa" class="form-control pesquisaHotel">
                        <span class="input-group-btn">
                            <button onclick="pesquisaHotel()" class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"><span style="margin-left:10px;"> Pesquisar Hotel</span></button>
                        </span>                           
                    </div>
                </div>
                <div class="container-page" >
                    <table class="table table-striped" id="table">

                    </table>
                </div>
                <label class="h3">Carrinho - Hotel <span class="fa fa-shopping-basket"></span> :</label>
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
                <label class="h3">Carrinho - Vôo <span class="fa fa-shopping-basket"></span> :</label>
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
                <div class="col-lg-offset-4">
                    <button type="submit" onclick="venda()" style="width: 450px" class="btn btn-primary botao_g"><span class="glyphicon glyphicon-shopping-cart"> Vender</span></button>
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
