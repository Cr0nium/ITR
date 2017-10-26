
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Servlets.Item"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Searcge</title>
    </head>
    <body>
        
        <table border="1">
            <thead>
                <tr>
                    <th>ФИО</th>
                    <th>Устройство</th>
                    <th>id</th>
                    <th>Серийный номер</th>
                    <th>Об устройстве</th>
                    <th>Дата выдачи</th>
                    <th>На срок</th>
                </tr>
            </thead>
            <tbody>
                <%  List<Item> itemList = (List) request.getAttribute("itemlist");
                    for(Item item:itemList) {%>
                <tr>
                    <td><%out.println(item.getFio());%></td>
                    <td><%out.println(item.getDevaice());%></td>
                    <td><%out.println(item.getId());%></td>
                    <td><%out.println(item.getSN());%></td>
                    <td><%out.println(item.getStats());%></td>
                    <td><%out.println(item.getDate());%></td>
                    <td><%out.println(item.getPeriod());%></td>
                </tr>
                <%}%>
            </tbody>
        </table>           
       
    </body>
</html>
