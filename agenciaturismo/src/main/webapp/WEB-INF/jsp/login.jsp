<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css"  href="./bootstrap/css/login.css" rel="stylesheet" />
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div class="card card-container">
                <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
                <p id="profile-name" class="profile-name-card"></p>
                <form action="login" method="post" class="form-signin">
                    <span id="reauth-email" class="reauth-email"></span>
                    <div>
                        <label for="txtusuario">Login:</label>
                        <input type="text" class="form-control" name="usuario" id="txtusuario" placeholder="Usuario" required/>
                    </div>
                    <div>
                        <label for="txtsenha">Senha:</label>
                        <input type="password" class="form-control" name="senha" id="txtsenha" placeholder="Senha" required/>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Entrar</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>