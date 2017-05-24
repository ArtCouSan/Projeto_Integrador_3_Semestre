<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <title>JSP Page</title>
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
                                <input name="pesquisaVoo" type="text" placeholder="Insira pesquisa" class="input-medium search-query">
                                <button type="submit" class="btn">Pesquisar</button>
                            </div>
                            <table class="table table-striped">
                                <thead>
                                    <tr class="info">
                                        <th>Origem</th>
                                        <th>Destino</th>
                                        <th>Dt.ida</th>
                                        <th>Dt.volta</th>
                                        <th>Qt. de passagens</th>
                                        <th>Preço</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="voos" items="${encontrados}">
                                        <tr>
                                            <td name="origem"><c:out value="${voos.getOrigem()}"/></td>
                                            <td name="destino"><c:out value="${voos.getDestino()}"/></td>
                                            <td name="data_ida"><c:out value="${voos.getData_ida()}"/></td>
                                            <td name="data_volta"><c:out value="${voos.getData_volta()}"/></td>
                                            <td name="quantidade_passagens"><c:out value="${voos.getQuantidade_passagens()}"/></td>
                                            <td name="preco"><c:out value="${voos.getPreco()}"/></td>
                                            <td></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="container-page">
                    <div id="wrap" class="container">
                        <div class="row">
                            <div class="controls col-md-5">
                                <input name="pesquisaHotel" type="text" placeholder="Insira pesquisa" class="input-medium search-query">
                                <button type="submit" class="btn">Pesquisar</button>                    
                            </div>
                            <table class="table table-striped">
                                <thead>
                                    <tr class="info">
                                        <th>Nome</th>
                                        <th>Data de entrada</th>
                                        <th>Data de saida</th>
                                        <th>Preco</th>
                                        <th>Quantidade de quartos</th>
                                        <th>Quantidade de hospedes</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="hoteis" items="${encontrados}">
                                        <tr >
                                            <td name="nome"><c:out value="${hoteis.getNome_hotel()}"/></td>
                                            <td name="data_entrada"><c:out value="${hoteis.getData_entrada()}"/></td>
                                            <td name="data_saida"><c:out value="${hoteis.getData_saida()}"/></td>
                                            <td name="preco"><c:out value="${hoteis.getPreco()}"/></td>
                                            <td name="quantidade_quartos"><c:out value="${hoteis.getQuantidade_quartos()}"/></td>
                                            <td name="quantidade_hospedes"><c:out value="${hoteis.getQuantidade_hospedes()}"/></td>
                                        </c:forEach>
                                </tbody>
                            </table>
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
