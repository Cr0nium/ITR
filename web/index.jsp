

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleIndex.css">
        <title>Авторизация</title>
    </head>
    <body>
                       
       
        
        <div class="containerIndex">
            <h3 class="form-title">Введите Логин и Пароль</h3>
            <form action="AuthRegServlet" method="post" class="form" id="js-auth-form">
                <div class="form-group">
                    <input type="text" placeholder="Логин" name="login" class="form-input">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Пароль" name="password" class="form-input">
                </div>
                <div class="form-group">
                    <button type="submit" class="form-btn" name="enter" value="enter">Ввойти</button>
                    <button type="submit"  class="btn2" name="register" value="register">Регистрация</button>
                </div>
                <div id="incomingMessage" style="color: #FF0000;">${errorMessage}</div>
            </form>
            
            
        </div>
        
        
    </body>
</html>
