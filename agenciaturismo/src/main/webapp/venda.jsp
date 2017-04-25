
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="foundation/css/foundation.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    </head>
    <body>
        <header class="hero-search-filter">
            <div class="hero-search-filter-content">
                <h1>FLIGHT DOWN</h1>
                <form class="hero-search-filter-form" action="">
                    <label for="findtext">Cliente:</label>
                    <input class="hero-search-filter-form-find" type="text" placeholder="CPF" />
                    <button class="button"><i class="fa fa-search"></i></button>
                    <div class="divider">&nbsp;</div>
                    <label for="findlocate">Vendedor:</label>
                    <input class="hero-search-filter-form-near" type="text" placeholder="Identificador"/>
                    <button class="button"><i class="fa fa-search"></i></button>
                </form>
                <ul class="hero-search-filter-menu menu align-center">
                    <li><a href="#"><i class="fa fa-cutlery" aria-hidden="true"></i> Produto</a></li>
                    <li><a href="#"><i class="fa fa-glass" aria-hidden="true"></i> Hotel</a></li>
                    <li><a href="#"><i class="fa fa-wrench" aria-hidden="true"></i> Voo</a></li>
                </ul>
            </div>
        </header>
        <form>
            <div class="form-icons">
                <h4>Register for an account</h4>

                <div class="input-group">
                    <span class="input-group-label">
                        <i class="fa fa-user"></i>
                    </span>
                    <input class="input-group-field" type="text" placeholder="Full name">
                </div>

                <div class="input-group">
                    <span class="input-group-label">
                        <i class="fa fa-envelope"></i>
                    </span>
                    <input class="input-group-field" type="text" placeholder="Email">
                </div>

                <div class="input-group">
                    <span class="input-group-label">
                        <i class="fa fa-key"></i>
                    </span>
                    <input class="input-group-field" type="text" placeholder="Password">
                </div>
            </div>

            <button class="button expanded">Sign Up</button>
        </form>
    </body>
</html>
