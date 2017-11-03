<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleMain.css">
        <title>ITResources</title>
    </head>
    <body>
        <div class="containerMain">
            <div class="containerAddUpdateDelete">
                <h3 class="formTitle"> <a id="refresh" href="main.jsp">Заполните информацию</a></h3>
                    <form action="DispatcherMain" method="post" id="jsAddUpdateDeleteForm">
                        <div class="formGroup">
                            <input type="text" placeholder="ФИО" name="fio" class="AddUpdateDelete">
                        </div>
                        <div class="formGroup"> 
                            <select name="device" class="AddUpdateDelete">
                                <option disabled selected 
                                    value="Выберите устройство:">Выберите устройство:</option>
                                <option>Ноутбук</option>
                                <option>Монитор</option>
                                <option>Компьютер</option>
                                <option>Процессор</option>
                                <option>Мат.Плата</option>
                                <option>Оперативная память</option>
                                <option>Жесткий диск</option>
                                <option>Мышка</option>
                                <option>Клавиатура</option>
                                <option>Иное</option>
                            </select></div>
                            <div class="formGroup">
                                <input type="text" placeholder="Id" name="id" 
                                    class="AddUpdateDelete">
                            </div>
                            <div class="formGroup">
                                <input type="text" placeholder="Серийный номер" name="SN" 
                                    class="AddUpdateDelete">
                            </div>
                            <div class="formGroup">
                                <textarea name="stats" rows="4" cols="20" placeholder="Об устройстве" 
                                    class="AddUpdateDelete" id="stats"></textarea>
                            </div>
                            <div class="formGroup">
                                <input type="date" name = "date" class="AddUpdateDelete"/>
                            </div>
                            <div class="formGroup">
                                <input type="text" placeholder="На срок (дней)" name="period" 
                                    class="AddUpdateDelete">
                            </div>
                            <div class="buttonsContainer">
                                <button type="submit" class="buttons" id="buttonAdd" 
                                    name="Add" value="add">Добавить</button>
                                <button type="submit" class="buttons" id="buttonUpdate" 
                                    name="Update" value="update">Изменить</button>
                                <button type="submit" class="buttons" id="buttonDelete" 
                                    name="Delete" value="delete">Удалить</button>
                            </div>
                    </form>
            </div> 
            <div class="containerSearch">
                <h3 class="formTitle">Введите данные для поиска</h3>
                    <form action="Search" method="get" class="formSearch">
                        <div class="formGroup">
                            <input type="text" placeholder="ФИО" name="fioSearch" class="search">
                        </div>
                        <div class="formGroup"> 
                            <select name="deviceSearch" class="search">
                                <option selected value="Выберите устройство:">Выберите устройство:</option>
                                <option>Ноутбук</option>
                                <option>Монитор</option>
                                <option>Компьютер</option>
                                <option>Процессор</option>
                                <option>Мат.Плата</option>
                                <option>Оперативная память</option>
                                <option>Жесткий диск</option>
                                <option>Мышка</option>
                                <option>Клавиатура</option>
                                <option>Иное</option>
                            </select>
                        </div>
                        <div>
                            <button type="submit" class="buttonSearch" 
                                name="Search" value="search">Поиск</button>
                        </div>
                    </form>
            </div>
            <div class="containerTable">
                <div>
                    <label id="lableStatus">Статус:</label> 
                    <div style="color: #66a3ff;"id="statusBar">
                        ${addComplit}
                        ${deleteComplit}
                        ${updateComplit}
                        ${addFail}
                        ${updateFail}
                        ${deleteFail}
                    </div>
                    <form action="LogoutServlet" method="get" class="logOutForm">
                        <button type="submit" class="buttonLogout" name="LogOut" 
                            value="logOut">Сменить пользователя</button>
                    </form>
                </div>
                <div id="tableResult">
                    <sql:query var="resources" dataSource="jdbc/ITR">
                         SELECT * FROM resources
                    </sql:query>
                    <table border="1">
                        <tr>
                            <th>ФИО</th>
                            <th>Устройство</th>
                            <th>id</th>
                            <th>Серийный номер</th>
                            <th>Об устройстве</th>
                            <th>Дата выдачи</th>
                            <th>На срок</th>
                        </tr>
                        <c:forEach var="row" items="${resources.rowsByIndex}">
                            <tr>
                                <c:forEach var="column" items="${row}">
                                    <td id="tableColumn"><c:out value="${column}"/></td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div> 
      <script src="bower_components/jquery/dist/jquery.min.js"></script>
      <script src="bower_components/jquery-validation/dist/jquery.validate.min.js"></script>
      <script src="js/customMainForm.js"></script> 
    </body>
</html>
