<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.min.css" />
        <link type="text/css"  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet" />
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
                            <label>Username</label>
                            <input type="" name="" class="form-control" id="" value="">
                        </div>

                        <div class="form-group col-lg-6">
                            <label>Password</label>
                            <input type="password" name="" class="form-control" id="" value="">
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

                    <div class="col-md-6">
                        <table class="table table-striped">
                            <thead>
                                <tr class="info">
                                    <th>?</th>
                                    <th>?</th>
                                    <th>?</th>
                                    <th>?</th>
                                    <th>?</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="produtos" items="${encontrados}">
                               
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
            </section>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="./bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
