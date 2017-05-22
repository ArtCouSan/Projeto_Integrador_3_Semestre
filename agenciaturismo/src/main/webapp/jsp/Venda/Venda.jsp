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
                            <div class="col-sm-5">
                                <div id="custom-search-input">
                                    <div class="input-group col-md-12">
                                        <input type="text" class="form-control input-sm" placeholder="Buscar" />
                                        <span class="input-group-btn">
                                            <button class="btn btn-info btn-sm" type="button">
                                                <i class="glyphicon glyphicon-search"></i>
                                            </button>
                                        </span>
                                    </div>
                                </div>
                                <br/>
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
                                        </t
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
            </section>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/prettify/r298/prettify.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
        <script src="./bootstrap/js/multiselect.min.js" type="text/javascript" ></script>
    </body>
</html>
