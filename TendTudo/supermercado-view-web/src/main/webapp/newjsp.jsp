<%-- 
    Document   : newjsp
    Created on : 31 de out. de 2022, 11:26:08
    Author     : USER
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            for(int i = 1; i<10;i++){
                out.println("Teste 1 2 3"+ "<br>");
            }
        %>
        
        <%@ include file="index.html" %>
        
    </body>
</html>
