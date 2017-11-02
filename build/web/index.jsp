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
            <h3 class="formTitle">Введите Логин и Пароль</h3>
            <form action="DispatcherLogin" method="post" class="form">
                <div class="formGroup">
                    <input type="text" placeholder="Логин" name="login" class="formInput">
                </div>
                <div class="formGroup">
                    <input type="password" placeholder="Пароль" name="password" class="formInput">
                </div>
                <div class="formGroup">
                    <button type="submit" class="formButton" id="buttonEnter" 
                            name="enter" value="enter">Войти</button>
                    <button type="submit" class="formButton" id="buttonRegister" 
                            name="register" value="register">Регистрация</button>
                </div>
                
            </form>
                <div id="informationMessage" style="color: #FF0000;">
                    ${errorMessage}
                    ${userRepeats}
                </div>
                <div id="informationMessage" style="color: #00cc44;">
                    ${userAdd}
                </div>
        </div>
    </body>
</html>
