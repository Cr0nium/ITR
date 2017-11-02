<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleMain.css">
        <title>ITResurces</title>
    </head>
    <body>
                <div class="containerMain">
                    <div class="containerAddUpdateDelete">
                        <h3 class="form-title"> <a id="refresh" href="main.jsp">Заполните информацию</a></h3>
                        <form action="StartServlet" method="post" id="AddUpdateDeleteForm">
                            <div class="form-group">
                                <input type="text" placeholder="ФИО" name="fio" class="AddUpdateDelete">
                            </div>
                            
                            <div class="form-group"> <select name="devaice" class="AddUpdateDelete">
                            
                            <option disabled selected value="Выберите устройство:">Выберите устройство:</option>
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
                            
                            <div class="form-group">
                                <input type="text" placeholder="Id" name="id" class="AddUpdateDelete">
                            </div>
                            
                            <div class="form-group">
                                <input type="text" placeholder="Серийный номер" name="SN" class="AddUpdateDelete">
                            </div>
                            
                            <div class="form-group">
                                <textarea name="stats" rows="4" cols="20" placeholder="Об устройстве" class="AddUpdateDelete" id="stats"></textarea>
                            </div>
                            
                            <div class="form-group">
                                <input type="date" name = "date" class="AddUpdateDelete"/>
                            </div>
                            
                            <div class="form-group">
                                <input type="text" placeholder="На срок(дней)" name="period" class="AddUpdateDelete">
                            </div>
                            
                            <div class="btn-container">
                                <button type="submit" class="form-btn1" name="Add" value="add">Добавить</button>
                                <button type="submit" class="form-btn2" name="Update" value="update">Изменить</button>
                                <button type="submit" class="form-btn3" name="Delete" value="delete">Удалить</button>
                            </div>
                        </form>
                    </div> 
                    <div class="containerSearch">
                        <h3 class="form-title">Введите данные для поиска</h3>
                        <form action="Searche" method="post" class="formSearch">
                            <div class="form-group">
                                <input type="text" placeholder="ФИО" name="fioSearche" class="search">
                            </div>
                            <div class="form-group"> <select name="devaiceSearche" class="search">
                            
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
                        </select></div>
                            <div>
                                <button type="submit" class="btnSearch" name="Searche" value="searche">Поиск</button>
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
                                ${accessDenied}
                            </div>
                            <form action="LogoutServlet" method="get" class="logOutForm">
                            <button type="submit" class="form-btn" name="LogOut" value="logOut">Сменить пользователя</button>
                            </form></div>
                        
                        <div id="tableResult">
                        <sql:query var="resurces" dataSource="jdbc/ITR">
                             SELECT * FROM resurces
                        </sql:query>
                
                        <table border="1">
                         <!-- column headers -->
                        <tr>
                        <th>ФИО</th>
                        <th>Устройство</th>
                        <th>id</th>
                        <th>Серийный номер</th>
                        <th>Об устройстве</th>
                        <th>Дата выдачи</th>
                        <th>На срок</th>
                        </tr>
                        <!-- column data -->
                        <c:forEach var="row" items="${resurces.rowsByIndex}">
                         <tr>
                        <c:forEach var="column" items="${row}">
                            <td id="tableColum"><c:out value="${column}"/></td>
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
