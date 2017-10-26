<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ITResurces</title>
    </head>
    <body>
        <form action="StartServlet" method="post">
          <table border="0">
            <thead>
                <tr>
                    <th>ITResurces</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>ФИО:</td>
                    <td><input type="text" name = "fio"/></td>
                    <td>Об устройстве:</td>
                    <td rowspan="2"><textarea name="stats" rows="4" cols="20">
                        </textarea></td>
                        
                </tr>
                <tr>
                    <td>Устройство:</td>
                    <td><select name="devaice">
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
                        </select></td>
                    <td></td>
                    <td></td>
                    
                </tr>
                <tr>
                    <td>Id:</td>
                    <td><input type="text" name = "id"/></td>
                    <td>Дата выдачи:</td>
                    <td><input type="date" name = "date"/></td>
                    
                </tr>
                <tr>
                    <td>Серийный номер:</td>
                    <td><input type="text" name = "SN"/></td>
                    <td>На срок(дней):</td>
                    <td><input type="text" name = "period"/></td>
                    
                </tr>
                <tr>
                    <td><input type="submit" name="Add" value="add"/></td>
                    <td><input type="submit" name="Update" value="update"/></td>
                    <td><input type="submit" name="Delete" value="delete"/></td>
                    <td></td>
                    
                </tr>
            </tbody>
          </table>
        </form>    
            
        <form action="Searche" method="post">
            ФИО: <input type="text" name = "fioSearche"/><br/> 
            Устройство: <select name="devaiceSearche">
                            <option></option>
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
                        </select><br/>
            <input type="submit" name="Searche" value="searche"/>            
        </form>
        
            <sql:query var="resurces" dataSource="jdbc/ITR">
                SELECT * FROM resurces
            </sql:query>
                
            <table border="1">
                <!-- column headers -->
                <tr>
                <c:forEach var="columnName" items="${resurces.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                </c:forEach>
                </tr>
                <!-- column data -->
                <c:forEach var="row" items="${resurces.rowsByIndex}">
                    <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>
                    </c:forEach>
                    </tr>
                </c:forEach>
            </table>
      
    </body>
</html>
