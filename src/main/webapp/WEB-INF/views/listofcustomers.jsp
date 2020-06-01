<%-- 
    Document   : productlist
    Created on : 07-May-2020, 13:37:33
    Author     : mac
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>products' List</title>
    </head>
    <body>
        <h1>products' List</h1>
        <table>
		<tr>
                    <td>ID</td><td>FirstName</td><td>LastName</td><td>email</td><td>address</td><td>telephone</td>
		</tr>
		<c:forEach items="${customers}" var="customer">
			<tr>
                           

                            <td>${customer.customerId}</td>
                            <td>${customer.firstName}</td>
                            <td>${customer.lastName}</td>
                            <td>${customer.email}</td>
                               <td>${customer.address}</td>
                                  <td>${customer.phoneNumber}</td>
                            
			</tr>
		</c:forEach>
	</table>
    </body>
</html>
