<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleRegister.css">
        <title>Registration</title>
    </head>
    <body>
      <script src="bower_components/jquery/dist/jquery.min.js"></script>
      <script src="bower_components/jquery-validation/dist/jquery.validate.min.js"></script>
      <script src="js/customRegister.js"></script>
        <div class="container">
            <h3 class="formTitle"><a id="refresh" href="register.jsp">Заполните форму</a></h3>
            <form action="Register" method="post" class="form" id="jsRegisterForm">
                <div class="formGroup">
                    <input type="text" placeholder="Ваш логин" name="loginRegister" 
                           class="formInput">
                </div>
                <div class="formGroup">
                    <input type="password" placeholder="Пароль" name="passwordRegister" 
                           id="firstPassword" class="formInput">
                </div>
                <div class="formGroup">
                    <input type="password" placeholder="Повторите пароль" name="passwordRegisterRepeat" 
                           class="formInput">
                </div>
                <div class="formGroup">
                    <button type="submit" class="buttonLogout" name="register" 
                            value="register">Отправить</button>
                </div>
            </form>
                <div id="informationMessage" style="color: #FF0000;">
                    ${userRepeats}
                </div>
        </div>
    </body>
</html>
