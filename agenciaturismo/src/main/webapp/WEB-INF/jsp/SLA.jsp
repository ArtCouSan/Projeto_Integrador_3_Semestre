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
        <title>Chamado - Usuarios</title>
    </head>
    <body>
        <c:import url="./cabecalho.jsp"/>      
        <div class="report">
            <h2 class="text-center"><span class="glyphicon glyphicon-wrench"></span> Reportar Problema com aplicação ou infraestrutura</h2>
            <form class="doo" method="post" action="CadastrarSLA" >
                <div class="container"> 
                    <fieldset>
                        <div class="row">
                            <div class="col-lg-offset-3">
                                <div class="form-group row">
                                    <div class="col-sm-12">
                                        <input type="radio" name="mensagem" value="Rede" id="frm-test-elm-140" />
                                        <div class="btn-group">
                                            <label for="frm-test-elm-140" class="btn btn-default">
                                                <span class="content">Sem internet ou falha de compartilhamento</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12">
                                        <input type="radio" name="mensagem" value="Equipamento" id="frm-test-elm-140-1" />
                                        <div class="btn-group">
                                            <label for="frm-test-elm-140-1" class="btn btn-primary">
                                                <span class="content">Equipamento do colega não liga ou esta com defeito.</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12">
                                        <input type="radio" name="mensagem" value="Aplicacao" id="frm-test-elm-140-2" />
                                        <div class="btn-group">
                                            <label for="frm-test-elm-140-2" class="btn btn-success">
                                                <span class="content">Aplicação apresenta erros.</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12">
                                        <input type="radio" name="mensagem" value="Aplicacao" id="frm-test-elm-140-3"/>
                                        <div class="btn-group">
                                            <label for="frm-test-elm-140-3" class="btn btn-info">
                                                <span class="content">Ajuda no uso da aplicação.</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12">
                                        <input type="radio" name="mensagem" value="Sistema" id="frm-test-elm-140-4" />
                                        <div class="btn-group">
                                            <label for="frm-test-elm-140-4" class="btn btn-warning">
                                                <span class="content">Computador muito lento.</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12">
                                        <input type="radio" name="mensagem" value="Outros" id="frm-test-elm-140-5" />
                                        <div class="btn-group">
                                            <label for="frm-test-elm-140-5" class="btn btn-danger">
                                                <span class="content">Demais assuntos na area.</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="clearfix col-lg-offset-4">
                    <button style="width: 700px" class="btn btn-primary btn-block">Enviar <span class="glyphicon glyphicon-send"></span></button>
                </div>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>

