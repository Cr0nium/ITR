<%-- 
    Document   : register
    Created on : 30.10.2017, 13:22:03
    Author     : timur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
       
        <title>Registration</title>
    </head>
    <body>
        <div class="container">
            <h3 class="form-title">Заполните форму</h3>
            <form action="Register" method="post" class="form" id="js-register-form">
                
                <div class="form-group">
                    <input type="text" placeholder="Ваш логин" name="loginRegister" class="form-input">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Пароль" name="passwordRegister" id="form-pswd1" class="form-input">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Повторите пароль" name="passwordRegister2" class="form-input">
                </div>
                <div class="form-group">
                    <button type="submit" class="form-btn" name="register" value="register">Отправить</button>
                </div>  
            </form>
        </div>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="js/custom.js"></script>
    </body>
</html>
