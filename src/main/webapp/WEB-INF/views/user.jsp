<%-- 
    Document   : user
    Created on : 26 ??? 2020, 7:20:22 ??
    Author     : user
--%>

<!DOCTYPE html>
<html>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>USER DETAILS</title>

    </head>
    <body>
        <!--Clients-->
        <div class="container-fluid" id="navbarid">
        </div>
        <div id="includedContent"></div>
        <h1>Clients</h1>
        <!--<h1>Users</h1>-->
        <div class="container">
            <table class="table table-hover">
                <thead class="bg-primary text-white">
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Email</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.email}</td>

                            <!--      <td align="right">
                                        <a href="<c:url value='${editurl}/${user.id}' />" class="btn btn-warning">
                                            <span class="fa fa-pencil"></span> Update
                                        </a>
                                        <a href="<c:url value='${deleteurl}/${user.id}' />" class="btn btn-danger">
                                            <span class="fa fa-trash"></span> Delete
                                        </a>
                                    </td>-->  
                            <!--          -->    
                        </tr>
                    </c:forEach>

                </tbody>

            </table>
            <a href="new" class="btn btn-success">
                <span class="fa fa-plus"></span> Add
            </a>
        </div>

        <div id="msg">${msg}</div>




        <!--All products purchased-->

        <div class="container-fluid" id="navbarid"> </div>
        <div id="includedContent"></div>
        <h1>Orders' List</h1>
        <!--<h1>Users</h1>-->
        <div class="container">
            <table class="table table-hover">
                <thead class="bg-primary text-white">
                    <tr>
                        <th>Clients ID</th>
                        <th>Product ID</th>
                        <th>Purchase Date</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>${user.id}</td>
                            <td>${product.id}</td>
                            <td>${order.purchaseDate}</td>

                            <!-- <td align="right">
                                    <a href="<c:url value='${editurl}/${order.id}' />" class="btn btn-warning">
                                        <span class="fa fa-pencil"></span> Update
                                    </a>
                                    <a href="<c:url value='${deleteurl}/${order.id}' />" class="btn btn-danger">
                                        <span class="fa fa-trash"></span> Delete
                                    </a>
                                </td>-->
                        </tr>
                    </c:forEach>

                </tbody>

            </table>
            <a href="new" class="btn btn-success">
                <span class="fa fa-plus"></span> Add
            </a>
        </div>

        <div id="msg">${msg}</div>




        




        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
