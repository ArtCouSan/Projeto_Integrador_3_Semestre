<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <link type="text/css"  href="./bootstrap/css/particular.css" rel="stylesheet" />
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link type="text/css"  href="./bootstrap/css/font-awesome.css" rel="stylesheet" />
        <script src="./bootstrap/js/feedback.js" type="text/javascript" ></script>
        <title>Feedback - Usuarios</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>      
        <div class="report">
            <h2 class="text-center"><span class="glyphicon glyphicon-wrench"></span> Reportar Problema com aplicação ou infraestrutura</h2>
            <form class="doo" method="post" >
                <div class="col-sm-12">
                    <textarea maxlength="1000" minlength="0" onkeypress="feedback()" onkeydown="feedback()" style="height: 300px" id="mensagem" name="mensagem" class="form-control" ></textarea>
                </div>
                <br/>
                <h4 class="col-lg-offset-6" id="texto"> Maximo 1000 caracteres - 1000 </h4>
                <br/>
                <div class="clearfix col-lg-offset-4">
                    <button class="btn btn-primary btn-block">Enviar <span class="glyphicon glyphicon-send"></span></button>
                </div>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>

