<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validar Cliente</title>
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <script src="./bootstrap/js/event.js" type="text/javascript" ></script>
        <script src="./bootstrap/js/camposMascara.js" type="text/javascript" ></script>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>
        <div class="container" style="margin-top: 5%;">
            <div class="col-md-6 col-md-offset-3">
                <form role="form"action="PreVenda" method="post">
                    <div class="row">
                        <h1 class="text-center"><span class="fa fa-handshake-o"></span> Validação do cliente</h1>
                        <div class="form-group">
                            <div class="input-group">
                                <input class="form-control" type="text" placeholder="000.000.000-00" name="cpf" id="cpf" required/>
                                <span class="input-group-btn">
                                    <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"><span style="margin-left:10px;">Validar</span></button>
                                </span>                           
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
