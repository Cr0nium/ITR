

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Авторизация</title>
    </head>
    <body>
        <form action="main.jsp" method="post">
            Login: <input type="text" name = "login"/>
            Password: <input type="password" name = "password"/>
            <input type="submit" name="enter" value="enter"/>
            <input type="submit" name="register" value="register"/>
        </form>
    </body>
</html>
