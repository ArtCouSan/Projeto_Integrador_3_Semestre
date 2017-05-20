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
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="/jsp/Layout/cabecalho.jsp"/>
        <div class="container-fluid">
            <section class="container">
                <div class="container-page">				
                    <div class="col-md-6">
                        <h3 class="dark-grey">Registration</h3>

                        <div class="form-group col-lg-12">
                            <label>CPF:</label>
                            <label name="cpf" class="form-control" value="<c:out value="${cpf}"/>"></label>
                        </div>

                        <div class="form-group col-lg-6">
                            <label>Usuário:</label>
                            <label  name="usuario" class="form-control" value="<c:out value="${user}"/>"></label>
                        </div>

                        <div class="form-group col-lg-6">
                            <label>Repeat Password</label>
                            <input type="password" name="" class="form-control" id="" value="">
                        </div>

                        <div class="form-group col-lg-6">
                            <label>Email Address</label>
                            <input type="" name="" class="form-control" id="" value="">
                        </div>

                        <div class="form-group col-lg-6">
                            <label>Repeat Email Address</label>
                            <input type="" name="" class="form-control" id="" value="">
                        </div>			

                        <div class="col-sm-6">
                            <input type="checkbox" class="checkbox" />Sigh up for our newsletter
                        </div>

                        <div class="col-sm-6">
                            <input type="checkbox" class="checkbox" />Send notifications to this email
                        </div>				

                    </div>
                    <div class="container">
                        <br />
                        <div class="row">

                            <div class="dual-list list-left col-md-5">
                                <div class="well text-right">
                                    <div class="row">
                                        <div class="col-md-10">
                                            <div class="input-group">
                                                <span class="input-group-addon glyphicon glyphicon-search"></span>
                                                <input type="text" name="SearchDualList" class="form-control" placeholder="search" />
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="btn-group">
                                                <a class="btn btn-default selector" title="select all"><i class="glyphicon glyphicon-unchecked"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                    <ul class="list-group">
                                        <li class="list-group-item">bootstrap-duallist <a href="https://github.com/bbilginn/bootstrap-duallist" target="_blank">github</a></li>
                                        <li class="list-group-item">Dapibus ac facilisis in</li>
                                        <li class="list-group-item">Morbi leo risus</li>
                                        <li class="list-group-item">Porta ac consectetur ac</li>
                                        <li class="list-group-item">Vestibulum at eros</li>
                                    </ul>
                                </div>
                            </div>

                            <div class="list-arrows col-md-1 text-center">
                                <button class="btn btn-default btn-sm move-left">
                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                </button>

                                <button class="btn btn-default btn-sm move-right">
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                </button>
                            </div>

                            <div class="dual-list list-right col-md-5">
                                <div class="well">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="btn-group">
                                                <a class="btn btn-default selector" title="select all"><i class="glyphicon glyphicon-unchecked"></i></a>
                                            </div>
                                        </div>
                                        <div class="col-md-10">
                                            <div class="input-group">
                                                <input type="text" name="SearchDualList" class="form-control" placeholder="search" />
                                                <span class="input-group-addon glyphicon glyphicon-search"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <ul class="list-group">
                                        <li class="list-group-item">Cras justo odio</li>
                                        <li class="list-group-item">Dapibus ac facilisis in</li>
                                        <li class="list-group-item">Morbi leo risus</li>
                                        <li class="list-group-item">Porta ac consectetur ac</li>
                                        <li class="list-group-item">Vestibulum at eros</li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </div>

            </section>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
